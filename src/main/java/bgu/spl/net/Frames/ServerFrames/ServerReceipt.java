package bgu.spl.net.Frames.ServerFrames;

import bgu.spl.net.Frames.Frames;
import bgu.spl.net.srv.ConnectionsImpl;
import bgu.spl.net.srv.Library;

public class ServerReceipt implements Frames {

    private String receiptId;

    public ServerReceipt(String receiptId) {
        this.receiptId = receiptId;
    }

    @Override
    public void execute(int connectionId, Library library) {

    }

    @Override
    public void setConnections(ConnectionsImpl<Frames> connections) {

    }
}
