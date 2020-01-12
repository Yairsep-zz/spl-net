package bgu.spl.net.srv;

import bgu.spl.net.api.MessageEncoderDecoder;

import bgu.spl.net.api.StompMessagingProtocolImpl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public abstract class BaseServer<T> implements Server<T> {

    private final int port;
    private final Supplier<StompMessagingProtocolImpl<T>> protocolFactory;
    private final Supplier<MessageEncoderDecoder<T>> encdecFactory;
    private ServerSocket sock;
    private AtomicInteger connectionsId;
    private ConnectionsImpl connections;
    private  StompMessagingProtocolImpl stompMessagingProtocol;
    private ConnectionsImpl connectionsImpl=ConnectionsImpl.getInstance();


    public BaseServer(
            int port,
            Supplier<StompMessagingProtocolImpl<T>> protocolFactory,
            Supplier<MessageEncoderDecoder<T>> encdecFactory) {

        this.port = port;
        this.protocolFactory = protocolFactory;
        this.encdecFactory = encdecFactory;
		this.sock = null;
		connectionsId=new AtomicInteger(0);
//		connections=new ConnectionsImpl();
    }

    @Override
    public void serve() {
        connections=new ConnectionsImpl();
        try (ServerSocket serverSock = new ServerSocket(port)) {
			System.out.println("Server started");

            this.sock = serverSock; //just to be able to close

            while (!Thread.currentThread().isInterrupted()) {

                Socket clientSock = serverSock.accept();
                System.out.println("got a new Client");
                //Start protocol
//                stompMessagingProtocol=protocolFactory.get();
//                stompMessagingProtocol.start(connectionsId.intValue(),connectionsImpl);

                BlockingConnectionHandler<T> handler = new BlockingConnectionHandler<>(clientSock,
                        encdecFactory.get(),
                        protocolFactory.get(),
                        connectionsId.intValue(),
                        connections);
                //TODO Check this!!! INCLUDING THE FIELDS THAT IV'E ADDED

                this.connections.addConnection(connectionsId.intValue(),handler);
                int newVal,oldVal;
                do{
                    oldVal = connectionsId.intValue();
                    newVal = connectionsId.intValue() +1;
                }while(!connectionsId.compareAndSet(oldVal,newVal));

                execute(handler);
            }
        } catch (IOException ex) {
        }

        System.out.println("server closed!!!");
    }

    @Override
    public void close() throws IOException {
		if (sock != null)
			sock.close();
    }

    protected abstract void execute(BlockingConnectionHandler<T>  handler);

}
