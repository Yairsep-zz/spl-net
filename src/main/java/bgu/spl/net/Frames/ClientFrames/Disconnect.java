package bgu.spl.net.Frames.ClientFrames;
import bgu.spl.net.Frames.ServerFrames.Receipt;
import bgu.spl.net.Frames.ServerFrames.ServerFrame;
import bgu.spl.net.srv.ConnectionsImpl;
import bgu.spl.net.srv.Library;
import bgu.spl.net.srv.User;

import java.io.IOException;
import java.util.Iterator;

public class Disconnect implements ClientFrame {

    private String receipt;
    private ConnectionsImpl connections;

    public Disconnect(String receipt) {
        this.receipt = receipt;
    }

    public void execute(int connectionId, Library library) throws IOException {
        ServerFrame response;

        //Removing from Library
        if (library.getConnectionIdMap().get(connectionId)!= null) {
            User user=library.getConnectionIdMap().get(connectionId);
            user.setActive(false);
            library.getSubscribersToTopicsMap().remove(user);
            response = new Receipt();
            String output=response.makeFrame(this.receipt);
            connections.send(connectionId, output);
        }
    }
    @Override
    public void setConnections(ConnectionsImpl<ClientFrame> connections) {
        this.connections = connections;
    }


}
