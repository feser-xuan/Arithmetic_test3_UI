package ui_test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class arithmetic 
{
	ArrayList<String> list = new ArrayList<String>();
	ArrayList<String> list_timu = new ArrayList<String>();
	ArrayList<String> list_answer = new ArrayList<String>();
	public  arithmetic()
	{
		    FileOutputStream outSTr = null;
		    BufferedOutputStream Buff = null;
		    int number_n=20,count;
			
			ArrayList<String> list_temp = new ArrayList<String>();
			String[] operator = new String[]{"+","-","*","/"};
			
			Random rand = new Random();
			File file1 = new File("result.txt");
			if (file1.exists()) {
	            // 创建文件
	            try {
					file1.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
			
			
			while(number_n>0)
			{
				int[] number_temp = new int[rand.nextInt(2)+3];
				String[] str_temp = new String[number_temp.length-1];
				for(int i=0;i<number_temp.length;i++)
				{
					if(i<number_temp.length-1)
					{
						number_temp[i]=rand.nextInt(100);
						list_temp.add(String.valueOf(number_temp[i]));
						str_temp[i]=operator[rand.nextInt(4)];
						list_temp.add(str_temp[i]);
						
					}
							
					else
					{
						number_temp[i]=rand.nextInt(100);
						list_temp.add(String.valueOf(number_temp[i]));
					}
				}
				
				count=calculate_RPN(produce_RPN(list_temp));
				if(count !=-1)
				{
					list_timu.add(transform_string(list_temp));
					list_answer.add(String.valueOf(count));
					list_temp.add(" = "+count);
					list.add(transform_string(list_temp));
					number_n--;
					list_temp.clear();
				}
				else
					list_temp.clear();
				System.out.println(number_n);
				
			}
			try {
			outSTr = new FileOutputStream(file1);
	        Buff = new BufferedOutputStream(outSTr);
		        try {
					Buff.write("201571030104  丁炜轩".getBytes());
					Buff.write("\r\n".getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
		        for (int i = 0; i < list.size(); i++) 
		        {
		            try {
						Buff.write(list.get(i).getBytes());
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
	       
	        for (int i = 0; i < list.size(); i++) 
	        {
	        	System.out.print(list.get(i));
	        	System.out.println();
	        }
			System.out.print("计算完毕！");
		  
		}
		
		public static int calculate_RPN(ArrayList<String> list_temp)
		{
			int i=0,t;
			double a=0,b=0;
			String l_temp;
			Stack sk=new Stack(20);
			for(t=0;t<list_temp.size();t++)
			{
				l_temp = list_temp.get(i++);
				if(!isInteger(l_temp))
				{
					b = sk.mypop();
					a = sk.mypop();
					switch(l_temp)
					{
					case "+":sk.mypush(a+b);break;
					case "-":sk.mypush(a-b);break;
					case "*":sk.mypush(a*b);break;
					case "/":
						if(b==0)
							return -1;
						sk.mypush(a/b);break;
					}
					System.out.println("st.mytop: "+sk.mypeek());
				}
				else{
					sk.mypush((double)Integer.parseInt(l_temp));
				}
				
			}
			if(!sk.myisempty())
			{
				a = sk.mypop();
				b = a-(int)a;
				System.out.println("a:  "+a);
				if(a>0 && b==0 )
				{
					return (int)a;
				}
				else
					return -1;
			}
			else
				return -1;
			
		}
		
		
		public static ArrayList<String> produce_RPN(ArrayList<String> list_temp)
		{
			int t=0,i=0;
			String tmp;
			Tack mytack = new Tack(20);
			ArrayList<String> lt_temp = new ArrayList<String>();
			while(true)
			{
				tmp = list_temp.get(i++);
				if(isInteger(tmp))
				{
					lt_temp.add(tmp);
				}
				else{
					if(mytack.myisempty())
					{
						mytack.mypush(tmp);
					}
						
					
					else{
						if(isCPriority(tmp, mytack.mypeek()))
							mytack.mypush(tmp);
						else{
							lt_temp.add(mytack.mypop());
							mytack.mypush(tmp);
						}
						
					}
				}
				if(i>=list_temp.size())
				{
					while(!mytack.myisempty())
						lt_temp.add(mytack.mypop());
					System.out.println(transform_string(list_temp));
					list_temp = lt_temp;
					System.out.println(list_temp);
					return list_temp;
				}
			}
			
			
		}
		
		
		
		public static boolean isInteger(String str) {    
		    for (int i = str.length();--i>=0;){  
				        if (!Character.isDigit(str.charAt(i))){
				            return false;
				        }
				    }
				    return true;
		  } 
		public static boolean isCPriority(String str,String s) { 
			if((str+s).equals("*+") || (str+s).equals("*-") || (str+s).equals("/+") || (str+s).equals("/-"))
		    	return true;
		    else
		    	return false;    
		  }
		public static String transform_string(ArrayList<String> list_temp)
		{
			String s="";
			for(int i=0;i<list_temp.size();i++)
			{
				s+=list_temp.get(i);
			}
			return s;
			
		}
		  
	    static class Stack
	    {
	        int mytop;
	        double stk[];
	        
	        public Stack(int num) {
	            mytop=-1;
	            stk=new double[num];
	        }
	        /*出栈*/
	        double mypop()
	        {
	        	double peek=stk[mytop];
	            mytop--;
	            return peek;
	        }
	        /*入栈*/
	        void mypush(double x)
	        {
	            mytop++;
	            stk[mytop]=x;
	            
	        }
	        /*判空*/
	        Boolean myisempty()
	        {
	            if(mytop==-1)
	                return true;
	            else
	                return false;
	        }
	        /*取栈顶元素*/
	        double mypeek()
	        {
	        	double peek=stk[mytop];
	            return peek;
	        }
	        /*栈大小*/
	        int mysize()
	        {
	            return mytop+1;
	        }
	    }
		
		static class Tack
	    {
	        int mytop;
	        String tk[];
	        
	        public Tack(int num) {
	            mytop=-1;
	            tk=new String[num];
	        }
	        /*出栈*/
	        String mypop()
	        {
	        	String peek=tk[mytop];
	            mytop--;
	            return peek;
	        }
	        /*入栈*/
	        void mypush(String x)
	        {
	            mytop++;
	            tk[mytop]=x;
	            
	        }
	        /*判空*/
	        Boolean myisempty()
	        {
	            if(mytop==-1)
	                return true;
	            else
	                return false;
	        }
	        /*取栈顶元素*/
	        String mypeek()
	        {
	        	String peek=tk[mytop];
	            return peek;
	        }
	        /*栈大小*/
	        int mysize()
	        {
	            return mytop+1;
	        }
	    

	}


}
