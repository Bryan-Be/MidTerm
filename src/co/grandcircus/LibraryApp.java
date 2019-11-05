package co.grandcircus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {

	public static void main(String[] args) {
		ArrayList<Book> bookList = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		String fileName = "BookList.txt";
		Path filePath = Paths.get("resources", fileName);
		@SuppressWarnings("unused")
		File file = filePath.toFile();
		BufferedReader br = null;
		LocalDate currentDate = LocalDate.now();
		LocalDate dueBack = currentDate.plusWeeks(2);
		String stringDate = dueBack.toString();

		String title = null;
		String author = null;
		String status = null;
		String checkOut = null;
		String arr[] = null;

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

				lineCounter++;
				System.out.println(lineCounter + ". " + line);

			}
		} catch (IOException e1) {
			System.out.println("error on line 56");
			// e1.printStackTrace();
		}

		boolean userQuit = false;

		do {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Please choose one of the following: ");
			System.out.println("1. ~Display a list of Books~");
			System.out.println("2. ~Search Booklist By Author~");
			System.out.println("3. ~Search Booklist By Title Keyword~");
			System.out.println("4. ~Check Out Book~");
			System.out.println("5. ~Return Checked Out Book~");
			System.out.println("6. ~Add Book To BookList~");
			System.out.println("7. ~Quit~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			int userIntInput = Validator.getInt(scan, "", 1, 7);

			if (userIntInput == 1) {
				int lineCount = 0;
				for (int i = 0; i < bookList.size(); i++) {
					lineCount++;
					System.out.println(lineCount + ". " + bookList.get(i));
				}

			} else if (userIntInput == 2) {
				System.out.println("Which author are you interested in?");
				String authorSer = scan.nextLine().toLowerCase();
				for (int i = 0; i < bookList.size(); i++) {
					if (bookList.get(i).getauthor().toLowerCase().contains(authorSer)) {
						System.out.println(bookList.get(i));
					}

				}
			}

			else if (userIntInput == 3) {
				System.out.println("Search By Keyword in Title: ");
				String keyTitle = scan.nextLine().toLowerCase();
				for (int i = 0; i < bookList.size(); i++) {
					if (bookList.get(i).gettitle().toLowerCase().contains(keyTitle)) {
						System.out.println(bookList.get(i));
					}

				}

			} else if (userIntInput == 4) {
				System.out.println("Please choose the book title you are interested in checking out:");
				String keyTitle = scan.nextLine().toLowerCase();
				for (int i = 0; i < bookList.size(); i++) {
					if (bookList.get(i).gettitle().toLowerCase().contains(keyTitle)) {
						System.out.println(bookList.get(i));
						bookList.get(i).setStatus("Check-Out");
						bookList.get(i).setCheckOut(stringDate);
						System.out.println(bookList.get(i));
						BookListEdit.writeBooksToFile(filePath, bookList);

					}
				}

			} else if (userIntInput == 5) {

				for (int i = 0; i < bookList.size(); i++) {
					if (bookList.get(i).getStatus().toLowerCase().contains("out")) {
						System.out.println(bookList.get(i));
					}
				}
				System.out.println("Which book would you like to return?");
				String returnTitle = scan.nextLine();
				for (int i = 0; i < bookList.size(); i++) {
					if (bookList.get(i).gettitle().toLowerCase().contains(returnTitle)) {
						System.out.println(bookList.get(i));
						bookList.get(i).setStatus("Checked-In");
						bookList.get(i).setCheckOut(" ");
						BookListEdit.writeBooksToFile(filePath, bookList);
						System.out.println(bookList.get(i));
					}

				}

			} else if (userIntInput == 6) {
				System.out.println("What book do you want to add?");
				String bookAdd = scan.nextLine();
				System.out.println("Whose the Author?");
				String bookAddAuthor = scan.nextLine();
				Book newBook = new Book(bookAdd, bookAddAuthor, "Checked in", " ");
				bookList.add(newBook);

				BookListEdit.writeBooksToFile(filePath, bookList);

			} else {
				userQuit = true;
			}

		} while (!userQuit);
		System.out.println("Thank You For Using the Library App. Have a Great Day");
		scan.close();
	}

}