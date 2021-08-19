package lab.itank.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextIO {
	public static void main(String[] args) throws IOException {
		
		//파일에 쓰기
		FileWriter writer = new FileWriter("Mytext.txt");
		
		writer.write("파란색과 노란색을 더하면?/녹색\n");
		writer.write("빨간색과 흰색을 더하면?/분홍색\n");
		
		writer.close();
		
		File myFile = new File("Mytext.txt");
		BufferedReader reader = new BufferedReader(new FileReader(myFile));
		
		String line = null;
		
		//출력버전1
		//while((line = reader.readLine())!=null) {
			//System.out.println(line);
		//}
		
		//출력버전2 : split 사용법
		while((line = reader.readLine())!=null) {
			String[] result = line.split(",");
			
			for(String token : result) {				
				System.out.println(token);
			}
		}
		
		reader.close();
		

		
		
		
	}
}










