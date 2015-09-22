package InMemoryFileSystem;

public class File extends Entry{
	private String content;
	private int size;
	
	public File(String n, Directory p, int sz) {
		super(n, p);
		size = sz;
	}
	
	public int size() { return size; }
	public String getContent() { return content; }
	public void setContent(String c) { content = c; } 
	
}
