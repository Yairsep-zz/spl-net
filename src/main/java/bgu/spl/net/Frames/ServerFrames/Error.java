package bgu.spl.net.Frames.ServerFrames;
public class Error implements ServerFrame {

    public Error() {
    }

    public String makeFrame(String msg){

        String output = "ERROR" + "\n" +"\n" + msg+ "\n" + "\n"+ "^@";
        return output;
    }
}
