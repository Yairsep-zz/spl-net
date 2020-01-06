package bgu.spl.net.api;
import bgu.spl.net.Frames.ClientFrames.ClientFrame;
import bgu.spl.net.Frames.ClientFrames.Disconnect;
import bgu.spl.net.srv.Connections;
import bgu.spl.net.srv.ConnectionsImpl;
import bgu.spl.net.srv.Library;


public class StompMessagingProtocolImpl<T> implements StompMessagingProtocol<T> {

    private ConnectionsImpl<ClientFrame> connections;
    private int connectionId;
    private boolean shouldTerminate = false;
    private Library library;

    public StompMessagingProtocolImpl(Library library){
        this.library=library;
    }

    @Override
    public void start(int connectionId, Connections<ClientFrame> connections) {
        this.connections= (ConnectionsImpl)connections;
        this.connectionId=connectionId;
    }

    public void process(ClientFrame message) {
        message.setConnections(connections);
        message.execute(connectionId, library);

        if(message instanceof Disconnect){
            shouldTerminate=true;
        }
    }


    @Override
    public boolean shouldTerminate() {
        return shouldTerminate;
    }
}
