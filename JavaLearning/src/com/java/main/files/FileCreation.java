package com.java.main.files;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreation 
{
	public static void main(String args[])
	{
		//file object for creating directory
		File f=new File("E:\\training\\files","navya");
		f.mkdir(); //creates a directory
		System.out.println(f.isDirectory()); //to check if the file object pointing to a directory or not
		f.setWritable(true);
		File f1=new File(f,"cba.txt");   //file object for for referring file
		try
		{
			f1.createNewFile(); // creating a new file
			f1.setWritable(true);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		String[] s=f.list();  //the list of files or directories present in the file object
		for(String s1:s)
			System.out.println(s1); //printing the list
		System.out.println(f.exists());// returns true if directory exists
		System.out.println(f1.isFile());  //to check if the file object is pointing to a file
		System.out.println(f1.length()); //returns long value that is cout of characters in the file
		
		//fileWriter
		
		try
		{
			System.out.println(f.getAbsolutePath());
			// creates the filewriter object to the fileobject f i.e. directory navya that gets appended to the esisting data
			FileWriter fw=new FileWriter(f1,true); 
			//FileWriter fw=new FileWriter("E:\\training\\files\\navya\\cba.txt",true); 
			fw.append('h'); //to write a single character
			fw.append("i all"); //appeds to the existing data
			fw.flush();//guarentees that total data including the lost data is appended to the file
			fw.close();//closes the writer
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		//fileReader
		try
		{
			FileReader fr=new FileReader(f1);// creating fileReader object for file
			int i=fr.read();//reads the file character wise and returns unicode value
			while(i!=-1)//until last character
			{
				System.out.println((char)i);//unicode value is type casted to char
				i=fr.read();//to read the next value
			}
			System.out.println("****************************");
			char[] ch=new char[(int)f1.length()];
			FileReader fr1=new FileReader(f1);
			fr1.read(ch);
			for(char c:ch)
			{
				System.out.println(c);
			}
			fr1.close();
			fr.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
	}
}