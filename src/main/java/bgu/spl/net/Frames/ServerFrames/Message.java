package bgu.spl.net.Frames.ServerFrames;

import bgu.spl.net.srv.ConnectionsImpl;

public class Message implements ServerFrame {

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

}
