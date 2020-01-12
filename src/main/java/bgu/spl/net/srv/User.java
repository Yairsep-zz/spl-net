package bgu.spl.net.srv;

import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class User {

    private String name;
    private String password;
    private boolean isActive;
    private int connectionId;
    private ConcurrentHashMap<String ,String> topicToSubscriptioId;






    public User( String name, String password,int connectionId) {
        this.name = name;
        this.password = password;
        this.connectionId=connectionId;
        topicToSubscriptioId=new ConcurrentHashMap<>();
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

    public ConcurrentHashMap<String, String> getTopicToSubscriptioId() {
        return topicToSubscriptioId;
    }

    public void setTopicToSubscriptioId(ConcurrentHashMap<String, String> topicToSubscriptioId) {
        this.topicToSubscriptioId = topicToSubscriptioId;
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
