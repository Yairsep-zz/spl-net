package bgu.spl.net.Frames.ClientFrames;
import bgu.spl.net.Frames.ServerFrames.Receipt;
import bgu.spl.net.srv.ConnectionsImpl;
import bgu.spl.net.srv.Library;
import bgu.spl.net.srv.User;


public class Unsubscribe implements ClientFrame {

    private String topic;
    private String id;
    private String receipt;
    private ConnectionsImpl connections;

    public Unsubscribe (String topic, String id, String receipt) {
        this.topic = topic;
        this.id = id;
        this.receipt = receipt;
    }

    public void execute (int connectionId , Library library){
        ClientFrame serverReceipt;
        if(library.getConnectionIdMap().get(connectionId)!=null) {
            User userTemp = library.getConnectionIdMap().get(connectionId);
            if (library.getUsersByTopic(this.topic) != null){
                library.getUsersByTopic(this.topic).remove(userTemp);
            }
            serverReceipt=new Receipt(receipt);
            connections.send(connectionId,serverReceipt);
            printMessage(topic);
        }

    }
    private void printMessage(String topic) {
        System.out.println("Exited Club " + topic);
    }

    @Override
    public void setConnections(ConnectionsImpl<ClientFrame> connections) {
        this.connections = connections;
    }


}
