package bgu.spl.net.Frames.ClientFrames;
import bgu.spl.net.Frames.ServerFrames.Connected;
import bgu.spl.net.Frames.ServerFrames.Error;
import bgu.spl.net.Frames.ServerFrames.ServerFrame;
import bgu.spl.net.srv.ConnectionsImpl;
import bgu.spl.net.srv.Library;
import bgu.spl.net.srv.User;
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
    public void  execute(int connectionId, Library library) {
        ServerFrame response;
        //Todo check if the server connection was succsesful
        //New User
        if (library.getUser(userName) == null) {
            User newUser = new User(userName, password, new Vector<String>());
            newUser.setActive(true);
            library.getAllUsers().put(userName, newUser);
            response=new Connected(version, "Login successful");
            connections.send(connectionId, response);
            newUser.setActive(true);
        }

        //Not a new User:
        else {
            User newUser = library.getUser(userName);
            //check if user is already active
            if (newUser.isActive()) {
                 response =new Error("User already logged in");
                connections.send(connectionId, response);
            } else {
                //check if password is correct
                if (newUser.getPassword() != this.password) {
                      response=new Error("Wrong password");
                    connections.send(connectionId, response);
                }
                else{
                     response=new Connected(version,"Login successful");
                     newUser.setActive(true);
                    connections.send(connectionId, response);
                }

            }
        }
    }

    @Override
    public void setConnections(ConnectionsImpl<ClientFrame> connections) {
        this.connections = connections;

    }


}

