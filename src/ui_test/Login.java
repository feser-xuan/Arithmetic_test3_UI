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
		f.setTitle("小学生四则运算答题系统");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
		
		//设置窗口的大小和位置
		f.setSize(400,400);
		f.setLocation(200,200);
		
		Container con=f.getContentPane();//生成一个容器	
		con.setLayout(new GridLayout(7,1));
		
		JPanel pan1=new JPanel();//生成一个新的版面
		JLabel title=new JLabel("欢迎登陆小学生四则运算答题系统");
		title.setFont(new Font("宋体",Font.BOLD, 20));
		pan1.add(title);
		con.add(pan1);
		//最上面的登陆文字
		
		JPanel pan2=new JPanel();//生成一个新的版面
		JLabel name=new JLabel("用户名");
		pan2.add(name);
		TextField tf_name=new TextField(20);
		pan2.add(tf_name);
		con.add(pan2);
		//用户名及其文本框放置在第二个版面上
		
		
		JPanel pan3=new JPanel();//生成一个新的版面
		JLabel pass = new JLabel("密码");
		pan3.add(pass);
		TextField password=new TextField(14);
		password.setEchoChar('*');
		pan3.add(password);
		con.add(pan3);
		//密码及其密码域放在第三个版面上
		
		JPanel pan4 = new JPanel();  
		JButton b_log=new JButton("登陆");  
		b_log.addActionListener(new ActionListener() {  
		    public void actionPerformed(ActionEvent e) {  
		        // TODO Auto-generated method stub  
		        //获取用户名和密码，进行校验  
		        String myUsername=tf_name.getText(); 
				String myPassword=password.getText();  
		        if(myUsername.equals("admin")&& myPassword.equals("123456")){  
		            JOptionPane.showMessageDialog(null, "登陆成功!"); 
		            new MyExGUI();
		            //graph dati = new graph();
		            //dati.exercise();
		            //Answer an =new Answer();
		            //an.show();
		            f.dispose();
		            //              System.exit(0);  
		
		        }else{  
		            JOptionPane.showMessageDialog(null, "账号或密码错误!");  
		            name.setText("");  
		            password.setText("");  
		
		        }  
		          
		    }  
		});  
		pan4.add(b_log);  
		  
		
		JButton b_exit=new JButton("退出");  
		pan4.add(b_exit);   
		con.add(pan4);  
		//登陆和退出这两个按钮放在第四个版面上
		
		JPanel pan5 = new JPanel();
		con.add(pan5);
		JPanel pan6 = new JPanel();
		con.add(pan6);
		JPanel pan7 = new JPanel();
		con.add(pan7);
		//空白版面
	}

}