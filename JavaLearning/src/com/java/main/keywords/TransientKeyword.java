package com.java.main.keywords;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TransientKeyword 
{
	
	private transient char k='a';
	public void main(String args[])
	{
		char i='c';
		 
		
		File f=new File("E:\\training\\files\\navya\\keywords.txt");
		try
		{
			f.createNewFile();
			System.out.println("file created");
			FileWriter fw=new FileWriter(f,true);
			fw.write(k);
			fw.write(i);
			FileReader fr=new FileReader(f);
			int j=fr.read();
			while(j!=-1)
			{
				System.out.println((char)j);
				j=fr.read();
			}
			fw.close();
			fr.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}		
	}
}
