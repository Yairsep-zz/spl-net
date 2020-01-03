package bgu.spl.net.srv;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConnectionsImpl<T> implements Connections<T> {

    private ConcurrentHashMap<Integer, ConnectionHandler<T>> connectionsById;
    public ConnectionsImpl() {
        connectionsById = new ConcurrentHashMap<>();
    }

    public boolean send(int connectionId, T msg) {
        ConnectionHandler<T> temp=connectionsById.get(connectionId);
        if(temp!=null){
            temp.send(msg);
            return true;
        }
        return false;
    }

    @Override
    public void send(String channel, T msg) {
        //@TODO CHEKCK IF ANOTHER FIELD IS NEEDED...


    }
    @Override
    public void disconnect(int connectionId) {
        connectionsById.remove(connectionId);

    }
}
