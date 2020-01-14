package bgu.spl.net.Frames.ServerFrames;

import bgu.spl.net.srv.ConnectionsImpl;

public class Message implements ServerFrame {
    public static int counter;


    public Message() {
        counter++;
    }

    public String makeFrame(String msg) {
        return null;
    }

    public String makeMessageFrame(String subscription,String destination,String body){
        if(subscription==null)
            subscription="-1";
        String output="MESSAGE"+ "\n"+"subscription:"+subscription+"\n"+"Message-id:"+counter+"\n"+"destination:"+destination+"\n"+"\n"+body+"\n"+'\u0000';

        return output;
  }
}
