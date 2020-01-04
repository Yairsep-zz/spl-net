package bgu.spl.net.Frames.ServerFrames;

import bgu.spl.net.Frames.Frames;
import bgu.spl.net.impl.rci.Command;
import bgu.spl.net.srv.ConnectionsImpl;
import bgu.spl.net.srv.Library;

import java.io.Serializable;

public class Message implements Frames {

    //TODO CHECK WHAT IS THE FIELDS
    private String command;
    private String destinationId;
    private int messageId;
    private int subscription;

    public Message(String destinationId, int messageId, int subscription) {
        this.destinationId = destinationId;
        this.messageId = messageId;
        this.subscription = subscription;
    }


    public Serializable execute(Object arg) {
        return null;
    }

    @Override
    public void execute(int connectionId, Library library) {

        //Add Book Message
        if (command == ""){

        }

        //Borrow Book Message
        if (command == ""){

        }
        //Return Book Message
        if (command == ""){

        }
        //Genre Book Message
        if (command == ""){

        }
    }

    @Override
    public void setConnections(ConnectionsImpl<Frames> connections) {

    }
}
