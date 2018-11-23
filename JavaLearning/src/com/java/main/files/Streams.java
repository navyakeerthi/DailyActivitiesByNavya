package com.java.main.files;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

public class Streams 
{
	File f=new File("E:\\training\\files","streams.txt");
	public void outputFileStream()
	{
		try
		{
			f.createNewFile();
			FileOutputStream fout=new FileOutputStream(f);
			fout.write(100);
			String a="ata inserted";
			byte b[]=a.getBytes();
			fout.write(b);
			fout.write(b, 4, 4);
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("successfully wrote to the file");
	}
	
	public void inputFileStream()
	{
		try
		{
			FileInputStream fin=new FileInputStream(f);
			int i=fin.read();
			while(i!=-1)
			{
				System.out.print((char)i);
				i=fin.read();
			}
//			int l=fin.available();
//			System.out.println(l);
			fin.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("successfully read from the file");
	}
	
	public void outputBufferedStream()
	{
		try
		{
			FileOutputStream fout=new FileOutputStream(f);
			BufferedOutputStream bout=new BufferedOutputStream(fout);
			String s="this is buffered method";
			byte b[]=s.getBytes();
			bout.write(b);
			bout.close();
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("successfully wrote to the file");
	}
	
	public void inputBufferedStream()
	{
		try
		{
			FileInputStream fin=new FileInputStream(f);
			BufferedInputStream bin=new BufferedInputStream(fin);
			int i=bin.read();
			while(i!=-1)
			{
				System.out.print((char)i);
				i=bin.read();
			}
			bin.mark(12);
			fin.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("successfully read the data");
	}
	
	public void inputSequenceStream()
	{
		try
		{
			FileInputStream fin1=new FileInputStream("E:\\training\\files\\navya\\cba.txt");
			FileInputStream fin2=new FileInputStream("E:\\training\\files\\navya\\buffer.txt");
			SequenceInputStream sis=new SequenceInputStream(fin1, fin2);
			int i=sis.read();
			while(i!=-1)
			{
				System.out.print((char)i);
				i=sis.read();
			}
			fin1.close();
			fin2.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("read from two files");
	}
	
	public void outputByteArrayStream()
	{
		try
		{
			FileOutputStream fout1=new FileOutputStream("E:\\training\\files\\navya\\cba.txt");
			FileOutputStream fout2=new FileOutputStream("E:\\training\\files\\navya\\buffer.txt");
			ByteArrayOutputStream bout=new ByteArrayOutputStream();
			String s="this is byte array method";
			byte b[]=s.getBytes();
			bout.write(b);
			bout.writeTo(fout1);
			bout.writeTo(fout2);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("successfully wrote the message to two files");
	}
	
	public void inputByteArrayStream()
	{
		byte[] b= {10,20,30,40};
		ByteArrayInputStream bin=new ByteArrayInputStream(b);
		int i=bin.read();
		while(i!=-1)
		{
			System.out.println(i);
			i=bin.read();
		}
		System.out.println("successfully read the byte array");
	}
	
	public void outputDataStream()
	{
		try
		{
			File f=new File("E:\\training\\files\\DataStream.txt");
			f.createNewFile();
			DataOutputStream dout=new DataOutputStream(new FileOutputStream(f));
			dout.writeInt(100);
			dout.writeDouble(99.0);
			dout.writeBoolean(true);
			dout.writeLong(98);
			dout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("successfully wrote to the file");
	}
	
	public void inputDataStream()
	{
		try
		{
			FileInputStream fin=new FileInputStream("E:\\training\\files\\DataStream.txt");
			DataInputStream dis=new DataInputStream(fin);
			int i=dis.available();
			byte[] b=new byte[i];
			dis.read(b);
			for(byte b1:b)
				System.out.print((char)b1);
			fin.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("Successfully read from the file");
	}
	
	
}
