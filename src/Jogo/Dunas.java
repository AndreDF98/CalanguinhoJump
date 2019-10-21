
package Jogo;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Dunas extends JPanel implements ActionListener{
    
    int x = 0, velX = 5, x2 = 1800;
    Timer mover = new Timer(50, this);
    
    public Dunas(){
        setOpaque(false);
        mover.start();
    }
    
    public void paintComponent(Graphics g){
        setOpaque(false);
        super.paintComponent(g);
        if(x == -1800)
            x = 0;
        if(x2 == 0)
            x2 = 1800;
        //System.out.println(x + "    " + x2);
        g.drawImage(new ImageIcon(getClass().getResource("images/dunas.png")).getImage(), x, 0, this);
        if(x < -900)
            g.drawImage(new ImageIcon(getClass().getResource("images/dunas.png")).getImage(), x2, 0, this);
            
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        x = x - velX;
        x2 = x2 - velX;
        repaint();
    }
    
    void parar(){
        mover.stop();
    }
    
    void recomecar(){
        x = 0;
        x2 = 1800;
        mover.restart();
    }
}
