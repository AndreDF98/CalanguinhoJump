
package Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameOver extends JPanel{
    
    JLabel gameover;
    public JLabel pt;
    public JButton restart;
    public JButton voltarMenu;
    
    JLabel fundo;
    
    public GameOver(){
        this.setOpaque(false);
        
        gameover = new JLabel();
        gameover.setBounds(0,0,900,600);
        gameover.setIcon(new ImageIcon(getClass().getResource("images/gameOver.png")));
        this.add(gameover);
        
        pt = new JLabel();
        pt.setBounds(150,280,600,80);
        pt.setOpaque(true);
        pt.setBackground(new Color(0,0,0,200));
        pt.setForeground(Color.WHITE);
        pt.setFont(new Font("Pixel Font-7", Font.PLAIN, 30));
        pt.setHorizontalAlignment(SwingConstants.CENTER);
        pt.setText("Pontuação: ");
        this.add(pt);
        
        restart = new JButton();
        restart.setBounds(265,421,370,54);
        restart.setContentAreaFilled(false);//tira o fundo
        restart.setBorderPainted(false);//tira a borda
        restart.setIcon(new ImageIcon(getClass().getResource("images/tentarNovamente.png")));
        this.add(restart);
        
        voltarMenu = new JButton();
        voltarMenu.setBounds(297,485,306,54);
        voltarMenu.setContentAreaFilled(false);//tira o fundo
        voltarMenu.setBorderPainted(false);//tira a borda
        voltarMenu.setIcon(new ImageIcon(getClass().getResource("images/menuPrincipal.png")));
        this.add(voltarMenu);
        
        fundo = new JLabel();
        fundo.setBounds(0,0,900,600);
        fundo.setOpaque(true);
        fundo.setBackground(new Color(0,0,0,150));
        this.add(fundo);
        
        restart.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                restart.setIcon(new ImageIcon(getClass().getResource("images/tentarNovamentePressed.png")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                restart.setIcon(new ImageIcon(getClass().getResource("images/tentarNovamenteEntered.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                restart.setIcon(new ImageIcon(getClass().getResource("images/tentarNovamenteEntered.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                restart.setIcon(new ImageIcon(getClass().getResource("images/tentarNovamente.png")));
            }
        });
        
        voltarMenu.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                voltarMenu.setIcon(new ImageIcon(getClass().getResource("images/menuPrincipalPressed.png")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                voltarMenu.setIcon(new ImageIcon(getClass().getResource("images/menuPrincipalEntered.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                voltarMenu.setIcon(new ImageIcon(getClass().getResource("images/menuPrincipalEntered.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                voltarMenu.setIcon(new ImageIcon(getClass().getResource("images/menuPrincipal.png")));
            }
        });
    }
    
}
