package bgu.spl.net.Frames.ClientFrames;

import bgu.spl.net.srv.ConnectionsImpl;
import bgu.spl.net.srv.Library;

public class Send implements ClientFrame {

    private String topic;
    private String body;
    private ConnectionsImpl connections;

    public Send(String topic, String body) {
        this.topic = topic;
        this.body = body;
    }

    @Override
    public void execute(int connectionId, Library library) {
        ClientFrame message;
        String [] bodyArray=body.split(" ",10);

        if(bodyArray[2]=="add"){

//            message=new Message(receipt);
//            connections.send(connectionId,message);
        }
        else if(bodyArray[3]=="borrow"){
//            message=new Message(receipt);
//            connections.send(connectionId,message);
        }
        else if(bodyArray[0]=="Taking"){
//            message=new Message(receipt);
//            connections.send(connectionId,message);
        }
        else if(bodyArray[0]=="Returning"){
//            message=new Message(receipt);
//            connections.send(connectionId,message);
        }
        else if(bodyArray[1]=="status"){
//            message=new Message(receipt);
//            connections.send(connectionId,message);
        }
    }

    @Override
    public void setConnections(ConnectionsImpl<ClientFrame> connections) {
        this.connections = connections;
    }
}
