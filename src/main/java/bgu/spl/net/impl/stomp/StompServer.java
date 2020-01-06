package bgu.spl.net.impl.stomp;
import bgu.spl.net.api.MessageEncoderDecoderImpl;
import bgu.spl.net.api.StompMessagingProtocolImpl;
import bgu.spl.net.impl.rci.ObjectEncoderDecoder;
import bgu.spl.net.impl.rci.RemoteCommandInvocationProtocol;
import bgu.spl.net.srv.Library;
import bgu.spl.net.srv.Server;

import java.util.function.Supplier;

public class StompServer {

    public static void main(String[] args) {

//        Library library = new Library();
//        int port = Integer.parseInt(args[0]);
//
//        if (args[1] == "tpc") {
//            Server server = Server.threadPerClient(port,
//                    () ->  new StompMessagingProtocolImpl(library),
//                    () ->new MessageEncoderDecoderImpl());
//            server.serve();
//        }
//
//        if (args[1] == "reactor") {
//            Server server = Server.reactor(Runtime.getRuntime().availableProcessors(),
//                    port,
//                    () ->new StompMessagingProtocolImpl(library),
//                    () ->new MessageEncoderDecoderImpl());
//            server.serve();
//        }
//    }

        //TODO CHECK ABOUT THE INTERFACES!!! IN THE SERVER AND THE BASE SERVER
    }
}


