package bgu.spl.net.srv;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConnectionsImpl<T> implements Connections<T> {

    private ConcurrentHashMap<Integer, ConnectionHandler<T>> connectionsById;
    private ConcurrentHashMap<String, ConnectionHandler<T>> connectionsByChannel;

    public ConnectionsImpl() {
        connectionsById = new ConcurrentHashMap<>();
        connectionsByChannel=new ConcurrentHashMap<>();
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
        Iterator <String> itr = connectionsByChannel.keySet().iterator();
        while(itr.hasNext()) {
            if(itr.toString()==channel&connectionsByChannel.get(itr)!=null){
                connectionsByChannel.get(itr).send(msg);
            }
        }
    }
    @Override
    public void disconnect(int connectionId) {
        connectionsById.remove(connectionId);

    }
}
