package OnlineBookReader;

public class Book {
	private int bookId;
	private String details;
	
	public Book(int id, String det) {
		bookId = id;
		details = det;
	}
	
	public int getID() { return bookId; }
	public void setID(int id) { bookId = id; }
	public String getDetails() { return details; }
	public void setDetails(String d) { details = d; }
}
