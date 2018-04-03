package ui_test;

import java.awt.Color;  
import java.awt.Graphics;  
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;  
  
import javax.swing.JFrame;
  
public class chart extends JFrame{
	  //绘制柱形统计图  
		ArrayList<Integer> ran=new  ArrayList<Integer>();
	    public chart(ArrayList<Integer> scores)
	    {  
	        super();  
	        getContentPane().setForeground(Color.CYAN);
	        setForeground(Color.CYAN);
	        setBackground(Color.CYAN);
	        for(int i=0;i<scores.size();i++)
	        {
	        	ran.add(scores.get(i));
	        	System.out.println(scores.get(i));
	        }
	          
	        setTitle("绘制柱形图");  
	        setSize(600, 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    }  
	    @Override  
	    public void paint(Graphics g){
	    	int Width = getWidth();
	        int Height = getHeight();
	        int leftMargin = 20;//柱形图左边界
	        int topMargin = 50;//柱形图上边界
	        Graphics2D g2 = (Graphics2D) g;
	        g2.setColor(Color.WHITE);//绘制白色背景
	        g2.fillRect(0, 0, Width, Height-100);//绘制矩形图
	        g2.setColor(Color.black);
	         for(int i=0;i<=10;i++)
	         {
	        	 //绘制灰色横线和百分比
	             g2.drawString((100-10*i)+"", 15, topMargin+30*i);
	             g2.drawLine(5, topMargin+30*i, Width, topMargin+30*i);//绘制灰色横线
	         }
	         g2.setColor(Color.YELLOW);
	         for(int i=0;i<=ran.size();i++)
	         {
	        	 //绘制柱形图
	             int step = (i+1)*40;//设置每个柱形图的水平间隔为40
	             //绘制矩形
	             g2.fillRoundRect(leftMargin+step*2-5,(100-ran.get(i))*3+50, 40, 300-(100-ran.get(i))*3, 40, 10);
	             //列出测试轮数
	             g2.drawString("第"+(i+1)+"轮", leftMargin+step*2, 380);
	         }    
	     }  

    
}  

