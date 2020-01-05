package bgu.spl.net.Frames.ServerFrames;

import bgu.spl.net.srv.ConnectionsImpl;

public class Receipt implements ServerFrame {

    private String receiptId;
    private ConnectionsImpl connections;

    public Receipt(String receiptId) {
        this.receiptId = receiptId;
    }

}
