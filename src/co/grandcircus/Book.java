package co.grandcircus;


public class Book {
	private String title;
	private String author;
	private String status;
	private String checkOut;
	
	

	public Book() {
	}

	public Book(String author, String title, String status, String checkOut) {
		super();
		this.title = title;
		this.author = author;
		this.status = status;
		this.checkOut = checkOut;
		
	}

	public String getauthor() {
		return author;
	}

	public void setauthor(String author) {
		this.author = author;
	}

	public String gettitle() {
		return title;
	}

	public void settitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return title + "," + author + "," + status + "," + checkOut;
	}

	public static Book fromString(String row) {
		String[] rowValues = row.split(", ");
		Book thatOne = new Book(rowValues[0], rowValues[1], rowValues[2], rowValues [3]);
		return thatOne;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

}