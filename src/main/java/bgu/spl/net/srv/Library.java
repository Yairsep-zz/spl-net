package bgu.spl.net.srv;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Library {

    public ConcurrentHashMap<String, ConcurrentLinkedQueue<User>> SubscribersToTopicsMap;
    public ConcurrentHashMap<String, User> allUsers;


    public ConcurrentHashMap<Integer, User> getConnectionIdMap() {
        return connectionIdMap;
    }

    public ConcurrentHashMap<Integer, User> connectionIdMap;

    public Library() {
        this.SubscribersToTopicsMap = new ConcurrentHashMap<>();
        this.allUsers = new ConcurrentHashMap<>();
        this.connectionIdMap = new ConcurrentHashMap<>();
    }


    //Getters

    public User getUser(String userName){
        return allUsers.get(userName);
    }

    public ConcurrentHashMap<String, ConcurrentLinkedQueue<User>> getSubscribersToTopicsMap() {
        return SubscribersToTopicsMap;
    }


    public ConcurrentHashMap<String, User> getAllUsers() {
        return allUsers;
    }

    public void setUserByTopic(User newUser,String topic){
        if(SubscribersToTopicsMap.get(topic)!=null) {
            SubscribersToTopicsMap.get(topic).add(newUser);
        }
        else {
            ConcurrentLinkedQueue<User> temp = new ConcurrentLinkedQueue<>();
            temp.add(newUser);
            SubscribersToTopicsMap.put(topic,temp);
        }
    }

    public ConcurrentLinkedQueue<User> getUsersByTopic (String topic){
        return SubscribersToTopicsMap.get(topic);
    }

    //Setters


}
