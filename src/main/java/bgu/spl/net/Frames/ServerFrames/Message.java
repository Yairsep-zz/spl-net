package bgu.spl.net.Frames.ServerFrames;

import bgu.spl.net.Frames.Frames;
import bgu.spl.net.impl.rci.Command;
import bgu.spl.net.srv.ConnectionsImpl;
import bgu.spl.net.srv.Library;

import java.io.Serializable;

public class Message implements Frames {

    private String command;
    private String destinationId;
    private int messageId;
    private int subscription;
    private ConnectionsImpl connections;

    public Message(String destinationId, int messageId, int subscription) {
        this.destinationId = destinationId;
        this.messageId = messageId;
        this.subscription = subscription;
    }

    @Override
    public void execute(int connectionId, Library library) {

    }

    @Override
    public void setConnections(ConnectionsImpl<Frames> connections) {
        this.connections = connections;
    }
}
