package Item1;

import java.util.*;

public class DBConnection
{
    private static final int MAX_CONNS = 100;
    private static int totalConnections = 0;

    private static Set<DBConnection> availableConnections = new HashSet<DBConnection>();

    private DBConnection()
    {
        totalConnections++;
    }

    public static DBConnection getDbConnection()
    {
        if(totalConnections < MAX_CONNS)
        {
            return new DBConnection();
        }
        else if(availableConnections.size() > 0) 
        {
            DBConnection dbc = availableConnections.iterator().next();
            availableConnections.remove(dbc);
            return dbc;
        }
        else 
        {
            return null;
        }
    }

    public static void returnDbConnection(DBConnection dbc) 
    {
        availableConnections.add(dbc);
    }
}
