package bgu.spl.net.Frames.ClientFrames;
import bgu.spl.net.Frames.ServerFrames.Connected;
import bgu.spl.net.Frames.ServerFrames.Error;
import bgu.spl.net.Frames.ServerFrames.ServerFrame;
import bgu.spl.net.srv.ConnectionsImpl;
import bgu.spl.net.srv.Library;
import bgu.spl.net.srv.User;

import java.io.IOException;
import java.util.Vector;

public class Connect implements ClientFrame {

    private String userName;
    private String password;
    private String ip;
    private ConnectionsImpl connections;
    private String version;

    public Connect(String userName, String password, String ip, String version) {
        this.userName = userName;
        this.password = password;
        this.ip = ip;
        this.version = version;
    }

    @Override
    public void  execute(int connectionId, Library library) throws IOException {
        ServerFrame response;
        //Todo check if the server connection was succsesful
        //New User
        if (library.getUser(userName) == null) {
            User newUser = new User(userName, password, connectionId);
            newUser.setActive(true);
            library.getAllUsers().put(userName, newUser);
            response=new Connected();
            String output=response.makeFrame(version);
            connections.send(connectionId, output);
            newUser.setActive(true);
        }

        //Not a new User:
        else {
            User newUser = library.getUser(userName);
            //check if user is already active
            if (newUser.isActive()) {
                 response =new Error();
                 String output = response.makeFrame("User already logged in");
                connections.send(connectionId, output);
            } else {
                //check if password is correct
                if (newUser.getPassword() != this.password) {
                      response=new Error();
                    String output = response.makeFrame("Wrong password");
                    connections.send(connectionId, output);
                }
                else{
                     response=new Connected();
                     newUser.setActive(true);
                     String output=response.makeFrame(version);
                    connections.send(connectionId, output);
                }

            }
        }
    }

    @Override
    public void setConnections(ConnectionsImpl<ClientFrame> connections) {
        this.connections = connections;

    }


}

