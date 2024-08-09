package ru.specialist;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Date;

import java.util.zip.*;

import static java.lang.System.out;

public class App {
	
	// ../test1.txt
	public static final String fileName1 =
			".." + File.separator + "test1.txt";
	
	public static final String fileName2 =
			".." + File.separator + "test2.txt";
	
	// ../
	public static final String dir1 =
			".." + File.separator;

	public static void main(String[] args) throws IOException {
		File f1 = new File(fileName1);
		if (!f1.exists())
			f1.createNewFile();
		
		Date lm = new Date(f1.lastModified());
		out.println(lm.toLocaleString());
		out.println(f1.getCanonicalPath());
		
		File d1 = new File(dir1); // ../
		out.println(d1.getCanonicalPath());
		
		File[] files = d1.listFiles(  );
		for(File file : files) {
			if(file.isDirectory())
				out.println(file.getName().toUpperCase());
			if(file.isFile())
				out.println(file.getName().toLowerCase());
		}
		
//		FileInputStream fin = new FileInputStream(fileName1);
//		var buf = new byte[1000];
//		fin.read(buf);
//		fin.close();
		
//		var reader = new BufferedReader(new InputStreamReader(fin, Charset.forName("cp1251")));
//		String line = null;
//		while ( (line = reader.readLine()) != null )
//			out.println(line);
		//reader.close();
//		fin.close();
		
		try(FileInputStream fin = new FileInputStream(fileName1);
			var reader = new BufferedReader(new InputStreamReader(fin, Charset.forName("cp1251")))) {
			
			String line = null;
			while ( (line = reader.readLine()) != null )
				out.println(line);
			
		} // reader.close(); fin.close();
		
		
		
		
		PrintWriter writer = null;
		try {
			var fout = new FileOutputStream(fileName2);
			//fout.write(null);
			writer = new PrintWriter(fout, false, Charset.forName("cp1251") );
			
			writer.printf("%-20s : %d\n", "Java 1 - Основы", 40);
			//writer.flush();
			writer.printf("%-20s : %d\n", "Java 2 - ООП", 40);
			writer.printf("%-20s : %d\n", "Git", 16);
			
			
		} catch (IOException ex) {
			out.println(ex.getMessage());
		} finally {
			if (writer != null)
				writer.close();
		}
		
		
		
		ZipOutputStream zip = new ZipOutputStream(new FileOutputStream("../test.zip"));
		ZipEntry entry = new ZipEntry("data.txt");
		
		zip.putNextEntry(entry);
		
		zip.close();
		

	}

}
