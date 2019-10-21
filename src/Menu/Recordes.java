
package Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Recordes extends JPanel{
    
    public JPanel recordes;
    
    public Top top[] = new Top[20];
    
    JLabel fundo;
    
    public JButton voltar;
    
    public Recordes(){
        this.setOpaque(false);
        
        recordes = new JPanel();
        recordes.setBounds(200,50,500,450);
        recordes.setOpaque(true);
        recordes.setBackground(new Color(0,0,0,200));
        
        for(int i = 0; i< 10; i ++) {
        	top[i] = new Top();  
        	recordes.add(top[i]);
        }
        
        leArquivo();
        
        this.add(recordes);
        
        voltar = new JButton();
        voltar.setBounds(382,523,136,54);
        voltar.setContentAreaFilled(false);//tira o fundo
        voltar.setBorderPainted(false);//tira a borda
        voltar.setIcon(new ImageIcon(getClass().getResource("images/voltar.png")));
        this.add(voltar);
        
        fundo = new JLabel();
        fundo.setBounds(0,0,900,600);
        fundo.setOpaque(true);
        fundo.setBackground(new Color(0,0,0,150));
        this.add(fundo);
        
        voltar.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                voltar.setIcon(new ImageIcon(getClass().getResource("images/voltarPressed.png")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                voltar.setIcon(new ImageIcon(getClass().getResource("images/voltarEntered.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                voltar.setIcon(new ImageIcon(getClass().getResource("images/voltarEntered.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                voltar.setIcon(new ImageIcon(getClass().getResource("images/voltar.png")));
            }
        });
    }
    
    public void leArquivo() {
    	
    	Scanner input = null;
        int i = 0;
        try{
        	input = new Scanner(new File("build\\classes\\Menu\\records.txt"));
        }
        catch(FileNotFoundException err){
            System.err.println("arquivo não abriu!");
            System.exit(1);
        }
        while(input.hasNext()){
        	top[i].definePos(Integer.parseInt(input.next()));
        	top[i].defineNome(input.next());
        	top[i].definePontos(Integer.parseInt(input.next()));
        	
            top[i].imprime();
            
            i++;
        }
        
    }
    
    public void escreveArquivo() {
    	Scanner output = null;
    	
    	try {
    		output = new Scanner(new File("build\\classes\\Menu\\records.txt"));
    	}
    	catch(FileNotFoundException err){
            System.err.println("arquivo não abriu!");
            System.exit(1);
        }
    	
    }
    
}
