package bgu.spl.net.Frames.ClientFrames;
import bgu.spl.net.Frames.Frames;
import bgu.spl.net.Frames.ServerFrames.ServerReceipt;
import bgu.spl.net.srv.ConnectionsImpl;
import bgu.spl.net.srv.Library;
import bgu.spl.net.srv.User;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Disconnect implements Frames {

    private String receipt;
    private ConnectionsImpl connections;

    public Disconnect(String receipt) {
        this.receipt = receipt;
    }

    public void execute(int connectionId, Library library) {
        ServerReceipt response;
        //TODO CHECK ABOUT CLOSING THE SERVER SOCKET
        //Removing from Library
        if (library.getConnectionIdMap().get(connectionId)!= null) {
            Iterator<String> topicsIterator = library.getSubscribersToTopicsMap().keySet().iterator();
            while (topicsIterator.hasNext()) {
                User tempUser = library.getConnectionIdMap().get(connectionId);
                if (library.getSubscribersToTopicsMap().get(topicsIterator).contains(tempUser)) {
                    library.getSubscribersToTopicsMap().get(topicsIterator).remove(tempUser);
                }
            }
            response = new ServerReceipt(this.receipt);
            connections.send(connectionId, response);
        }
    }
    @Override
    public void setConnections(ConnectionsImpl<Frames> connections) {
        this.connections = connections;
    }


}
