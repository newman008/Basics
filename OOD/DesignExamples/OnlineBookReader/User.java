package OnlineBookReader;

public class User {
	private int userId;
	private String details;
	private int accountType;
	
	public void renewMembership() {}
	
	public User(int userId, String details, int accountType) {
		this.userId = userId;
		this.details = details;
		this.accountType = accountType;
	}
	
	public int getId() { return userId; }
	public void setId(int id) { userId = id; }
	public String getDetails() { return details; }
	public void setDetails(String s) { details = s; }
	public int getAccountType() { return accountType; }
	public void setAccountType(int t) { accountType = t; }
	
}
