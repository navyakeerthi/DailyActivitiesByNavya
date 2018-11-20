package com.java.main;

abstract class Example
{
	abstract void display();
}

class Example2 extends Example
{
	void display()
	{
		System.out.println("class name is "+getClass().getName());
	}
}
public class Anonymous 
{
	public static void main(String args[])
	{
		Example e=new Example2();
		e.display();
	}
}


//public class Anonymous
//{
//	public static void main(String args[])
//	{
//		Example e=new Example() {
//			
//			@Override
//			void display() {
//				System.out.println("class is "+getClass().getName().);
//				
//			}
//		};
//		e.display();
//	}
//}

