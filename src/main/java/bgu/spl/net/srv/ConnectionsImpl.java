package bgu.spl.net.srv;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionsImpl<T> implements Connections<T> {

    private ConcurrentHashMap<Integer, ConnectionHandler<T>> connectionsById;
    private Library library;


    //TODO CHECK ABOUT SWITCHING THE ADDAING OF A NEW CONNECTION HANDLER TO HERE INSTDE OF THE BASE SERVER AND REACTOR
    public ConnectionsImpl() {
        connectionsById = new ConcurrentHashMap<>();
    }

    //Sending message to client
    public boolean send(int connectionId, T msg) throws IOException {
        ConnectionHandler<T> temp=connectionsById.get(connectionId);
        if(temp!=null){
            temp.send(msg);
            return true;
        }
        return false;
    }

    //Sending frame to whole topic
    public void send(String topic, T msg) throws IOException {
        ConcurrentLinkedQueue<User> byTopic=library.SubscribersToTopicsMap.get(topic);
        for (User user:byTopic) {
            int id=user.getConnectionId();
            send(id,msg);

        }
    }

    public ConcurrentHashMap<Integer, ConnectionHandler<T>>  getconnection(){
        return this.connectionsById;
    }
    public void addConnection(int connectionId,ConnectionHandler connectionHandler){
        this.connectionsById.put(connectionId,connectionHandler);
    }

    @Override
    public void disconnect(int connectionId) {
        connectionsById.remove(connectionId);

    }
}
