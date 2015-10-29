package ChatServer;

import java.util.*;

public class AddRequest {
    private User fromUser;
    private User toUser;
    private Date date;
    private RequestStatus status;
    
    public AddRequest(User from, User to, Date date) {
        fromUser = from;
        toUser = to;
        this.date = date;
    }
    
    public RequestStatus getStatus() { return status; }
    public User getFromUser() { return fromUser; }
    public User getToUser() { return toUser; }
    public Date getDate() { return date; }
    
}
