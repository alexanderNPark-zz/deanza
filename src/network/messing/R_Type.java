package network.messing;

import javafx.util.Pair;

import java.util.HashMap;

/**
 * Created by AlexP on 2/17/2018.
 */
public class R_Type extends Format_Type{



    private int opCode = 0b0110011;
    private static HashMap<String,Pair_funcs> translation_paring = new HashMap<>();
    static{
        translation_paring.put("add",new Pair_funcs(0b000,0b0000000));
    }
    static class Pair_funcs{
        private int func7=0;
        private int func3 = 0;
        private int start_func3 = 12;
        private int start_func7 = 25;

        public Pair_funcs(int _7, int _3){
            func3 = _3;
            func7 = _7;
        }

        public int getFunc7(){
            return func7;
        }
        public int getFunc3(){
            return func3;
        }
    }

    @Override
    public int parse(String instruction, String rest) {
        Pair_funcs pairing = translation_paring.get(instruction);
        String[] tokens = rest.replace("x","").split(",");

        return 1;

    }
}
