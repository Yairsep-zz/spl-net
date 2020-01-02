package bgu.spl.net.api;

import bgu.spl.net.Frames.Frames;
import bgu.spl.net.srv.Connections;
import bgu.spl.net.srv.ConnectionsImpl;


public class StompMessagingProtocolImpl implements StompMessagingProtocol {
    private ConnectionsImpl<String> connections;
    private int connectionId;
    private boolean shouldTerminate;

    @Override
    public void start(int connectionId, Connections<String> connections) {
        this.connections=(ConnectionsImpl)connections;
        this.connectionId=connectionId;

    }

 //TODO CHECK ABOUT THE TYPE OF THIS PARAMETER
    public void process(Frames message) {

    }

    @Override
    public boolean shouldTerminate() {
        return false;
    }
}
