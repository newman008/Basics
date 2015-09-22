package OnlineBookReader;

public class Display {
	private Book activeBook;
	private User activeUser;
	private int pageNumber = 0;
	
	public void displayUser(User user) {
		activeUser = user;
		refreshUsername();
	}
	
	public void displayBook(Book book) {
		activeBook = book;
		pageNumber = 0;
		
		refreshTitle();
		refreshDetails();
		refreshPage();
	}
	
	public void turnPageForward() {
		pageNumber++;
		refreshPage();
	}
	
	public void turnPageBackward() {
		pageNumber--;
		refreshPage();
	}
	
	public void refreshUsername() {}
	public void refreshTitle() {}
	public void refreshDetails() {}
	public void refreshPage() {}
}
