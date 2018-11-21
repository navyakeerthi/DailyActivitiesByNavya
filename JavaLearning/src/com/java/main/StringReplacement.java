package com.java.main;

import java.util.ArrayList;
import java.util.List;

public class StringReplacement 
{
	public static void main(String args[])
	{
		List<String> list=new ArrayList<String>();
		list.add("abacdaca");
		list.add("abaca");
		list.add("cde");
		list.add("acacac");
		list.add("aaccaaca");
		List<Integer> ch=new ArrayList<Integer>();
		char c='a';
		for(String s:list)
		{
			char[] charstr=s.toCharArray();
			for(int i=0;i<charstr.length;i++)
			{
				if(s.charAt(i)==c)
				{
					ch.add(i);
				}
			}	
			System.out.println("the a occurred in the indices"+ch+" of string "+s);

			for(int j=0;j<=ch.size();j++)
			{
				for(int k=0;k<=ch.size();k++)
				{
					if(ch.get(j)+2==ch.get(k)&&s.charAt(j)=='a')
					{
						
					}
				}
			}
		}
	}
}
