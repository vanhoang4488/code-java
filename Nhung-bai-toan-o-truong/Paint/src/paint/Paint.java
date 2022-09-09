package paint;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Paint extends JFrame implements ActionListener{
    private int numberjlabel;
    private JPanel panel1,panel2;
    public Paint(){
        createJFrame();
    }
    private void createJFrame(){
        setTitle("Create JPanel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,1,5,5));
        createContent();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void createContent(){
        panel1 = new JPanel();
        addJLabel(panel1);
        
        panel2 = new JPanel(new GridLayout(1,2,5,5));
        panel2.add(createJButton("Add a JPanel"));
        panel2.add(createJButton("Remove all JPanel"));
        add(panel1);
        add(panel2);
    }
    private void addJLabel(JPanel panel){
        panel.add(new JLabel("JLabel"+(++numberjlabel)));
        panel.validate();
        panel.repaint();
    }
    private void removeAllJPanel(JPanel panel){
        panel.removeAll();
        panel.validate();
        panel.repaint();
        numberjlabel = 0;
    }
    public JButton createJButton(String name){
        JButton btn = new JButton(name);
        btn.addActionListener(this);
        return btn;
    }
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        if(command == "Add a JPanel"){
            addJLabel(panel1);
        }
        if(command == "Remove all JPanel")
            removeAllJPanel(panel1);
    }
    public static void main(String[] args) {
        new Paint();
    }
}
