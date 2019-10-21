
package Menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Top extends JLabel{
    
	public int posicao;
    public String nome;
    public int pontos;
    
    DecimalFormat formato;
    
    public Top(){
        
        setPreferredSize(new Dimension(500,40));
        setForeground(Color.WHITE);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(new Font("Pixel Font-7", Font.PLAIN, 40));
        
    }
    
    public void definePos(int p) {
    	posicao = p;
    }
    
    public void defineNome(String n) {
    	nome = n;
    }
    
    public void definePontos(int p) {
    	pontos = p;
    }
    
    String formatar(int num){
        formato = new DecimalFormat("000000");
        return formato.format(num);
    }
    
    public void imprime(){
        setText(posicao + ". " + nome + ".................." + formatar(pontos));
    }
    
}
