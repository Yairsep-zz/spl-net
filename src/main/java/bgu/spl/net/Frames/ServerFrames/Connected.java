package bgu.spl.net.Frames.ServerFrames;

import bgu.spl.net.srv.ConnectionsImpl;
import bgu.spl.net.srv.Library;

public class Connected implements ServerFrame {

    private String version;
    private String connectedMessage;
    private ConnectionsImpl connections;

    public Connected(String version, String connectedMessage) {
        this.version = version;
        this.connectedMessage = connectedMessage;
    }

    public void execute(int connectionId, Library library) {
        String header = "CONNECTED";
        String version = "version:" + this.version;
        String frameClose = "^@";
        String [] output = {header , version ,"\n","\n", frameClose};
        connections.send(connectionId,output);
    }
    public String[] makeFrame(String version){
        String header = "CONNECTED";
        String ver = "version:" + version;
        String frameClose = "^@";
        String [] output = {header , ver ,"\n","\n", frameClose};
        return output;
    }

}
