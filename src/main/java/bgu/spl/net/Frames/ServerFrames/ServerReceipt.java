package bgu.spl.net.Frames.ServerFrames;

import bgu.spl.net.Frames.Frames;
import bgu.spl.net.srv.Library;

public class ServerReceipt implements Frames {

    private int receiptId;

    public ServerReceipt(int receiptId) {
        this.receiptId = receiptId;
    }

    @Override
    public void execute(int connectionId, Library library) {

    }
}
