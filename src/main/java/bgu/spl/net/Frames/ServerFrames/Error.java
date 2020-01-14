package bgu.spl.net.Frames.ServerFrames;
public class Error implements ServerFrame {

    public Error() {
    }

    public String makeFrame(String msg){

        String output = "ERROR" + "\n"+"message:"+ msg+ "\n" +"\n"+msg+"\n"+ '\u0000';
        return output;
    }
}
