package bgu.spl.net.api;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MessageEncoderDecoderImpl<T> implements MessageEncoderDecoder<T> {
    private byte[] bytes =new byte[1<<10];
    private int len=0;


    @Override
    public T decodeNextByte(byte nextByte) {
        String nextStringByte= String.valueOf(nextByte);
        if(nextStringByte=="\n"){
            String ret=new String(bytes,0,bytes.length, StandardCharsets.UTF_8);
            len=0;
            return (T) ret;
        }
        else{
            pushByte(nextByte);
        }
        return null;

    }

    @Override
    public byte[] encode(T message) {
        //@TODO CHECK ABOUT CASES
        return bytes;
    }


    public void pushByte(byte nextbyte){
        if(len>=bytes.length){
            bytes= Arrays.copyOf(bytes,len*2);
        }
         bytes[len++]=nextbyte;
    }



}
