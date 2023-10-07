package trabajoPracticoJunit4_5.test;

import org.junit.runner.JUnitCore;
import trabajoPracticoJunit4_5.test.TestSuite;

public class TestRunner {

    public static void main(String[]args){
        System.out.println("Test runner -> comienzo del Runner");
        JUnitCore.runClasses(TestSuite.class);
        System.out.println("Test runner -> Fin del Runner");
    }
}
