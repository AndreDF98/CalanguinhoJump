
package Jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Pontos extends JLabel {
    
    public int pts = 0;
    DecimalFormat formato;
    Timer contador;
    
    public Pontos(){
        setText("Pts: " + pts);
        setForeground(Color.WHITE);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(new Font("Pixel Font-7", Font.PLAIN, 50));
        
        contador = new Timer(400, contar);
    }
    
    String formatar(int num){
        formato = new DecimalFormat("000000");
        return formato.format(num);
    }
    
    ActionListener contar = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            pts++;
            setText("Pts: " + formatar(pts));
        }
    };
    
    void recomecar(){
        contador.restart();
    }
    
    void parar(){
        contador.stop();
    }
    
}
