package co.grandcircus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LibraryApp {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		// StringBuilder sb = new StringBuilder();
		// String strLine = "";
		ArrayList<Book> bookList = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		String fileName = "BookList.txt";
		Path filePath = Paths.get("resources", fileName);
		File file = filePath.toFile();
		BufferedReader br = null;

		String title = null;
		String author = null;
		String status = null;
		String checkOut = null;
		String arr[] = null;

		// String title;
		// String author;
		Book book = null;
		try {
			br = new BufferedReader(new FileReader(filePath.toFile()));
		} catch (FileNotFoundException e1) {
			System.out.println("Issue with liBrary app line 27");
			e1.printStackTrace();
		}
		String line = "";
		int lineCounter = 0;

		try {
			while ((line = br.readLine()) != null) {
				arr = line.split(",");

				title = arr[0];
				author = arr[1];
				status = arr[2];
				checkOut = arr[3];

				book = new Book(title, author, status, checkOut);
				bookList.add(book);

				// System.out.println(book.getauthor(author).contains("Her"));
				// if(book.getauthor("Herman") != null) {
				// System.out.println(book.getauthor("Herman"));
				// }

				lineCounter++;
				System.out.println(lineCounter + ". " + line);
				// bookList.add(book);

			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println(bookList.get(2));
		// System.out.println(bookList);

		boolean userQuit = false;
		do {

			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Please choose one of the following: ");
			System.out.println("1. ~Display a list of Books~");
			System.out.println("2. ~Search Booklist By Author~");
			System.out.println("3. ~Search Booklist By Title Keyword~");
			System.out.println("4. ~Search All words of Library~");
			System.out.println("5. ~Check Out Book~");
			System.out.println("5. ~Return Checked Out Book~");
			System.out.println("6. ~Add Book To BookList~");
			System.out.println("7. ~Quit~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

			int userIntInput = Validator.getInt(scan, "", 1, 7);
			// System.out.println(userIntInput);
			// ArrayList<Book> bookArr = new ArrayList<>();

			if (userIntInput == 1) {

				int lineCount = 0;

				for (int i = 0; i < bookList.size(); i++) {

					lineCount++;
					System.out.println(lineCount + ". " + bookList.get(i));
				}

			} else if (userIntInput == 2) {
				System.out.println("Which author are you interested in?");
				String authorSer = scan.nextLine();
				for (int i = 0; i < bookList.size(); i++) {
					if (bookList.get(i).getauthor().contains(authorSer)) {
						System.out.println(bookList.get(i));
					}

				}
			}

			else if (userIntInput == 3) {
				System.out.println("Search By Keyword in Title: ");
				String keyTitle = scan.nextLine();

			//	for(int i =0; )

			} else if (userIntInput == 4) {
				System.out.println("What word are you looking for?");
				String authorSearch = scan.nextLine();
				int lineNum = 0;

				Scanner scanner = null;
				try {
					scanner = new Scanner(file);
				} catch (FileNotFoundException e) {
					System.out.println("System Failed Searching for Author");
				}
				while (scanner.hasNextLine()) {
					final String lineFromFile = scanner.nextLine();
					lineNum++;
					if (lineFromFile.contains(authorSearch)) {
						try {
							lineNum = lineNum - 1;
							for (int i = 0; i < lineNum; i++) {
								br.readLine();
							}
							System.out.println(br.readLine());
						} catch (IOException e) {
							System.out.println("br readline failed in library app");
							e.printStackTrace();
						}

						break;
					}
				}

				// check out book

			} else if (userIntInput == 5) {
				// return checked out book

			} else if (userIntInput == 6) {

				System.out.println("What book do you want to add?");
				String bookAdd = scan.nextLine();
				System.out.println("Whose the Author?");
				String bookAddAuthor = scan.nextLine();
				// BigInteger userPopBigInt = BigInteger.valueOf(userPopInput);
				Book newBook = new Book(bookAdd, bookAddAuthor, "Checked in", "");
				// bookArr.add(newBook);

				// BookListEdit.writeBooksToFile(filePath, bookArr);
			}

			else {
				userQuit = true;
			}

		} while (!userQuit);
		System.out.println("Thank You For Using the Library App. Have a Great Day");
	}

}