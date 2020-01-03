package bgu.spl.net.Frames.ClientFrames;

import bgu.spl.net.Frames.Frames;
import bgu.spl.net.Frames.ServerFrames.Message;
import bgu.spl.net.srv.ConnectionsImpl;
import bgu.spl.net.srv.Library;
import bgu.spl.net.srv.User;


public class Subscribe implements Frames {

    private String topic;
    private String subscriberId;
    private ConnectionsImpl connections;


    public Subscribe(String topic, String subscriberId, ConnectionsImpl connections) {
        this.topic = topic;
        this.subscriberId = subscriberId;
        this.connections = connections;
    }

   public void execute (int connectionId , Library library){
        //TODO check what needed to be done here
        Frames serverReceipt;
        if(library.getUser(subscriberId)!=null && library.isActive(subscriberId)) {
            User newUser = library.getUser(subscriberId);
            library.setUserByTopic(newUser,topic);
        }

       // connections.send(connectionId,serverReceipt);

    }


}
