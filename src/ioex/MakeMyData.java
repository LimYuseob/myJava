package ioex;

import java.io.File;
import java.io.FileOutputStream;

import lombok.ToString;

public class MakeMyData {

	public static void main(String[] args) {
		byte[] win = {'w','i','n'};
		byte[] loss = {'l','o','s','s'};
		byte[] draw = {'d','r','a','w'};
		byte[] rate = {'r','a','t','e'};
		
		String fileName = "dladbtjq.txt";
		File f = null;
		FileOutputStream fos = null;
		
		
		
		try {
			f = new File(fileName);
			fos = new FileOutputStream(f);
			
			fos.write(win);
			fos.write(loss);
			fos.write(draw);
			fos.write(rate);
			
			
			
			
			 fos.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
