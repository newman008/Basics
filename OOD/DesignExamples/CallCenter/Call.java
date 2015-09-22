package CallCenter;

public class Call {
	private int rank;
	private Employee handler;
	
	public Call() {
		rank = 1;
	}
	
	public void setHandler(Employee e) {
		handler = e;
	}
	
	public int getRank() { return rank;}
	public void setRank(int r) { rank = r; }
	public int increaseRank() {
		rank++;
		return rank;
	}
	public void reply(String message) {}
}
