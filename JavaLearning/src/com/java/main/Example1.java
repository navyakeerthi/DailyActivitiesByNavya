package com.java.main;

abstract class Abstrcation 
{
	abstract void display();
	final void show()
	{
		System.out.println("hai in abstract class");
	}
	
}

class Example1 extends Abstrcation
{
	void display()
	{
		System.out.println("hai in display");
	}
	public static void main(String args[])
	{
		System.out.println("hai in main");
		Example1 a=new Example1();
		a.display();
		a.show();
	}
}
