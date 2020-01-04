package bgu.spl.net.api;

import bgu.spl.net.Frames.ClientFrames.Connect;
import bgu.spl.net.Frames.ClientFrames.Disconnect;
import bgu.spl.net.Frames.ClientFrames.Subscribe;
import bgu.spl.net.Frames.ClientFrames.Unsubscribe;
import bgu.spl.net.Frames.Frames;
import bgu.spl.net.srv.Connections;
import bgu.spl.net.srv.ConnectionsImpl;
import bgu.spl.net.srv.Library;


public class StompMessagingProtocolImpl<T> implements StompMessagingProtocol<T> {

    private ConnectionsImpl<Frames> connections;
    private int connectionId;
    private boolean shouldTerminate = false;
    private Library library;

    public StompMessagingProtocolImpl(Library library){
        this.library=library;
    }

    @Override
    public void start(int connectionId, Connections<Frames> connections) {
        this.connections= (ConnectionsImpl)connections;
        this.connectionId=connectionId;
    }

    public void process(Frames message) {
        message.setConnections(connections);
        message.execute(connectionId, library);

        if(message instanceof Disconnect){
            shouldTerminate=true;
        }
    }

    @Override
    public T process(T msg) {
        return null;
    }

    @Override
    public boolean shouldTerminate() {
        return shouldTerminate;
    }
}
