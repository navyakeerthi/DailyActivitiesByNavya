package com.java.main.keywords;

public class SynchronizedKeyword extends Thread
{
	public static void main(String args[])
	{
		Table t=new Table();
		Thread1 t1=new Thread1(t);
		Thread2 t2=new Thread2(t);
		t1.start();
		t2.start();
	}	
}

class Table
{
	synchronized void printTable(int n)
	{
		for(int i=0;i<5;i++)
		{
			System.out.println(i*n);
			try
			{
				Thread.sleep(400);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}

class Thread1 extends Thread
{
	Table t;
	Thread1(Table t)
	{
		this.t=t;
	}
	public void run()
	{
		t.printTable(2);
	}
}

class Thread2 extends Thread
{
	Table t;
	Thread2(Table t)
	{
		this.t=t;
	}
	public void run()
	{
		t.printTable(5);
	}
}