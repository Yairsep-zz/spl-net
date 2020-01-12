package bgu.spl.net.api;
import bgu.spl.net.Frames.ClientFrames.*;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;


public class MessageEncoderDecoderImpl<T> implements MessageEncoderDecoder<T> {

    private byte[] bytes =new byte[1<<10];
    private int len=0;


    @Override
    public T decodeNextByte(byte nextByte) {

        if(nextByte == '\u0000'){
            System.out.println("found a Frame");
            return (T)popString();
        }
        pushByte(nextByte);
        return null;
    }

    @Override
    public byte[] encode(T message) {
        //@TODO CHECK ABOUT CASES

        return ((String)message).getBytes();
    }


    public void pushByte(byte nextbyte){
        if(len>=bytes.length){
            bytes= Arrays.copyOf(bytes,len*2);
        }
        bytes[len++]=nextbyte;
    }

    private ClientFrame popString(){
        String result=new String(bytes,0,len,StandardCharsets.UTF_8);
        len=0;
        return makeFrame(result);
    }
    private ClientFrame makeFrame(String result){
        if(result.charAt(0)=='\n')
            result=result.substring(1);

        String [] output = result.split("\n");
        ClientFrame outputFrame = null;



        switch (output[0]){
            case "CONNECT":
                outputFrame = new Connect(output[3].substring(6),output[4].substring(9),output[2].substring(6),output[1].substring(15));
                break;
            case "DISCONNECT":
                outputFrame=new Disconnect(output[1].substring(5));
                break;
            case "UNSUBSCRIBE":
                outputFrame= new Unsubscribe(output[1].substring(12),output[2].substring(3),output[3].substring(8));
                break;
            case "SUBSCRIBE":
                outputFrame=new Subscribe(output[1].substring(12),output[2].substring(3),output[3].substring(8));
                break;
            case "SEND":
                outputFrame = new Send(output[1].substring(12),output[3]);
                break;
        }
            return outputFrame;
    }



}

