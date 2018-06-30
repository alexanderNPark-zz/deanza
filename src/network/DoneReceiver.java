package network;

public class DoneReceiver extends ITReceiver{

    protected String delimter = "#<done>";

    @Override
    public String readLineUntilDelimString() {
        return "Done";
    }
}
