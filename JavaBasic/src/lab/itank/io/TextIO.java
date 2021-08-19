package lab.itank.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextIO {
	public static void main(String[] args) throws IOException {
		
		//���Ͽ� ����
		FileWriter writer = new FileWriter("Mytext.txt");
		
		writer.write("�Ķ����� ������� ���ϸ�?/���\n");
		writer.write("�������� ����� ���ϸ�?/��ȫ��\n");
		
		writer.close();
		
		File myFile = new File("Mytext.txt");
		BufferedReader reader = new BufferedReader(new FileReader(myFile));
		
		String line = null;
		
		//��¹���1
		//while((line = reader.readLine())!=null) {
			//System.out.println(line);
		//}
		
		//��¹���2 : split ����
		while((line = reader.readLine())!=null) {
			String[] result = line.split(",");
			
			for(String token : result) {				
				System.out.println(token);
			}
		}
		
		reader.close();
		

		
		
		
	}
}










