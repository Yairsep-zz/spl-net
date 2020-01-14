package bgu.spl.net.srv;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConnectionsImpl<T> implements Connections<T> {

    private static ConnectionsImpl connections_instance = null;
    private ConcurrentHashMap<Integer, ConnectionHandler<T>> connectionsById;



    private Library library;

    public static ConnectionsImpl getInstance()
    {
        if ( connections_instance== null)
            connections_instance = new ConnectionsImpl();

        return connections_instance;
    }

    public ConnectionsImpl() {
        connectionsById = new ConcurrentHashMap<>();
        this.library=new Library();
    }

    //Sending message to client
    public boolean send(int connectionId, T msg) throws IOException {
        ConnectionHandler<T> temp= connectionsById.get(connectionId);
        if(temp!=null){
            temp.send(msg);
            return true;
        }
        return false;
    }

    //Sending frame to whole topic
    public void send(String topic, T msg) throws IOException {
        if(library.SubscribersToTopicsMap.get(topic)!=null){
        ConcurrentLinkedQueue<User> byTopic=library.SubscribersToTopicsMap.get(topic);
        for (User user:byTopic) {
            int id = user.getConnectionId();
            send(id, msg);
        }
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
    public ConcurrentHashMap<Integer, ConnectionHandler<T>> getConnections(){
        return this.connectionsById;
    }
    public Library getLibrary() {
        return library;
    }
}
