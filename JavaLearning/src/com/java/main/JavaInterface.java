package com.java.main;

interface Z
{
	public void display();
}

interface X
{
	public void display();
}
class Y implements Z,X
{
	@Override
	public void display()
	{
		System.out.println("this is Y");
	}
}
public class JavaInterface 
{
	public static void main(String args[])
	{
		Y z=new Y();
		z.display();
	}
	
}
