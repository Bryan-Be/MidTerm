package co.grandcircus;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class LibraryApp {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

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
			String fileName = "BookList.txt";
			Path filePath = Paths.get("resources", fileName);

			int userIntInput = Validator.getInt(scan, "", 1, 3);
			//System.out.println(userIntInput);
			ArrayList<Book> bookArr = new ArrayList<>();

			if (userIntInput == 1) {
				//Read display Book list
				BookListEdit.readFromFile(filePath);
				for (Book c : bookArr) {
					System.out.println(c);
				}

			} else if (userIntInput == 2) {
			

			}else if(userIntInput == 3) {
				//Search by keyword in title
				
				
			}else if(userIntInput == 4) {
				//check out book
				
				
			}else if(userIntInput == 5) {
				//return checked out book
				
				
			}
				
			else { userQuit = true;
			}

		} while (!userQuit);
		System.out.println("Thank You For Using the Library App. Have a Great Day");
	}

}