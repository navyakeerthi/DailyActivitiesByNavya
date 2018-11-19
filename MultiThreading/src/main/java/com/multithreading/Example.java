package com.multithreading;

public class Example implements Runnable
{
	
	String dsdsds=null;
	public Example(String clssName) {
		dsdsds=clssName;
		System.out.println(clssName);
	}
	public void run()
	{
		for(int i=0;i<5;i++)
		{
			try
			{
				Thread.sleep(1000);
				System.out.println(dsdsds+i);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	public static void main(String args[])
	{
		Example e1=new Example("e1");
		Example e2=new Example("e2");
		Example e3=new Example("e3");
		
		Thread t1=new Thread(e1);
		Thread t2=new Thread(e2);
		Thread t3=new Thread(e3);
		
		t1.start();
		try
		{
			t1.join();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		t2.start();
		t3.start();
	}
}
