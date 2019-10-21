
package Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NovoRec extends JPanel{
    
    JLabel caixa;
    JTextField texto;
    public JButton botao;
    
    public NovoRec(){
        
        botao = new JButton();
        botao.setBounds(234,136,132,54);
        botao.setContentAreaFilled(false);//tira o fundo
        botao.setBorderPainted(false);//tira a borda
        botao.setIcon(new ImageIcon(getClass().getResource("images/jogar.png")));
        this.add(botao);
        
        caixa = new JLabel();
        caixa.setBounds(0,0,600,200);
        caixa.setOpaque(true);
        caixa.setBackground(Color.BLACK);
        caixa.setText("Novo Recorde!");
        caixa.setForeground(Color.WHITE);
        caixa.setHorizontalAlignment(SwingConstants.CENTER);
        caixa.setFont(new Font("Pixel Font-7", Font.PLAIN, 45));
        caixa.setVerticalAlignment(JLabel.TOP);
        this.add(caixa);
        
        texto = new JTextField();
        texto.setBounds(50,70,500,50);
        texto.setHorizontalAlignment(SwingConstants.CENTER);
        texto.setText("Seu Nome");
        texto.setBackground(Color.BLACK);
        texto.setForeground(Color.WHITE);
        texto.setFont(new Font("Pixel Font-7", Font.PLAIN, 45));
        texto.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        this.add(texto);
        
        botao.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                botao.setIcon(new ImageIcon(getClass().getResource("images/jogarPressed.png")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                botao.setIcon(new ImageIcon(getClass().getResource("images/jogarEntered.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                botao.setIcon(new ImageIcon(getClass().getResource("images/jogarEntered.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botao.setIcon(new ImageIcon(getClass().getResource("images/jogar.png")));
            }
        });
    }
}
