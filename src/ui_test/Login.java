package ui_test;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;


public class Login {

	public Login() 
	{
		// TODO Auto-generated method stub
		JFrame f=new JFrame();
		f.setTitle("Сѧ�������������ϵͳ");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
		
		//���ô��ڵĴ�С��λ��
		f.setSize(400,400);
		f.setLocation(200,200);
		
		Container con=f.getContentPane();//����һ������	
		con.setLayout(new GridLayout(7,1));
		
		JPanel pan1=new JPanel();//����һ���µİ���
		JLabel title=new JLabel("��ӭ��½Сѧ�������������ϵͳ");
		title.setFont(new Font("����",Font.BOLD, 20));
		pan1.add(title);
		con.add(pan1);
		//������ĵ�½����
		
		JPanel pan2=new JPanel();//����һ���µİ���
		JLabel name=new JLabel("�û���");
		pan2.add(name);
		TextField tf_name=new TextField(20);
		pan2.add(tf_name);
		con.add(pan2);
		//�û��������ı�������ڵڶ���������
		
		
		JPanel pan3=new JPanel();//����һ���µİ���
		JLabel pass = new JLabel("����");
		pan3.add(pass);
		TextField password=new TextField(14);
		password.setEchoChar('*');
		pan3.add(password);
		con.add(pan3);
		//���뼰����������ڵ�����������
		
		JPanel pan4 = new JPanel();  
		JButton b_log=new JButton("��½");  
		b_log.addActionListener(new ActionListener() {  
		    public void actionPerformed(ActionEvent e) {  
		        // TODO Auto-generated method stub  
		        //��ȡ�û��������룬����У��  
		        String myUsername=tf_name.getText(); 
				String myPassword=password.getText();  
		        if(myUsername.equals("admin")&& myPassword.equals("123456")){  
		            JOptionPane.showMessageDialog(null, "��½�ɹ�!"); 
		            new MyExGUI();
		            //graph dati = new graph();
		            //dati.exercise();
		            //Answer an =new Answer();
		            //an.show();
		            f.dispose();
		            //              System.exit(0);  
		
		        }else{  
		            JOptionPane.showMessageDialog(null, "�˺Ż��������!");  
		            name.setText("");  
		            password.setText("");  
		
		        }  
		          
		    }  
		});  
		pan4.add(b_log);  
		  
		
		JButton b_exit=new JButton("�˳�");  
		pan4.add(b_exit);   
		con.add(pan4);  
		//��½���˳���������ť���ڵ��ĸ�������
		
		JPanel pan5 = new JPanel();
		con.add(pan5);
		JPanel pan6 = new JPanel();
		con.add(pan6);
		JPanel pan7 = new JPanel();
		con.add(pan7);
		//�հװ���
	}

}