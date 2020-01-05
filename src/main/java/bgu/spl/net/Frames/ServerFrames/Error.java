package bgu.spl.net.Frames.ServerFrames;

import bgu.spl.net.srv.ConnectionsImpl;

public class Error implements ServerFrame {

    private String errorMessage;
    private ConnectionsImpl connections;

    public Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
