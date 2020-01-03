package bgu.spl.net.Frames.ServerFrames;

import bgu.spl.net.Frames.Frames;
import bgu.spl.net.impl.rci.Command;
import bgu.spl.net.srv.Library;

public class Error implements Frames {

    private int receiptId;
    private String errorMessage;

    public Error(int receiptId, String errorMessage) {
        this.receiptId = receiptId;
        this.errorMessage = errorMessage;
    }

    @Override
    public void execute(int connectionId, Library library) {

    }
}
