package com.java.main.files;

public class StreamsMain 
{
	public static void main(String args[])
	{
		Streams s=new Streams();
		s.outputFileStream();
		System.out.println();
		s.inputFileStream();
		System.out.println();
		s.outputBufferedStream();
		System.out.println();
		s.inputBufferedStream();
		System.out.println();
		s.inputSequenceStream();
		System.out.println();
		s.outputByteArrayStream();
		System.out.println();
		s.inputByteArrayStream();
		System.out.println();
		s.outputDataStream();
		System.out.println();
		s.inputDataStream();
	}
}
