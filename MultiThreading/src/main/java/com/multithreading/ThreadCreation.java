package com.multithreading;

import java.util.ArrayList;
import java.util.List;

public class ThreadCreation extends Thread
{
	List<Integer> digit=new ArrayList<Integer>();
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			int j=i*10;
			digit.add(j);
		}

		for(int i=0;i<=100;i++)
		{
			if(digit.contains(i))
			{
				try
				{
					Thread.sleep(1000*10);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else
			{
				System.out.println(Thread.currentThread().getName()+"\t"+i);
			}
		}
	}
	
	public static void main(String args[])
	{
		ThreadCreation t1=new ThreadCreation();
		t1.start();
	}
}
