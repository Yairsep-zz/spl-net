package bgu.spl.net.Frames;
import bgu.spl.net.srv.Connections;
import bgu.spl.net.srv.ConnectionsImpl;
import bgu.spl.net.srv.Library;

import java.util.concurrent.ConcurrentLinkedQueue;

public interface Frames {

    void execute (int connectionId , Library library);
    void setConnections(ConnectionsImpl<Frames> connections);

}
