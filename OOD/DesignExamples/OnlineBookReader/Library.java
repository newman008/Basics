package OnlineBookReader;

import java.util.*;

public class Library {
    private HashMap<Integer, Book> books;
    
    public Book addBook(int id, String detail) {
        if(books.containsKey(id)) return null;
        
        Book book = new Book(id, detail);
        books.put(id, book);
        return book;
    }
    
    public boolean removeBook(Book b) {
        return removeBook(b.getID());
    }
    
    public boolean removeBook(int id) {
        if(!books.containsKey(id)) return false;
        books.remove(id);
        return true;
    }
    
    public Book findBook(int id) {
        return books.get(id);
    }
}
