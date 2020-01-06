package bgu.spl.net.srv;

import java.util.Vector;

public class User {

    private String name;
    private String password;
    private boolean isActive;

    private int connectionId;




    public User( String name, String password,int connectionId) {
        this.name = name;
        this.password = password;
        this.connectionId=connectionId;
    }


    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getPassword() {
        return password;
    }


    public int getConnectionId() {
        return connectionId;
    }




    public void setConnectionId(int connectionId) {
        this.connectionId = connectionId;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
