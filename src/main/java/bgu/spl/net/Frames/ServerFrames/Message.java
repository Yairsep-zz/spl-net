package bgu.spl.net.Frames.ServerFrames;

import bgu.spl.net.Frames.Frames;

public class Message implements Frames {

    private String destiontionid;
    private int messageid;

    public Message(String destiontionid, int messageid) {

        this.destiontionid = destiontionid;
        this.messageid = messageid;
    }





}
