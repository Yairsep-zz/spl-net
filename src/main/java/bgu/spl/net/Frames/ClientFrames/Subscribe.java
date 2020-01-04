package bgu.spl.net.Frames.ClientFrames;
import bgu.spl.net.Frames.Frames;
import bgu.spl.net.Frames.ServerFrames.ServerReceipt;
import bgu.spl.net.srv.ConnectionsImpl;
import bgu.spl.net.srv.Library;
import bgu.spl.net.srv.User;

import java.util.concurrent.ConcurrentLinkedQueue;


public class Subscribe implements Frames {


    private String topic;
    private String id;
    private String receipt;
    private ConnectionsImpl connections;

    public Subscribe(String topic, String id, String receipt) {
        this.topic = topic;
        this.id = id;
        this.receipt = receipt;
    }


    public void execute (int connectionId , Library library){
        //TODO check what needed to be done here
        Frames serverReceipt;
        if(library.getConnectionIdMap().get(connectionId)!=null) {
            User userTemp = library.getConnectionIdMap().get(connectionId);
            if (library.getUsersByTopic(this.topic) != null){
                library.getUsersByTopic(this.topic).add(userTemp);
            }
            else {
                ConcurrentLinkedQueue<User> newTopic = new ConcurrentLinkedQueue<>();
                newTopic.add(userTemp);
                library.getSubscribersToTopicsMap().put(topic,newTopic);
            }
           serverReceipt=new ServerReceipt(receipt);
            connections.send(connectionId,serverReceipt);
            printMessage(topic);
        }

    }
    private void printMessage(String topic) {
        System.out.println("Joined Club " + topic);
    }

    @Override
    public void setConnections(ConnectionsImpl<Frames> connections) {
        this.connections = connections;
    }


}
