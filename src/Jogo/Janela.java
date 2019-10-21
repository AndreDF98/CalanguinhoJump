package Jogo;

import javax.swing.*;

public class Janela {
    
    public Janela(){
        JFrame janela = new JFrame("Calanguinho Jump!");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(900,629);
        janela.setIconImage(new ImageIcon(getClass().getResource("images/icone.png")).getImage());
        
        Board conteudo = new Board();
        conteudo.setLayout(null);
        janela.add(conteudo);
        
        janela.setVisible(true);
        janela.setResizable(false);
        janela.setLocationRelativeTo(null);
    }
    
    public static void main(String args[]){
        new Janela();
    }
}
