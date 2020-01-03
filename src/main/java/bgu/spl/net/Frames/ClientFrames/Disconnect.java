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

    private String userName;
    private String password;
    private int ip;
    private ConnectionsImpl connections;

    public Disconnect(String userName, String password, int ip, ConnectionsImpl connections) {
        this.userName = userName;
        this.password = password;
        this.ip = ip;
        this.connections = connections;
    }

    public void execute(int connectionId, Library library) {
        ServerReceipt response;
        //TODO CHECK ABOUT CLOSING THE SERVER SOCKET

        //Removing from Library
        if (library.getUser(userName) != null) {
            Iterator<String> topicsIterator = library.getSubscribersToTopicsMap().keySet().iterator();
            while (topicsIterator.hasNext()) {
                if (library.getSubscribersToTopicsMap().get(topicsIterator).contains(userName)) {
                    library.getSubscribersToTopicsMap().get(topicsIterator).remove(userName);
                }
            }
//            response = new ServerReceipt()

        }
    }
}
