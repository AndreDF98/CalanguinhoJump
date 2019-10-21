
package Jogo;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Cactos extends JPanel implements ActionListener{
    
    int x = 1800, velX = 30;
    Timer mover = new Timer(50, this);
    
    Random gerador;
    int aleat = 0;
    
    public Cactos(){
        setOpaque(false);
        gerador = new Random();
    }
    public void paintComponent(Graphics g){
        setOpaque(false);
        super.paintComponent(g);
        
        if(x == -900){
            aleat = gerador.nextInt(4);//0 a 3
            x = 900;
        }
        //System.out.println(aleat + "   " + x);
        g.drawImage(new ImageIcon(getClass().getResource("images/cacto" + aleat + ".png")).getImage(), x, 420, this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        x = x - velX;
        repaint();
        
    }
    
    void recomecar(){
        mover.restart();
    }
    
    void parar(){
        mover.stop();
    }
    
}
