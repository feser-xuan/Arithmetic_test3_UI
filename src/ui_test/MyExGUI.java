package ui_test;

import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;  


public class MyExGUI extends JFrame{
	ArrayList<String> user_zongti = new ArrayList<String>();
	ArrayList<String> user_zonganswer = new ArrayList<String>();
	ArrayList<String> user_answer = new ArrayList<String>();
	ArrayList<String> true_answer = new ArrayList<String>();
	ArrayList<String> jta_timu = new ArrayList<String>();
	ArrayList<String> jta_zong = new ArrayList<String>();
	ArrayList<Integer> user_fenshu = new ArrayList<Integer>();
	JMenuBar jmb;   //菜单条组件  
    JMenu menu1, menu2, menu3, menu4, menu5;//菜单  
    JMenuItem item1, item2, item3, item4, item5, item6;//菜单项  
    JMenu build;    //二级菜单  
    JMenuItem file, project; 
    TextArea answer_all = new TextArea();
    TextField jta = new TextField();
    TextField jta_answer = new TextField(); 
    JLabel num_answer = new JLabel();
    JLabel answer1;
    JToolBar jtb;//工具条  
    JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7,jb_next;  
    int answer_count;
    int answer_fenshu;
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
        
        answer1 = new JLabel("第 1 题");
       
        
          
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
    	
        num_answer.setBounds(90, 20, 130, 50);
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
        item1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFileChooser jfc=new JFileChooser();                        
			    jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
			    jfc.showDialog(new JLabel(), "选择");  
			    File file=jfc.getSelectedFile();  
			    if(file.isDirectory()){  
			//  System.out.println("文件夹:"+file.getAbsolutePath()); 
			    }else if(file.isFile()){  
			        String s=file.getAbsolutePath();  
			    }    
			}
		});
        item2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FileOutputStream outSTr = null;
			    BufferedOutputStream Buff = null;
				boolean flag = true;
				File file;
				//String test ;
				do{
					//test = "test"+count;
			    
					String inputValue = JOptionPane.showInputDialog("Please input file name"); 
					file = new File(inputValue+".txt");
					if (!file.exists()) {
			            // 创建文件
			            try {
			            	
			            	flag=file.createNewFile();
							
						} catch (IOException e) {
							e.printStackTrace();
							
						}
			            flag=false;
			        }
					else{
						
						JOptionPane.showMessageDialog(null, "该文件名已存在，请重新输入", "ERROR", JOptionPane.ERROR_MESSAGE);
						flag=true;
					}
				}while(flag);
				//写入文件
				String u_answer;
				try {
					outSTr = new FileOutputStream(file);
			        Buff = new BufferedOutputStream(outSTr);
			        System.out.println("选择是后执行的代码"+user_zongti.size()+user_answer.size()); 
				        for (int i = 0; i < user_zongti.size(); i++) 
				        {
				            try {
								Buff.write(user_zongti.get(i).getBytes());
								Buff.write("    ".getBytes());
								u_answer = user_answer.get(i);
								if(u_answer.equals(""))
									u_answer ="没有作答";
								
								Buff.write(u_answer.getBytes());
								Buff.write("\r\n".getBytes());
							} catch (IOException e) {
								e.printStackTrace();
								i--;
							}
				        }
			        Buff.flush();
			        Buff.close();
			        
					} catch (IOException e) {
						e.printStackTrace();
					}
					//Buff.close();
			        try {
						outSTr.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			        user_zongti.clear();
			        user_answer.clear();
			}
		});
        
        
        project.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				arithmetic art = new arithmetic();
				true_answer=art.list_answer;
				jta_timu = art.list_timu;
				jta_zong = art.list;
				answer_count=1;
				answer_all.setText("");
				for (int i = 0; i < art.list_timu.size(); i++)
				{
					user_zongti.add(jta_zong.get(i));
					answer_all.append(jta_timu.get(i));
					answer_all.append("\r\n");
				}
				num_answer.setText("第 "+answer_count+" 题");	
				jta.setText(jta_timu.get(answer_count-1));
				answer_count++;
				
				
			}
		});
        jb_next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String temp;
				temp = jta_answer.getText();
				
				if(jta.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "错误,请导入题库", "错误", JOptionPane.ERROR_MESSAGE);
					return;
				}
				jta_answer.setText("");
				if(answer_count<=20)
				{
					if(isInteger(temp))
					{
						  
						user_answer.add(temp);
						System.out.println("选择否后执行的代码"+temp+"user_size"+user_answer.size());
						num_answer.setText("第 "+answer_count+" 题");	
						jta.setText(jta_timu.get(answer_count-1));
						answer_count++;
					}
					else{
						JOptionPane.showMessageDialog(null, "错误", "请输入数字", JOptionPane.ERROR_MESSAGE);
					}
				}
				else{
					user_answer.add(temp);
					System.out.println("选择否后执行的代码"+temp+"user_size"+user_answer.size());
					answer_fenshu=0;
					for(int i=0;i<user_answer.size();i++)
					{
						if(user_answer.get(i).equals(true_answer.get(i)))
							answer_fenshu+=5;
					}
					user_fenshu.add(answer_fenshu);
					Object[] options = { "是", "取消" }; 
					int res=JOptionPane.showOptionDialog(null, "点击以继续 查看成绩", "答题完毕", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.YES_NO_OPTION, 
					null, options, options[0]); 
					if(res==JOptionPane.YES_OPTION){
						chart ct =new chart(user_fenshu);
						ct.setVisible(true);
						
					}else{
						Object[] option = { "是", "取消" }; 
						int res1=JOptionPane.showOptionDialog(null, "继续新一轮答题", "新一轮答题", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.YES_NO_OPTION, 
						null, option, option[0]); 
						
						if(res1==JOptionPane.YES_OPTION){
							arithmetic art = new arithmetic();
							true_answer=art.list_answer;
							
							jta_timu = art.list;
							answer_count=1;
							answer_all.setText("");
							jta_answer.setText("");
							for (int i = 0; i < art.list_timu.size(); i++)
							{
								user_zongti.add(jta_timu.get(i));
								answer_all.append(jta_timu.get(i));
								answer_all.append("\r\n");
							}
							num_answer.setText("第 "+answer_count+" 题");	
							jta.setText(jta_timu.get(answer_count-1));
							answer_count++;
							
						}else{
							
						}
						
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
