package bgu.spl.net.Frames.ServerFrames;

import bgu.spl.net.Frames.Frames;
import bgu.spl.net.impl.rci.Command;
import bgu.spl.net.srv.ConnectionsImpl;
import bgu.spl.net.srv.Library;

public class Error implements Frames {

    private String errorMessage;
    private ConnectionsImpl connections;

    public Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public void execute(int connectionId, Library library) {

    }

    @Override
    public void setConnections(ConnectionsImpl<Frames> connections) {
        this.connections = connections;
    }
}
