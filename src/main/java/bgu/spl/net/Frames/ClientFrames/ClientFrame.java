package bgu.spl.net.Frames.ClientFrames;
import bgu.spl.net.srv.ConnectionsImpl;
import bgu.spl.net.srv.Library;

import java.io.IOException;

public interface ClientFrame {

    void execute (int connectionId , Library library) throws IOException;
    void setConnections(ConnectionsImpl<ClientFrame> connections);

}
