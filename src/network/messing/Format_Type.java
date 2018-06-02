package network.messing;

import java.util.HashMap;

/**
 * Created by AlexP on 2/17/2018.
 */
public abstract class Format_Type {

    private HashMap<String,Integer>  opcodes;

    public abstract int parse(String instruction, String rest);
}
