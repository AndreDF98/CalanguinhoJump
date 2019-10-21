package Jogo;

import Menu.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener{

    Menu menu;
    Recordes recordes;
    Creditos creditos;
    GameOver gameover;
    NovoRec novoRec;
    
    Calanguinho calango;
    Cactos cactos;
    Pontos pontos;
    Chao chao;
    Dunas dunas;
    JLabel ceu;
    
    Timer play = new Timer(10,this);
    
    public Board(){
        
        //menu
        menu = new Menu();
        menu.setBounds(0,0,900,600);
        this.add(menu);
        
        creditos = new Creditos();
        creditos.setBounds(0,0,900,600);
        creditos.setLayout(null);
        this.add(creditos);
        creditos.setVisible(false);//comeca invisivel
        
        recordes = new Recordes();
        recordes.setBounds(0,0,900,600);
        recordes.setLayout(null);
        this.add(recordes);
        recordes.setVisible(false);//comeca invisivel
        
        novoRec = new NovoRec();
        novoRec.setBounds(150,350,600,200);
        novoRec.setLayout(null);
        this.add(novoRec);
        novoRec.setVisible(false);//comeca invisivel
        
        gameover = new GameOver();
        gameover.setBounds(0,0,900,600);
        gameover.setLayout(null);
        this.add(gameover);
        gameover.setVisible(false);//comeca invisivel
        
        //jogo
        pontos = new Pontos();
        pontos.setBounds(565,20,305,50);
        this.add(pontos);
        pontos.setVisible(false);//nao eh visivel no menu
        
        calango = new Calanguinho();
        calango.setBounds(0,0,900,600);
        this.add(calango);
        
        cactos = new Cactos();
        cactos.setBounds(0,0,900,600);
        this.add(cactos);
        cactos.setVisible(false);// nao eh visivel no menu
        
        chao = new Chao();
        chao.setBounds(0,0,1800,600);
        this.add(chao);
        
        dunas = new Dunas();
        dunas.setBounds(0,0,1800,600);
        this.add(dunas);
        
        ceu = new JLabel();
        ceu.setBounds(0,0,900,600);
        ceu.setIcon(new ImageIcon(getClass().getResource("images/ceu.png")));
        this.add(ceu);//o ultimo fica por baixo, nas camadas
        
        //Listeners do menu
        
        menu.comecar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                play.start();
                menu.setVisible(false);
                pontos.setVisible(true);
                cactos.setVisible(true);
                cactos.recomecar();
                pontos.recomecar();
                calango.pular.start();
            }
        });
        
        menu.recordes.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                recordes.leArquivo();
                recordes.setVisible(true);
            }
        });
        
        menu.creditos.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                creditos.setVisible(true);
            }
        });
        
        creditos.voltar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                creditos.setVisible(false);
                menu.setVisible(true);
            }
        });
        
        recordes.voltar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                recordes.setVisible(false);
                menu.setVisible(true);
            }
        });
        
        //Listeners do game over
        gameover.restart.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                calango.recomecar();//o calango volta a correr
                calango.pular.restart();
                chao.recomecar();//o chao volta a mover
                dunas.recomecar();//as dunas voltam a mover
                cactos.x = 1800;//o cacto volta ao lugar de origem
                cactos.recomecar();//voltam a mover
                pontos.pts = 0;//os pontos voltam pra 0
                pontos.recomecar();//recomeca o contador
                novoRec.setVisible(false);//não é necessário, mas pode dar erro
                pontos.setVisible(true);
                gameover.setVisible(false);
            }
        });
        
        gameover.voltarMenu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                calango.recomecar();//o calango volta a correr
                chao.recomecar();//o chao volta a mover
                dunas.recomecar();//as dunas voltam a mover
                cactos.x = 1800;//o cacto volta ao lugar de origem
                pontos.pts = 0;//os pontos voltam pra 0
                novoRec.setVisible(false);//não é necessário, mas pode dar erro
                gameover.setVisible(false);
                menu.setVisible(true);
            }
        });
        
        novoRec.botao.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
        	   recordes.top[9].definePontos(pontos.pts);
               novoRec.setVisible(false);
               gameover.setVisible(true);
               gameover.voltarMenu.setEnabled(true);
               gameover.restart.setEnabled(true);
           }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println(calango.y + "  " + cactos.x);
        
        if(calango.y > 320 && cactos.x > 70 && cactos.x < 180 ){//tratamento de colisao
            //para tudo
            cactos.parar();
            calango.parar();
            chao.parar();
            dunas.parar();
            pontos.parar();

            //espera meio segundo
            try{
            Thread.sleep(500);
            }
            catch(InterruptedException ex){
                System.err.println("Erro de thread - fim do jogo");
            }
            //encerra o jogo
            
            gameover.pt.setText("Pontua��o: " + pontos.formatar(pontos.pts));
            
            pontos.setVisible(false);
            
            if(pontos.pts > recordes.top[9].pontos){
                novoRec.setVisible(true);
                gameover.voltarMenu.setEnabled(false);//desabilita os botoes do fundo para impedir misclick
                gameover.restart.setEnabled(false);
            }
            else gameover.setVisible(true);
            
            
        }
        
//        //atualizacao dos recordes
//        Scanner output = null;
//        String dados = "";
//        try{
//            output = new Scanner(new File("build\\classes\\Menu\\records.txt"));
//        }
//        catch(FileNotFoundException err){
//            System.err.println("arquivo não abriu!");
//            System.err.println(err);
//            System.exit(1);
//        }
//        while(output.hasNext()){
//            dados = dados + output.next();
//        }
//        
//        recordes.recordes.setText(dados);
            
    }
    
}
