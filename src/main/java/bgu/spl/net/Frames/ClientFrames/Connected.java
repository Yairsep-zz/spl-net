package bgu.spl.net.Frames.ClientFrames;

import bgu.spl.net.Frames.Frames;
import bgu.spl.net.srv.Connections;
import bgu.spl.net.srv.Library;
import bgu.spl.net.srv.User;

import java.util.Vector;

public class Connected implements Frames {

        private String userName;
        private String password;
        private int ip;
        private Connections connections;

    public Connected(String userName, String password, int ip, Connections connections) {
            this.userName = userName;
            this.password = password;
            this.ip = ip;
            this.connections = connections;
        }


        @Override
        public void  execute(int connectionId, Library library) {
            Frames response;
            //Todo check if the server connection was succsesful
            //New User
            if (library.getUser(userName) == null) {
                User newUser = new User(userName, password, new Vector<String>());
                library.getActiveUser().put(userName, newUser);
                library.getAllUsers().put(userName, newUser);
                //      response=new Connected(,"Login successful);
            }

            //Not a new User:
            else {
                User newUser = library.getUser(userName);
                //check if user is already active
                if (library.getActiveUser().contains(newUser.getName())) {
                    // response =new Error(,"User already logged in");
                } else {
                    //check if password is correct
                    if (newUser.getPassword() != this.password) {
                        //  response=new Error(,"Wrong password");
                    }
                    else{
                        // response=new Connected(,"Login successful");
                    }

                }
            }
    }


}

