
package Jogo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Calanguinho extends JPanel implements ActionListener, KeyListener{
    
    ArrayList<Image> corrida;//Array de sprites
    Timer corredor;
    
    int cont = 0;//contador para percorre o ArrayList
    
    Timer pular = new Timer(10, this);
    int x = 80, velX = 0, y = 400, velY = 0;//posicao horizontal e vertical, e suas respectivas velocidades
    
    public Calanguinho(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
        corrida = new ArrayList<Image>();
        corrida.add(new ImageIcon(getClass().getResource("images/pulo.png")).getImage());//pulo é o primeiro sprite para evitar erro
        for(int i = 0; i < 4; i++)
            corrida.add((new ImageIcon(getClass().getResource("images/" + i + ".png")).getImage()));//insere os sprites no ArrayList
        
        corredor = new Timer(80, new correr());//animacao de corrida
        corredor.start();
    }
    
    @Override
    public void paintComponent(Graphics g){//printa o calanguinho
        setOpaque(false);
        super.paintComponent(g);
        
        g.drawImage(corrida.get(cont), x, y, this);
    }
    
    class correr implements ActionListener{
            public void actionPerformed(ActionEvent e){
                if(cont > 3) cont = 0;//percorre o ArrayList
                cont++;
                
                if(y<400) cont = 0;//mantem o sprite do pulo
            }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(x < 0){//limite da esquerda
            velX = 0;
            x = 0;
        }
        
        if(x > 784){//limite da direita
            velX = 0;
            x = 784;
        }
        
        if(y < 220){//altura do pulo - vai ate 200
            velY = -velY;
        }
            
        if(y > 400){//limite do chao
            velY = 0;
            y = 400;
        }
        
        x = x + velX;//permitem a movimentacao
        y = y + velY;
        
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
        
        if((c == KeyEvent.VK_SPACE || c == KeyEvent.VK_UP) && y > 385){//permite pular um pouquinho antes do chao pra ficar mais fluido
            velX = 0;
            velY = -10;
        }
        
//        if(c == KeyEvent.VK_LEFT){
//            velX = -10;
//            velY = 0;
//        }
//        
//        if(c == KeyEvent.VK_RIGHT){
//            velX = 10;
//            velY = 0;
//        }
            
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        velX = 0;//só anda horizontalmente quando pressionado
    }
    
    void parar(){
        corredor.stop();
        pular.stop();
    }
    
    int pegaX(){
        return x;
    }
    
    int pegaY(){
        return y;
    }
    
    void recomecar(){
        x = 80;
        y = 400;
        velX = 0;
        velY = 0;
        corredor.restart();
    }
}