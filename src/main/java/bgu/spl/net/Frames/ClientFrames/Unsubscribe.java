package bgu.spl.net.Frames.ClientFrames;

import bgu.spl.net.Frames.Frames;
import bgu.spl.net.srv.ConnectionsImpl;
import bgu.spl.net.srv.Library;
import bgu.spl.net.srv.User;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Unsubscribe implements Frames {

    private String topic;
    private String subscriberId;
    private ConnectionsImpl connections;

    public Unsubscribe(String topic, String subscriberId, ConnectionsImpl connections) {

        this.topic = topic;
        this.subscriberId = subscriberId;
        this.connections = connections;
    }

    public void execute (int connectionId , Library library){
        //TODO check what needed to be done here
        Frames serverReceipt;
        if(library.getUser(subscriberId)!=null) {
            User userTemp = library.getUser(subscriberId);
            if (library.getUsersByTopic(this.topic) != null){
                library.getUsersByTopic(this.topic).remove(userTemp);
            }
            //serverReceipt=new ServerReceipt(,"Exit club "+ topic);
        }

        // connections.send(connectionId,serverReceipt);

    }


}
