package bgu.spl.net.srv;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConnectionsImpl<T> implements Connections<T> {

    private ConcurrentHashMap<Integer, ConnectionHandler<T>> connectionsById;
    private Library library;


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

    @Override
    public void disconnect(int connectionId) {
        connectionsById.remove(connectionId);

    }
}
