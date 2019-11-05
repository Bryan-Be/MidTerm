package co.grandcircus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;

public class BookListEdit {

	public static boolean writeBooksToFile(Path filePath, ArrayList<Book> book) {

		File file = filePath.toFile();

		try (PrintWriter output = new PrintWriter(new FileOutputStream(file));) {

			for (Book c : book) {
				output.println(c);
			}
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("The file does not exist" + filePath);
			//e.printStackTrace();
			return false;
		}
	}

	public static ArrayList<Book> readFromFile(Path filePath) {
		ArrayList<Book> BookListFile = new ArrayList<>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath.toFile()));

			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				Book newBook = Book.fromString(line);
				BookListFile.add(newBook);
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException b) {
			// TODO Auto-generated catch block
			b.printStackTrace();
		} catch (IOException e) {

		} finally {

		}
		return BookListFile;
	}
	
	
	
	
}