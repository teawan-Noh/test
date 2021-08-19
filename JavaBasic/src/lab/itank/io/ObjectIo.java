package lab.itank.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectIo {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		GameUser user01 = new GameUser("tank", 13, "196.122.0.12");
		GameUser user02 = new GameUser("tami", 9, "196.122.0.16");
		
		ObjectOutputStream oos = 
				new ObjectOutputStream(new FileOutputStream("User.ser"));
		
		oos.writeObject(user01);
		oos.writeObject(user02);
		
		oos.close();
		
		user01 = null;
		user02 = null;
		
		ObjectInputStream ois =
				new ObjectInputStream(new FileInputStream("User.ser"));
		
		user01 = (GameUser)ois.readObject();
		user02 = (GameUser)ois.readObject();
		
		ois.close();
		
		System.out.println(user01.toString());
		System.out.println(user02);		
	}

}



