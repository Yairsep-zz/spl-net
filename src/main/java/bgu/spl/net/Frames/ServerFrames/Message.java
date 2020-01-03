package bgu.spl.net.Frames.ServerFrames;

import bgu.spl.net.Frames.Frames;
import bgu.spl.net.impl.rci.Command;
import bgu.spl.net.srv.Library;

import java.io.Serializable;

public class Message implements Frames {


    private String destiontionId;
    private int messageId;
    private int subscription;

    public Message(String destiontionId, int messageId, int subscription) {
        this.destiontionId = destiontionId;
        this.messageId = messageId;
        this.subscription = subscription;
    }


    public Serializable execute(Object arg) {
        return null;
    }

    @Override
    public void execute(int connectionId, Library library) {

    }
}
