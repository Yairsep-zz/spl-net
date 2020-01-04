package bgu.spl.net.Frames.ClientFrames;

import bgu.spl.net.Frames.Frames;
import bgu.spl.net.Frames.ServerFrames.Message;
import bgu.spl.net.srv.ConnectionsImpl;
import bgu.spl.net.srv.Library;

public class Send implements Frames {

    private String topic;
    private String body;
    private ConnectionsImpl connections;

    public Send(String topic, String body) {
        this.topic = topic;
        this.body = body;
    }

    @Override
    public void execute(int connectionId, Library library) {
        Frames message;
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
    public void setConnections(ConnectionsImpl<Frames> connections) {
        this.connections = connections;
    }
}
