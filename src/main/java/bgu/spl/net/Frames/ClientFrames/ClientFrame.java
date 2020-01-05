package bgu.spl.net.Frames.ClientFrames;
import bgu.spl.net.srv.ConnectionsImpl;
import bgu.spl.net.srv.Library;

public interface ClientFrame {

    void execute (int connectionId , Library library);
    void setConnections(ConnectionsImpl<ClientFrame> connections);

}
