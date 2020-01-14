package bgu.spl.net.Frames.ClientFrames;
import bgu.spl.net.Frames.ServerFrames.Connected;
import bgu.spl.net.Frames.ServerFrames.Error;
import bgu.spl.net.Frames.ServerFrames.ServerFrame;
import bgu.spl.net.srv.*;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class Connect implements ClientFrame {
    private ConnectionsImpl connectionsImpl=ConnectionsImpl.getInstance();
    private String userName;
    private String password;
    private String ip;
    private String version;


    public Connect(String userName, String password, String ip, String version) {
        this.userName = userName;
        this.password = password;
        this.ip = ip;
        this.version = version;
    }

    @Override
    public void  execute(int connectionId, Library library) throws IOException {
        System.out.println("reached connect execute");
        ServerFrame response;
        //Todo check if the server connection was succsesful
        //New User
        if (library.getUser(userName) == null) {
            User newUser = new User(userName, password, connectionId);
            newUser.setActive(true);
            ConcurrentHashMap<String, User> tmpMap = library.getAllUsers();
            library.getAllUsers().put(userName, newUser);
            ConcurrentHashMap<String, User> tmpMap2 = library.getAllUsers();
            library.getConnectionIdMap().putIfAbsent(connectionId,newUser);
            response=new Connected();
            String output=response.makeFrame(version);
            connectionsImpl.send(connectionId,output);
            newUser.setActive(true);
        }

        //Not a new User:
        else {
            User oldUser = library.getUser(userName);
            //check if user is already active
            if (oldUser.isActive()) {
                 response =new Error();
                 String output = response.makeFrame("User already logged in");
                connectionsImpl.send(connectionId, output);
            } else {
                //check if password is correct
                if (oldUser.getPassword() != this.password) {
                      response=new Error();
                    String output = response.makeFrame("Wrong password");
                    connectionsImpl.send(connectionId, output);
                }
                else{
                     response=new Connected();
                     oldUser.setActive(true);
                     String output=response.makeFrame(version);
                    connectionsImpl.send(connectionId, output);
                }

            }
        }
    }

    @Override
    public void setConnections(ConnectionsImpl<ClientFrame> connections) {
        this.connectionsImpl = connections;

    }


}

