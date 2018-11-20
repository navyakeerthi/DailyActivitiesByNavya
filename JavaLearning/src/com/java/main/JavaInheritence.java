package com.java.main;

class A
{
	public void display()
	{
		System.out.println("this is A");
	}
}

class C
{
	public void display()
	{
		System.out.println("this is C");
	}
}

class B extends A
{
	@Override
	public void display()
	{
		System.out.println("this is B");
	}
}
public class JavaInheritence extends A
{
	public static void main(String args[])
	{
		A a=new A();
		a.display();
		A ab=new B();
		ab.display();
	}
}
