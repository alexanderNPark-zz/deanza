package test;

/**
 * Created by AlexP on 5/15/2018.
 */
public class SubTest extends Tets implements SubTestInter{

    int x = 0;

    @Override
    public void go() {
        System.out.println("in go"+x);
    }

    public SubTest(){
        x=10;
    }

    public static void main(String[] args ){
        TestInter ti = new SubTest();

        ti.go();
    }
}


