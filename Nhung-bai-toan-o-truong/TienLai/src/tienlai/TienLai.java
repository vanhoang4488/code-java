package tienlai;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class TienLai extends JFrame implements ActionListener{
    private JTextField tfTienGui, tfThang, tfLaiXuat, tfTienLai;
    public TienLai(){
        setTitle("Tinh Tien Gui Ngan Hang");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5,2,5,5));
        int size = 15;
        JLabel lb = new JLabel("Tien Gui");
        tfTienGui = new JTextField(size);
        add(lb);
        add(tfTienGui);
        
        lb = new JLabel("Thang");
        tfThang = new JTextField(size);
        add(lb);
        add(tfThang);
        
        lb = new JLabel("Lai Xuat");
        tfLaiXuat = new JTextField(size);
        add(lb);
        add(tfLaiXuat);
        
        lb = new JLabel("Tien Lai");
        tfTienLai = new JTextField(size);
        tfTienLai.setEditable(false);
        add(lb);
        add(tfTienLai);
        
        add(createJButton("Tinh"));
        add(createJButton("Nhap Lai"));
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private JButton createJButton(String name){
        JButton btn = new JButton(name);
        btn.addActionListener(this);
        return btn;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand() == "Tinh")
            process();
        if(e.getActionCommand() == "Nhap Lai")
            clear();
    }
    public void process(){
        String text = tfTienGui.getText();
        double tiengui =0, thang =0, laixuat =0, tienlai =0;
        if(text.equals(""))
            tfTienGui.requestFocus();
        else{
            tiengui = Double.parseDouble(text);
            text = tfThang.getText();
            if(text.equals(""))
                tfThang.requestFocus();
            else{
                thang = Integer.parseInt(text);
                laixuat = Double.parseDouble(tfLaiXuat.getText());
                tienlai = tiengui*thang*laixuat;
                tfTienLai.setText(String.valueOf(tienlai));
            }
        }
    }
    public void clear(){
        tfTienGui.setText("");
        tfTienGui.requestFocus();
        tfThang.setText("");
        tfLaiXuat.setText("");
        tfTienLai.setText("");
    }
    public static void main(String[] args) {
        new TienLai();
    }

    
}
