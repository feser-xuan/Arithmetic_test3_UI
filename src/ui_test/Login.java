package ui_test;

import java.awt.*;

import javax.swing.*; 

public class Login {
	public Login()
	{
	JFrame frame = new JFrame("用户注册");
    
    //窗体基本属性
    frame.setSize(600, 400);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
    //设置主面板，相当于外层div
    JPanel jp = new JPanel(new BorderLayout());
    
    //东西南北中，面板
    JPanel jp1 = new JPanel(new FlowLayout());
    JPanel jp2 = new JPanel(new FlowLayout());
    JPanel jp3 = new JPanel(new GridLayout(10,2));
    JPanel jp4 = new JPanel(new FlowLayout());
    JPanel jp5 = new JPanel(new FlowLayout());
    
    //加入主面板
    jp.add(BorderLayout.NORTH,jp1);
    jp.add(BorderLayout.SOUTH,jp2);
    jp.add(BorderLayout.CENTER,jp3);
    jp.add(BorderLayout.EAST,jp4);
    jp.add(BorderLayout.WEST,jp5);
    

    //标题
    JLabel jl1 = new JLabel("用户注册",SwingConstants.CENTER);
    jp1.add(jl1);
    
    //中间面板
    JButton jb2= new JButton("Btn");
    JTextField jt = new JTextField("usrname");
    JButton jb1 = new JButton("abc");    
    
    jp3.add(jt);
    jp3.add(jb1);
    jp3.add(jb2);
    
            
    //this.container = frame.getContentPane();
   // this.container.setBackground(Color.white);
   // this.container.add(jp);
}
	
	/*
	Button login = new Button("Login in");
	Button exit = new Button("Login out");
	Button register = new Button("Register");
	JLabel input_name= new JLabel("用户名：");
	JLabel input_password = new JLabel("密 码：");
	JTextField in_name = new JTextField();
	JTextField in_password = new JTextField();
	public Login()
	{
	  JFrame  f = new JFrame("一个简单窗口");
      f.setLocation(300,300);          
      f.setSize(300,200);           
      //f.setResizable(false);   
      f.setUndecorated(true);
      f.setVisible(true);
      //f.setLayout(new FlowLayout());
      //f.setLayout(new GridLayout(2,3,120,20));
      JPanel jp = new JPanel(new BorderLayout());
      f.setLayout(null);
      in_name.setSize(200, 240);
      in_password.setSize(200,240);
      input_name.setBounds(10, 10, 20, 50);
      in_name.setBounds(arg0, arg1, arg2, arg3);
      f.add(input_name);
      f.add(in_name);
      f.add(input_password);
      f.add(in_password);
      f.add(login);
      f.add(exit);
      f.add(register);
      
     
     // f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	}
	
*/
}
