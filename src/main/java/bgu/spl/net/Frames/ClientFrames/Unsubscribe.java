package bgu.spl.net.Frames.ClientFrames;

import bgu.spl.net.Frames.Frames;
import bgu.spl.net.srv.ConnectionsImpl;
import bgu.spl.net.srv.Library;
import bgu.spl.net.srv.User;

public class Unsubscribe implements Frames {

    private String topic;
    private String subscriberId;
    private ConnectionsImpl connections;

    public Unsubscribe(String topic, String subscriberId, ConnectionsImpl connections) {
        this.topic = topic;
        this.subscriberId = subscriberId;
        this.connections = connections;
    }

    public void execute(int connectionId, Library library) {

        if(library.getUser(subscriberId)!=null && library.isActive(subscriberId)) {
            User newUser = library.getUser(subscriberId);
            library.getUsersByTopic(topic).remove(newUser);
        }


    }
}
