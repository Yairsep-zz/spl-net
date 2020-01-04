package bgu.spl.net.Frames.ServerFrames;

import bgu.spl.net.Frames.Frames;
import bgu.spl.net.srv.ConnectionsImpl;
import bgu.spl.net.srv.Library;

public class Connected implements Frames {

    //TODO CHECK WHAT IS THE FIELDS
    private String version;
    private String connectedMessage;

    public Connected(String version, String connectedMessage) {
        this.version = version;
        this.connectedMessage = connectedMessage;
    }

    @Override
    public void execute(int connectionId, Library library) {

    }

    @Override
    public void setConnections(ConnectionsImpl<Frames> connections) {

    }
}
