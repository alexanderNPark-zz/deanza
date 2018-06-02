package test;

/**
 * Created by AlexP on 5/15/2018.
 */
public class Tets implements TestInter{



    @Override
    public boolean gimme() {
        System.out.println("Inside gimme Tets");
        return false;
    }

    @Override
    public void go() {
        System.out.println("Inside Tets go");
    }

    public Tets(){
        go();
    }
}
