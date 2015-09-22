package ChatServer;

import java.util.*;

public abstract class Conversation {
	protected ArrayList<User> participants;
	protected int id;
	protected ArrayList<Message> messages;
	
	public ArrayList<Message> getMessages() { return messages; }
	public boolean addMessage(Message m) { return messages.add(m); }
	public int getId() { return id; }
}
