package ChatServer;

import java.util.*;

class UserStatus {
	private String message;
	private UserStatusType type;
	public UserStatus(UserStatusType type, String message) {  }
	public UserStatusType getStatusType() { return type; }
	public String getMessage() { return message; }
}

enum UserStatusType {
	Offline, Away, Idle, Available, Busy
}
enum RequestStatus {
	Unread, Read, Accept, Rejected
}

public class User {
	private int id;
	private UserStatus status = null;
	
	/* maps from the other participant's user id to the chat */
	private HashMap<Integer, PrivateChat> privateChats;
	
	/* maps from the group chat id to the group chat */
	private ArrayList<GroupChat> groupChats;
	
	/* maps from the other person's user id to the add request */
	private HashMap<Integer, AddRequest> receivedAddRequests;
	
	/* naps from the other person's user id to the add request */
	private HashMap<Integer, AddRequest> sentAddRequests;
	
	/* maps from the user id to the add request */
	private HashMap<Integer, User> contacts;
	
	private String accountName;
	private String fullName;
	
	public User(int id, String accountName, String fullName) {}
	public boolean sendMessageToUser(User to, String content) {return true;}
	public boolean sendMessageToGroup(int id, String content) {return true;}
	public void setStatus(UserStatus status) {}
	public boolean addContact(User u) {return true;}
	public void sendAddRequest(AddRequest req) {}
	public void receiveAddRequest(AddRequest req) {}
	public void removeRequest(AddRequest req) {}
	public void requestAddUser(String accountName) {}
	public void addConversation(PrivateChat conversation) {}
	public void addConversation(GroupChat conversation) {}
	public int getId() { return id; }
	public String getAccountName() { return accountName; }
	public String getFullName() { return fullName; }
	// ...
	
}
