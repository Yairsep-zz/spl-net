package bgu.spl.net.srv;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Library {

    private ConcurrentHashMap<String, ConcurrentLinkedQueue<User>> SubscribersToTopicsMap = new ConcurrentHashMap<>();
//    private ConcurrentHashMap<String, User> activeUser=new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, User> allUsers=new ConcurrentHashMap<>();

    public Library(ConcurrentHashMap<String, ConcurrentLinkedQueue<User>> subscribersToTopicsMap, ConcurrentHashMap<String, User> activeUser, ConcurrentHashMap<String, User> allUsers) {
        SubscribersToTopicsMap = subscribersToTopicsMap;
//        this.activeUser = activeUser;
        this.allUsers = allUsers;
    }

    //Getters

    public User getUser(String userName){
        return allUsers.get(userName);
    }

    public ConcurrentHashMap<String, ConcurrentLinkedQueue<User>> getSubscribersToTopicsMap() {
        return SubscribersToTopicsMap;
    }

//    public ConcurrentHashMap<String, User> getActiveUser() {
//        return activeUser;
//    }

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


    //Methods

//    public boolean isActive (String userName){
//        return activeUser.containsKey(userName);
//    }



}
