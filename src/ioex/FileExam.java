package ioex;

import java.io.File;

public class FileExam {

	public static void main(String[] args) {

		System.out.println(File.pathSeparator);
		System.out.println(File.pathSeparatorChar);
		System.out.println(File.separator);
		System.out.println(File.separatorChar);
		
		File f = new File("C: " + File.separator + "temp");
		System.out.println(f.getName());
		System.out.println(f.getAbsolutePath());
	}

}
