package InMemoryFileSystem;

import java.util.*;

public class Directory extends Entry{
	protected ArrayList<Entry> contents;

	public Directory(String n, Directory p) {
		super(n, p);
		contents = new ArrayList<Entry>();
	}
	@Override
	public int size() {
		int size = 0;
		for(Entry e : contents)
			size += e.size();
		return size;
	}
	
	public int numOfFiles() {
		int count = 0;
		for(Entry e : contents) {
			if (e instanceof Directory) {
				count++;
				Directory d = (Directory) e;
				count += d.numOfFiles();
			} else {
				count++;
			}
		}
		return count;
	}
	
	public boolean deleteEntry(Entry entry) {
		return contents.remove(entry);
	}
	
	public void addEntry(Entry entry) {
		contents.add(entry);
	}
	
	protected ArrayList<Entry> getContents() {
		return contents;
	}
}
