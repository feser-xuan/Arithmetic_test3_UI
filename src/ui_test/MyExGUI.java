package ui_test;

import java.awt.*;  
import javax.swing.*;  


public class MyExGUI extends JFrame{
	JMenuBar jmb;   //菜单条组件  
    JMenu menu1, menu2, menu3, menu4, menu5;//菜单  
    JMenuItem item1, item2, item3, item4, item5, item6;//菜单项  
    JMenu build;    //二级菜单  
    JMenuItem file, project;  
    JTextArea jta;  
      
    JToolBar jtb;//工具条  
    JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7;  
      
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
        project = new JMenuItem("工程");  
        item1 = new JMenuItem("打开");  
        item2 = new JMenuItem("保存(S)");  
        item3 = new JMenuItem("另存为");  
        item4 = new JMenuItem("页面设置");  
        item5 = new JMenuItem("打印");  
        item6 = new JMenuItem("退出");  
          
        jta = new JTextArea();  
          
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
        //创建工具条  
        jtb = new JToolBar();  
        jb1 = new JButton("新建");  
        jb1.setToolTipText("新建");//鼠标悬停提示信息  
        jb2 = new JButton("打开");  
        jb3 = new JButton("复制");  
        jb4 = new JButton("剪切");  
        jb5 = new JButton("打印");  
        jtb.add(jb1);  
        jtb.add(jb2);  
        jtb.add(jb3);  
        jtb.add(jb4);  
        jtb.add(jb5);  
        jta = new JTextArea();  
            //加入滚动条  
        //JScrollPane jsp = new JScrollPane(jta);  
        //jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  
          
        this.setJMenuBar(jmb);  //添加菜单栏，不能设定位置，会自动放在最上部  
        //this.add(jtb, BorderLayout.NORTH);  //添加工具条  
        //this.add(jsp, BorderLayout.CENTER); //添加文本域  
          
        this.setTitle("NotePad");  
        this.setSize(600, 500);  
        this.setVisible(true);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }
	
	
}
