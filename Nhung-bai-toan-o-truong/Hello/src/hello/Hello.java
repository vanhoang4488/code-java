package hello;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Graphics;

public class Hello extends JFrame{
    public Hello(){
        setTitle("Meo_Luoi");
        setLayout(new GridLayout(2,1,5,5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,1000);
        setLocationRelativeTo(null);
        
        Icon icon = new ImageIcon(getClass().getResource("meo.jpg"));
        JLabel a = new JLabel("Meo_Luoi");
        JLabel b = new JLabel(icon);
        JLabel c = new JLabel("txt",icon,JLabel.CENTER);
        c.setVerticalTextPosition(JLabel.BOTTOM);
        c.setHorizontalTextPosition(JLabel.CENTER);
        a.setHorizontalAlignment(JLabel.CENTER);
        
        add(a);
        add(b);
        add(c);
        
        JLabel lb ;
        lb = create ("Meo_con",Color.red,Color.green);
        add(lb);
        lb = create ("Hiu hiu",Color.BLACK,Color.LIGHT_GRAY);
        add(lb);
        
        ImageIcon icon2 = new ImageIcon(getClass().getResource("meo.jpg"));
        JLabel lb1 = new JLabel("Meo......!!!"){
            public void paintComponent(Graphics g){
                g.drawImage(icon2.getImage(),0,0,null);
                super.paintComponent(g);
            }  
        };
        lb1.setForeground(Color.red);
        lb1.setHorizontalAlignment(JLabel.CENTER);
        lb1.setVerticalAlignment(JLabel.CENTER);
        add(lb1);
        
        setVisible(true); 
    }
    private JLabel create(String text, Color textColor, Color background){
        JLabel lb = new JLabel(text);
        lb.setHorizontalAlignment(JLabel.CENTER);
        lb.setForeground(textColor);
        lb.setOpaque(true);
        lb.setBackground(background);
        return lb;
    }
    public static void main(String[] args) {
        new Hello();
    }
    
}
