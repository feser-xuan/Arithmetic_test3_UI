package ui_test;

import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;  


public class MyExGUI extends JFrame{
	ArrayList<String> user_answer = new ArrayList<String>();
	ArrayList<String> true_answer = new ArrayList<String>();
	JMenuBar jmb;   //�˵������  
    JMenu menu1, menu2, menu3, menu4, menu5;//�˵�  
    JMenuItem item1, item2, item3, item4, item5, item6;//�˵���  
    JMenu build;    //�����˵�  
    JMenuItem file, project; 
    TextArea answer_all = new TextArea();
    TextField jta = new TextField();
    TextField jta_answer = new TextField(); 
    JLabel num_answer = new JLabel();
    JLabel answer1,answer2,answer3,answer4,answer5,answer6,answer7,answer8,answer9,answer10,
    answer11,answer12,answer13,answer14,answer15,answer16,answer17,answer18,answer19,answer20;
    JToolBar jtb;//������  
    JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7,jb_next;  
    int answer_count;
    public MyExGUI()
    {  
        //�����˵�  
        jmb = new JMenuBar();  
        
        menu1 = new JMenu("�ļ�(F)");  
        menu1.setMnemonic('f'); //���Ƿ�  
        menu2 = new JMenu("�༭");  
        menu2.setMnemonic('E');  
        menu3 = new JMenu("��ʽ");  
        menu4 = new JMenu("�鿴");  
        menu5 = new JMenu("����");  
          
        build = new JMenu("�½�");  
          
        file = new JMenuItem("�ļ�");  
        project = new JMenuItem("����");  
        item1 = new JMenuItem("��");  
        item2 = new JMenuItem("����(S)");  
        item3 = new JMenuItem("���Ϊ");  
        item4 = new JMenuItem("ҳ������");  
        item5 = new JMenuItem("��ӡ");  
        item6 = new JMenuItem("�˳�");  
        
        answer1 = new JLabel("��  1 ��");
        answer2= new JLabel("�ڶ���");
        answer3= new JLabel("������");
        answer4= new JLabel("������");
        answer5= new JLabel("������");
        answer6= new JLabel("������");
        answer7= new JLabel("������");
        answer8= new JLabel("�ڰ���");
        answer9= new JLabel("�ھ���");
        answer10= new JLabel("��ʮ��");
        answer11= new JLabel("��ʮһ��");
        answer12= new JLabel("��ʮ����");
        answer13= new JLabel("��ʮ����");
        answer14= new JLabel("��ʮ����");
        answer15= new JLabel("��ʮ����");
        answer16= new JLabel("��ʮ����");
        answer17= new JLabel("��ʮ����");
        answer18= new JLabel("��ʮ����");
        answer19= new JLabel("��ʮ����");
        answer20= new JLabel("�ڶ�ʮ��");
          
        
          
            //��Ӳ˵������˵���  
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
            //���˵��������˵���  
        jmb.add(menu1);  
        jmb.add(menu2);  
        jmb.add(menu3);  
        jmb.add(menu4);  
        jmb.add(menu5);  
          
        
    	JPanel contentPanel = new JPanel();
    	contentPanel.setLayout(null);
    	JLabel daan = new JLabel("��");
    	JLabel dengyu = new JLabel("=");
        num_answer=answer1;
        num_answer.setFont(new Font("����",Font.BOLD, 22));
        jb_next = new JButton("��һ��");
        jta.setFont(new Font("����",Font.BOLD, 22));
        jta_answer.setFont(new Font("����",Font.BOLD, 22));
        jb_next.setFont(new Font("����",Font.BOLD, 22));
        daan.setFont(new Font("����",Font.BOLD, 22));
        dengyu.setFont(new Font("����",Font.BOLD, 22));
        
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
        
        this.setJMenuBar(jmb);  //��Ӳ˵����������趨λ�ã����Զ��������ϲ�  
        this.add(contentPanel);
        
        this.setTitle("���ߴ���ϵͳ");  
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
					num_answer.setText("��  "+answer_count+" ��");
					if(answer_count<20)
						answer_count++;
					else{
						
						Object[] options = { "��", "ȡ��" }; 
						JOptionPane.showOptionDialog(null, "����Լ��� �鿴�ɼ�", "�������", 
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
