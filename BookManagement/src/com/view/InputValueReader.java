package com.view;
//도스창에서 입력값을 읽는 클래스
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import com.dto.Book;

public class InputValueReader{
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public int readIntValue() throws IOException{
		
		int intValue=0;
		
		try{
			intValue = Integer.parseInt(in.readLine());
		}
		catch (NumberFormatException e1){
		}

		return intValue;
	}

	
	public String readStringValue(){
		
		String stringValue="";
		
		try{
			stringValue = in.readLine();
		}
		catch (IOException e2){
		}

		return stringValue;
	}
	
	public Book readBookData() throws IOException{
		
		try{
			String [] bookInfo = null;
			
			if((bookInfo = in.readLine().split("/"))!=null){
				
				Book book = new Book();				
				
				book.setName(bookInfo[0]);
				book.setAuthor(bookInfo[1]);
				book.setPublisher(bookInfo[2]);
				
				return book;
			}
			
		}
		catch (ArrayIndexOutOfBoundsException e3){
			FormatWriter.showMessage(Message.MESSAGE15);
		}
		return null;
	}
}