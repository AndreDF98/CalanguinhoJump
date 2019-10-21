
package Menu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel{
    
    JLabel titulo;
    public JButton comecar;
    public JButton recordes;
    public JButton creditos;
    
    public Menu(){
        setOpaque(false);
        setLayout(null);
        
        titulo = new JLabel();
        titulo.setBounds(0,0,900,600);
        titulo.setIcon(new ImageIcon(getClass().getResource("images/logo.png")));
        add(titulo);
        
        comecar = new JButton();
        comecar.setBounds(384,320,132,54);
        comecar.setContentAreaFilled(false);//tira o fundo
        comecar.setBorderPainted(false);//tira a borda
        comecar.setIcon(new ImageIcon(getClass().getResource("images/jogar.png")));
        add(comecar);
        
        recordes = new JButton();
        recordes.setBounds(353,384,194,54);
        recordes.setContentAreaFilled(false);//tira o fundo
        recordes.setBorderPainted(false);//tira a borda
        recordes.setIcon(new ImageIcon(getClass().getResource("images/recordes.png")));
        add(recordes);
        
        creditos = new JButton();
        creditos.setBounds(360,448,180,54);
        creditos.setContentAreaFilled(false);//tira o fundo
        creditos.setBorderPainted(false);//tira a borda
        creditos.setIcon(new ImageIcon(getClass().getResource("images/creditos.png")));
        add(creditos);
        
        //ActionListeners----------------------------------------------------------------
        
        comecar.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                comecar.setIcon(new ImageIcon(getClass().getResource("images/jogarPressed.png")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                comecar.setIcon(new ImageIcon(getClass().getResource("images/jogarEntered.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                comecar.setIcon(new ImageIcon(getClass().getResource("images/jogarEntered.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                comecar.setIcon(new ImageIcon(getClass().getResource("images/jogar.png")));
            }
        });
        
        recordes.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                recordes.setIcon(new ImageIcon(getClass().getResource("images/recordesPressed.png")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                recordes.setIcon(new ImageIcon(getClass().getResource("images/recordesEntered.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                recordes.setIcon(new ImageIcon(getClass().getResource("images/recordesEntered.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                recordes.setIcon(new ImageIcon(getClass().getResource("images/recordes.png")));
            }
        });
        
        creditos.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                creditos.setIcon(new ImageIcon(getClass().getResource("images/creditosPressed.png")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                creditos.setIcon(new ImageIcon(getClass().getResource("images/creditosEntered.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                creditos.setIcon(new ImageIcon(getClass().getResource("images/creditosEntered.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                creditos.setIcon(new ImageIcon(getClass().getResource("images/creditos.png")));
            }
        });
    }
    
}
