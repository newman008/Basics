package ChatServer;

import java.util.*;

public class UserManager {
    private static UserManager instance = null;
    
    protected UserManager() {}
    
    public static UserManager getInstance() {
        if(instance == null) {
            synchronized(UserManager.class) {
                instance = new UserManager();
            }
        }
        return instance;
    }
    
    private HashMap<Integer, User> usersById;
    private HashMap<String, User> usersByAccountName;
    private HashMap<Integer, User> onlineUsers;
    
    public void addUser(User fromUser, String toAccountName) {}
    public void approveReq(AddRequest req) {}
    public void rejectReq(AddRequest req) {}
    public void userSignOn(String accountName) {}
    public void userSignOff(String accountName) {}
}
