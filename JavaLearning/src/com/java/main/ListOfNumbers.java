package com.java.main;

import java.util.ArrayList;
import java.util.List;

public class ListOfNumbers 
{
	public static void main(String args[])
	{
		int count=0;
		int j=0;
		List<Integer> list=new ArrayList<Integer>();
//		for(int i=1;i<=10;i++)
//		{
//			list.add(i);
//			count+=1;
//		}
		
		list.add(10);
		list.add(20);
		for(int list1:list)
		{
			j++;
		}
		
		System.out.println("the list is "+list+" with size "+j);
	}
}
