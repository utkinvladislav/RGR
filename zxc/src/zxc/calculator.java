package zxc; 
import java.awt.BorderLayout; 
import java.awt.Color; 
import java.awt.GridLayout; 
import java.awt.LayoutManager; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.KeyAdapter; 
import java.awt.event.KeyEvent; 
import javax.swing.BoxLayout; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JOptionPane; 
import javax.swing.JPanel; 
import javax.swing.JTextField; 

public class calculator extends JFrame { 
/** 
* 
*/ 
private static final long serialVersionUID = 1L; 
float result; 
JButton buttonResult = new JButton("���������"); 

public calculator() { 
buttonResult.setEnabled(false); 
add(buttonResult, BorderLayout.NORTH); //��������� ������ ����� � ��������� �� ������������ 
JPanel radioPanel = new JPanel(new GridLayout(5, 1)); // ���������� ������������ ��������� 
radioPanel.setBackground(Color.pink); //������������� ���� ������� 
radioPanel.setLayout((LayoutManager) new BoxLayout(radioPanel, BoxLayout.Y_AXIS)); // ��������� ������������ ����� 
setBounds(250, 250, 250, 250); //���������� ������ ���� 
add(radioPanel, BorderLayout.CENTER);// ��������� ������������ ����� 
final JTextField month = new JTextField(); //��������� ���� ����� 
final JTextField stavka = new JTextField(); //��������� ���� ����� 
final JTextField sum = new JTextField(); //��������� ���� ����� 

JLabel monthtext = new JLabel("���������� �������:"); // ������ �������� ����� 
JLabel stavkatext = new JLabel("������ �� �������(%):"); // ������ �������� ����� 
JLabel sumtext = new JLabel("����� �������:"); // ������ �������� ����� 
//��������� ��������� ������ � ���� ��� ����� 
radioPanel.add(monthtext); 
radioPanel.add(month); 
radioPanel.add(stavkatext); 
radioPanel.add(stavka); 
radioPanel.add(sumtext); 
radioPanel.add(sum); 

month.addKeyListener(new KeyAdapter() { //��������� ��������� �� ���� ��� ����� 
public void keyTyped(KeyEvent e) { 
char c = e.getKeyChar(); 
if ( ((c < '0') || (c > '9'))) { 
e.consume(); // ������� ��������� ����� � ������ 
} 
if (month.getText().length() >= 2){ 
JOptionPane.showMessageDialog(null, "������������ ���-�� �������� 2", "������������ ����",JOptionPane.WARNING_MESSAGE ); 
} //�� ���� ������������ ������� ������ 2 �������� � ������ 
} 
}); 
stavka.addKeyListener(new KeyAdapter() { 
public void keyTyped(KeyEvent e) { 
char c = e.getKeyChar(); 
if ( ((c < '0') || (c > '9'))) { 
e.consume(); // ���������� ��������� ����� � ������ 
} 
if (stavka.getText().length() >= 2){ 
JOptionPane.showMessageDialog(null, "������������ ���-�� �������� 2", "������������ ����",JOptionPane.WARNING_MESSAGE ); 
} //�� ���� ������������ ������� ������ 2 �������� � ������ 
} 
}); 
sum.addKeyListener(new KeyAdapter() { 
public void keyTyped(KeyEvent e) { 
char c = e.getKeyChar(); 
if ( ((c < '0') || (c > '9'))) { 
e.consume(); // ���������� ��������� ����� � ������ 
} 

} 
}); 

JButton calculate = new JButton("������"); 
calculate.setBackground(new Color(255, 0, 255)); //������ ���� ������ 
calculate.addActionListener(new ActionListener() { //��������� ��������� �� ������ 
public void actionPerformed(ActionEvent e) { 
Float s = Float.parseFloat((sum.getText())); //��������������� ��������� � ���� �������� � ��� ������ float 
Float t = Float.parseFloat((stavka.getText())); //��������������� ��������� � ���� �������� � ��� ������ float 
Float m = Float.parseFloat((month.getText())); //��������������� ��������� � ���� �������� � ��� ������ float 
float result= Result(s,t,m); //�������� ������ � ����� ��� ���������� 
buttonResult.setText(Float.toString(result)); 
} 
}); 

buttonResult.setBackground(new Color(255, 255, 255)); //������������� ���� ������ 
radioPanel.add(calculate); 
setVisible(true); //������ ���� ������� 
} 

public float Result(float sum,float stavka,float month) { //������ ���������� � ����� 
float result = (sum/month)+((sum/month)*(stavka/100)); //������� ��������
return result; //���������� �������� 
} 

public static void main(String[] args) { 
new calculator(); 
} 

//��������� � ������ ���� string 
private static String format(int i) { 
String result = String.valueOf(i); 
if (result.length() == 1) { 
result = "0" + result; 
} 
return result; //���������� �������� 
} 

}