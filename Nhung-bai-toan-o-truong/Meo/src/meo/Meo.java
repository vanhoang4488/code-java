package meo;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Meo extends JFrame implements ActionListener{
    private JLabel lb;
    private JLabel lb1;
    private JButton but;
    public Meo(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200,300);
        setLayout(new GridLayout(3,1,5,5));
        lb = new JLabel("My JLabel");
        lb.setHorizontalAlignment(JLabel.CENTER);
        add(lb);
        JButton btn = new JButton("click");
        btn.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               changeTextJLabel();
           } 
        });
        add(btn);
        lb1 = new JLabel("Background default");
        lb1.setHorizontalAlignment(JLabel.CENTER);
        lb1.setOpaque(true);
        add(lb1);
        but = createJButton("Green");
        add(but);
        add(createJButton("Blue"));
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void changeTextJLabel(){
        lb.setText("Meo!!!!!!!");
    }
    private JButton createJButton(String title){
        JButton lb = new JButton(title);
        lb.addActionListener(this);
        return lb;
    }
    private void changeBackgroundJLabel(Color bg, String namebg){
        lb1.setBackground(bg);
        lb1.setText("Background is " + namebg);
       
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == but)
            changeBackgroundJLabel(Color.green,"Green");
        if(e.getActionCommand() == "Blue")
            changeBackgroundJLabel(Color.blue,"Blue");
    }
    public static void main(String[] args) {
        new Meo();
    }
}
