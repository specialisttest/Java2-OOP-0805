package ru.specialist;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {
		File dir = new File("../");
		System.out.println(dir.getCanonicalPath());
		
		int days = 1;
		
		// только файлы
		//File[] files = dir.listFiles( pathname-> pathname.isFile()); 
		
		// только файлы модифицированные за последние сутки
		File[] files = dir.listFiles( 
			pathname -> pathname.isFile() &&
				(System.currentTimeMillis()-pathname.lastModified() 
						< (long)days*24*60*60*1000));
				
				
		for(File f : files)
			System.out.printf("%-15s %tF %<tR\n", f.getName(), f.lastModified());

	}

}
