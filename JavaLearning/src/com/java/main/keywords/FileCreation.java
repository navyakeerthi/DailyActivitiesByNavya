package com.java.main.keywords;

import java.io.File;
import java.io.IOException;

public class FileCreation 
{
	public static void main(String args[])
	{
		File f=new File("E:\\training\\files\\jvm");
		System.out.println(f.isDirectory());
		
		File f1=new File("E:\\training\\files\\jvm\\abcd.txt.18-11-18");
		File f2=new File("E:\\training\\files\\jvm\\abcd.txt.18-11-19");
		File f3=new File("E:\\training\\files\\jvm\\abcd.txt.18-11-20");
		File f4=new File("E:\\training\\files\\jvm\\abcd.txt.18-11-21");
		File f5=new File("E:\\training\\files\\jvm\\abcd.txt.18-11-22");
		File f6=new File("E:\\training\\files\\jvm\\abcd.txt.18-11-23");
		File f7=new File("E:\\training\\files\\jvm\\abcd.txt.18-11-24");
		File f8=new File("E:\\training\\files\\jvm\\abcd.txt.18-11-25");
		File f9=new File("E:\\training\\files\\jvm\\abcd.txt.18-11-26");
		File f10=new File("E:\\training\\files\\jvm\\abcd.txt.18-11-27");
		try
		{
			f1.createNewFile();
			f2.createNewFile();
			f3.createNewFile();
			f4.createNewFile();
			f5.createNewFile();
			f6.createNewFile();
			f7.createNewFile();
			f8.createNewFile();
			f9.createNewFile();
			f10.createNewFile();	
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		//System.out.println(f.list().length);
		if(f.list().length>10)
		{
			
		}
	}
}
