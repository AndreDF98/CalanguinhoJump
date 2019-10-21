
package Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Creditos extends JPanel{
    
    JPanel creditos;
    JLabel andre;
    JLabel emailA;
    JLabel hugo;
    JLabel emailH;
    
    JLabel fundo;
    
    public JButton voltar;
    
    public Creditos(){
        this.setOpaque(false);
        
        creditos = new JPanel();
        creditos.setBounds(200,150,500,300);
        creditos.setLayout(null);
        creditos.setBackground(new Color(0,0,0,200));
        
        andre = new JLabel();
        andre.setText("Código: André Dias Freitas");
        andre.setForeground(Color.WHITE);
        andre.setFont(new Font("Pixel Font-7", Font.PLAIN, 30));
        andre.setBounds(60,40,500,100);
        creditos.add(andre);
        
        emailA = new JLabel();
        emailA.setText("andredias343@gmail.com");
        emailA.setForeground(Color.WHITE);
        emailA.setFont(new Font("Pixel Font-7", Font.PLAIN, 20));
        emailA.setBounds(200,70,500,100);
        creditos.add(emailA);
        
        hugo = new JLabel();
        hugo.setText("Arte: Hugo Dias Freitas");
        hugo.setForeground(Color.WHITE);
        hugo.setFont(new Font("Pixel Font-7", Font.PLAIN, 30));
        hugo.setBounds(80,140,450,100);
        creditos.add(hugo);
        
        emailH = new JLabel();
        emailH.setText("hugo_diasF@hotmail.com");
        emailH.setForeground(Color.WHITE);
        emailH.setFont(new Font("Pixel Font-7", Font.PLAIN, 20));
        emailH.setBounds(190,170,500,100);
        creditos.add(emailH);
        
        this.add(creditos);
        
        voltar = new JButton();
        voltar.setBounds(382,498,136,54);
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
    
}
