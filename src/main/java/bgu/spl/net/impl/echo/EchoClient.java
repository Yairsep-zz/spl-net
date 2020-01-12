
package bgu.spl.net.impl.echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class EchoClient {

    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            args = new String[]{"localhost", "hello"};
        }

        if (args.length < 2) {
            System.out.println("you must supply two arguments: host, message");
            System.exit(1);
        }

        //BufferedReader and BufferedWriter automatically using UTF-8 encoding
        try (Socket sock = new Socket("127.0.0.1", 7777);
             BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()))) {

            System.out.println("sending message to server");
            String frame1 = "CONNECT" + "\n" +
                    "accept-version:1.2" + "\n" +
                    "host:stomp.cs.bgu.ac.il" + "\n" +
                    "login:bob14" + "\n" +
                    "passcode:alice" + "\n" + "\n" + "\u0000";
            String frame2 = "SUBSCRIBE" + "\n" +
                    "destination:sci-fi" + "\n" +
                    "id:78" + "\n" +
                    "receipt:77" + "\n" + "\n" + "\u0000";
            String frame3 = "SEND" + "\n" +
                    "destination:sci-fi" + "\n\n" +
                    "Bob has added the book Foundation \n" +"\u0000";
            String frame4 = "SEND" + "\n" +
                    "destination:sci-fi" + "\n\n" +
                    "Bob wish to borrow Dune \n" +"\u0000";
            String frame5 = "UNSUBSCRIBE" + "\n" +
                    "destination:sci-fi" + "\n" +
                    "id:78" + "\n" +
                    "receipt:78" + "\n" + "\n" + "\u0000";



            out.write(frame1);
            out.write(frame2);
            out.write(frame3);
            out.write(frame4);
            out.write(frame5);
            out.newLine();
            out.flush();


            System.out.println("awaiting response");
            String line = "";
            while (line != null) {
                line = in.readLine();
                System.out.println("message from server: " + line);
            }
        }
    }
}

