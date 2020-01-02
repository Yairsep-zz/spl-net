package bgu.spl.net.impl.stomp;
import bgu.spl.net.impl.rci.ObjectEncoderDecoder;
import bgu.spl.net.impl.rci.RemoteCommandInvocationProtocol;
import bgu.spl.net.srv.Library;
import bgu.spl.net.srv.Server;

public class StompServer {

    public static void main(String[] args) {

        Library library = new Library();
        int port = Integer.parseInt(args[0]);

        if (args[1] == "tpc") {
            Server.threadPerClient(port,
                    () -> new RemoteCommandInvocationProtocol<>(library), //protocol factory
                    ObjectEncoderDecoder::new //message encoder decoder factory
            ).serve();
        }

        if (args[1] == "reactor") {
            Server.reactor(
                    Runtime.getRuntime().availableProcessors(),
                    port,
                    () -> new RemoteCommandInvocationProtocol<>(library), //protocol factory
                    ObjectEncoderDecoder::new //message encoder decoder factory
            ).serve();


        }
    }
}
