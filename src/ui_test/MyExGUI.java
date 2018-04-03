package ui_test;

import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;  


public class MyExGUI extends JFrame{
	ArrayList<String> user_answer = new ArrayList<String>();
	ArrayList<String> true_answer = new ArrayList<String>();
	JMenuBar jmb;   //菜单条组件  
    JMenu menu1, menu2, menu3, menu4, menu5;//菜单  
    JMenuItem item1, item2, item3, item4, item5, item6;//菜单项  
    JMenu build;    //二级菜单  
    JMenuItem file, project; 
    TextArea answer_all = new TextArea();
    TextField jta = new TextField();
    TextField jta_answer = new TextField(); 
    JLabel num_answer = new JLabel();
    JLabel answer1,answer2,answer3,answer4,answer5,answer6,answer7,answer8,answer9,answer10,
    answer11,answer12,answer13,answer14,answer15,answer16,answer17,answer18,answer19,answer20;
    JToolBar jtb;//工具条  
    JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7,jb_next;  
    int answer_count;
    public MyExGUI()
    {  
        //创建菜单  
        jmb = new JMenuBar();  
        
        menu1 = new JMenu("文件(F)");  
        menu1.setMnemonic('f'); //助记符  
        menu2 = new JMenu("编辑");  
        menu2.setMnemonic('E');  
        menu3 = new JMenu("格式");  
        menu4 = new JMenu("查看");  
        menu5 = new JMenu("帮助");  
          
        build = new JMenu("新建");  
          
        file = new JMenuItem("文件");  
        project = new JMenuItem("答题");  
        item1 = new JMenuItem("打开");  
        item2 = new JMenuItem("保存(S)");  
        item3 = new JMenuItem("另存为");  
        item4 = new JMenuItem("页面设置");  
        item5 = new JMenuItem("打印");  
        item6 = new JMenuItem("退出");  
        
        answer1 = new JLabel("第  1 题");
        answer2= new JLabel("第二题");
        answer3= new JLabel("第三题");
        answer4= new JLabel("第四题");
        answer5= new JLabel("第五题");
        answer6= new JLabel("第六题");
        answer7= new JLabel("第七题");
        answer8= new JLabel("第八题");
        answer9= new JLabel("第九题");
        answer10= new JLabel("第十题");
        answer11= new JLabel("第十一题");
        answer12= new JLabel("第十二题");
        answer13= new JLabel("第十三题");
        answer14= new JLabel("第十四题");
        answer15= new JLabel("第十五题");
        answer16= new JLabel("第十六题");
        answer17= new JLabel("第十七题");
        answer18= new JLabel("第十八题");
        answer19= new JLabel("第十九题");
        answer20= new JLabel("第二十题");
          
        
          
            //添加菜单项至菜单上  
        build.add(file);  
        build.add(project);  
          
        menu1.add(build);  
        menu1.add(item1);  
        menu1.add(item2);  
        menu1.add(item3);  
        menu1.addSeparator();  
        menu1.add(item4);  
        menu1.add(item5);  
        menu1.add(item6);  
            //将菜单加入至菜单栏  
        jmb.add(menu1);  
        jmb.add(menu2);  
        jmb.add(menu3);  
        jmb.add(menu4);  
        jmb.add(menu5);  
          
        
    	JPanel contentPanel = new JPanel();
    	contentPanel.setLayout(null);
    	JLabel daan = new JLabel("答案");
    	JLabel dengyu = new JLabel("=");
        num_answer=answer1;
        num_answer.setFont(new Font("宋体",Font.BOLD, 22));
        jb_next = new JButton("下一题");
        jta.setFont(new Font("宋体",Font.BOLD, 22));
        jta_answer.setFont(new Font("宋体",Font.BOLD, 22));
        jb_next.setFont(new Font("宋体",Font.BOLD, 22));
        daan.setFont(new Font("宋体",Font.BOLD, 22));
        dengyu.setFont(new Font("宋体",Font.BOLD, 22));
        
    	contentPanel.add(num_answer);
    	contentPanel.add(daan);
    	contentPanel.add(dengyu);
    	contentPanel.add(jta);

    	contentPanel.add(jta_answer);
    	contentPanel.add(answer_all);
    	contentPanel.add(jb_next);
    	
        num_answer.setBounds(90, 20, 90, 50);
        daan.setBounds(250, 20, 90, 50);
        jta.setBounds(50, 70, 150, 30);
        dengyu.setBounds(205, 70, 20, 20);
        jta_answer.setBounds(230, 70, 100, 30);
        jb_next.setBounds(350, 70, 110, 30);
        answer_all.setBounds(50, 120, 400, 300);
        
        this.setJMenuBar(jmb);  //添加菜单栏，不能设定位置，会自动放在最上部  
        this.add(contentPanel);
        
        this.setTitle("在线答题系统");  
        this.setSize(600, 500);  
        this.setVisible(true);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        project.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				arithmetic art = new arithmetic();
				true_answer=art.list_answer;
				answer_count=0;
				for (int i = 0; i < art.list_timu.size(); i++)
				{
					answer_all.append(art.list_timu.get(i));
					answer_all.append("\r\n");
				}
				jta.setText(art.list_timu.get(answer_count));
				answer_count++;
				
				
			}
		});
        jb_next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String temp;
				temp = jta_answer.getText();
				if(isInteger(temp))
				{
					
					user_answer.add(temp);
					num_answer.setText("第  "+answer_count+" 题");
					if(answer_count<20)
						answer_count++;
					else{
						
						Object[] options = { "是", "取消" }; 
						JOptionPane.showOptionDialog(null, "点击以继续 查看成绩", "答题完毕", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
						null, options, options[0]); 
						
					}
					
				}
				
				
			}
		});
        
        
        
        
    }
    
    public static boolean isInteger(String str) {    
	    for (int i = str.length();--i>=0;){  
			        if (!Character.isDigit(str.charAt(i))){
			            return false;
			        }
			    }
			    return true;
	  } 
    
    
	
	
}
