package com.java.main;

import java.util.ArrayList;
import java.util.List;

public class ListOfStrings 
{
	public static void main(String args[])
	{
		List<String> list=new ArrayList<String>();
		list.add("abacdaca");
		list.add("abaca");
		list.add("cde");
		list.add("acacac");
		List<Integer> ch=new ArrayList<Integer>();
		char c='a';
		for(String s:list)
		{
			for(int i=0;i<s.length();i++)
			{
				if(s.charAt(i)==c)
				{
					ch.add(i);
				}
			}	
			System.out.println("the a occurred in the indices"+ch+" of string "+s);
			for(int j=0;j<s.length();j++)
			{
				for(int k=0;k<s.length();k++)
				{
					if(k-j==2&&s.charAt(k)==s.charAt(j))
					{
						String str=s.replace(s.charAt(k-1),'*');
						System.out.println("the string after replacing the character in middle of a "+str);
					}
				}
			}
			System.out.println();
			ch.clear();
		}
	}
}