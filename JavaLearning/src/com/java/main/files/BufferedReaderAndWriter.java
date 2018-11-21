package com.java.main.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class BufferedReaderAndWriter 
{
	public static void main(String args[])
	{
		File f=new File("E:\\training\\files\\navya","buffer.txt");
		try
		{
			f.createNewFile();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		//writing through buffered writer
		try
		{
			BufferedWriter bw=new BufferedWriter(new FileWriter(f,true));
			bw.write("hai");
			bw.newLine();
			bw.write("everyone");
			bw.flush();
			bw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		//reading from file using buffered reader
		try
		{
			BufferedReader br=new BufferedReader(new FileReader(f));
			String line=br.readLine();
			while(line != null)
			{
				System.out.println(line);
				line=br.readLine();
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
