package bgu.spl.net.api;
import bgu.spl.net.Frames.ClientFrames.ClientFrame;
import bgu.spl.net.Frames.ClientFrames.Disconnect;
import bgu.spl.net.srv.Connections;
import bgu.spl.net.srv.ConnectionsImpl;
import bgu.spl.net.srv.Library;

import java.io.IOException;


public class StompMessagingProtocolImpl<T> implements StompMessagingProtocol<T> {

    private ConnectionsImpl connections=ConnectionsImpl.getInstance();
    private int connectionId;
    private boolean shouldTerminate = false;

    public StompMessagingProtocolImpl(){ }

    @Override
    public void start(int connectionId, Connections connections) {
        this.connections= (ConnectionsImpl)connections;
        this.connectionId=connectionId;
    }

    public void process(ClientFrame message) throws IOException {
        message.setConnections(connections);
        message.execute(connectionId, connections.getLibrary());

        if(message instanceof Disconnect){
            shouldTerminate=true;
        }
    }


    @Override
    public boolean shouldTerminate() {
        return shouldTerminate;
    }
}
