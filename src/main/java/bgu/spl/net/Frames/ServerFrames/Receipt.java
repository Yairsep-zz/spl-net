package bgu.spl.net.Frames.ServerFrames;

public class Receipt implements ServerFrame {

    public Receipt() {

    }

    @Override
    public String makeFrame(String msg) {

        String output = "RECEIPT" + "\n" + "receipt-id:" + msg + "\n" + "\n"+  "^@";
        return output;
    }
}
