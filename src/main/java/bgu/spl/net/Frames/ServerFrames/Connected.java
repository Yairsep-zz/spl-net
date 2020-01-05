package bgu.spl.net.Frames.ServerFrames;
public class Connected implements ServerFrame {

    public Connected() {}

    public String makeFrame(String msg){
        String header = "CONNECTED";
        String ver = "version:" + msg;
        String frameClose = "^@";
        String output = header+"\n"+ver+"\n"+"\n"+ frameClose;
        return output;
    }

}
