package com.java.main.keywords;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileCreation 
{
	public static void main(String args[]) throws ParseException
	{
		List<File> filelist=new ArrayList<File>();
		File f=new File("E:\\training\\files\\jvm");
	
		//creating 11 files
		File f1=new File("E:\\training\\files\\jvm\\abcd.18-11-18.txt");
		filelist.add(f1);
		File f2=new File("E:\\training\\files\\jvm\\abcd.18-11-19.txt");
		filelist.add(f2);
		File f3=new File("E:\\training\\files\\jvm\\abcd.18-11-20.txt");
		filelist.add(f3);
		File f4=new File("E:\\training\\files\\jvm\\abcd.18-11-21.txt");
		filelist.add(f4);
		File f5=new File("E:\\training\\files\\jvm\\abcd.18-11-22.txt");
		filelist.add(f5);
		File f6=new File("E:\\training\\files\\jvm\\abcd.18-11-23.txt");
		filelist.add(f6);
		File f7=new File("E:\\training\\files\\jvm\\abcd.18-11-24.txt");
		filelist.add(f7);
		File f8=new File("E:\\training\\files\\jvm\\abcd.18-11-25.txt");
		filelist.add(f8);
		File f9=new File("E:\\training\\files\\jvm\\abcd.18-11-26.txt");
		filelist.add(f9);
		File f10=new File("E:\\training\\files\\jvm\\abcd.18-11-27.txt");
		filelist.add(f10);
		File f11=new File("E:\\training\\files\\jvm\\abcd.18-11-28.txt");
		filelist.add(f11);
		File f12=new File("E:\\training\\files\\jvm\\abcd.18-11-29.txt");
		filelist.add(f12);
		File f13=new File("E:\\training\\files\\jvm\\abcd.18-11-30.txt");
		filelist.add(f13);
		try
		{
			f1.createNewFile();
			f3.createNewFile();
			f4.createNewFile();
			f5.createNewFile();
			f6.createNewFile();
			f7.createNewFile();
			f2.createNewFile();
			f9.createNewFile();
			f10.createNewFile();
			f11.createNewFile();
			f8.createNewFile();
			f12.createNewFile();
			f13.createNewFile();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}		
		System.out.println("Files created successfully\n");	
		Date beforeDate=new SimpleDateFormat("yy-MM-dd").parse(filelist.get((f.listFiles().length)-10).getName().substring(5, 13));
		
		if(f.listFiles().length>10)
		{			
			System.out.println("the no of files in the directory are "+f.list().length);
			for(File file:filelist)
			{
				String fname=file.getName().substring(5,13);
				Date fileDate=new SimpleDateFormat("yy-MM-dd").parse(fname);
				if(beforeDate.compareTo(fileDate)>0)
				{
					file.delete();
					System.out.println(file.getName()+" got deleted successfully");
				}
			}
		}
		else
		{
			System.out.println("there are only 10 files in the directory");
		}
	}
}
