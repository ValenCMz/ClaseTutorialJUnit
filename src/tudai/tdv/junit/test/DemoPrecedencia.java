package tudai.tdv.junit.test;
import org.junit.*;

import static org.junit.Assert.fail;


public class DemoPrecedencia {

    //Lo llamo antes de la clase
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("DemoPrecedencia -> BeforeClass ");
    }

    //Lo llamo despues
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("DemoPrecedencia -> AfterClass ");
    }


    @Before
    public void setUp() throws Exception {
        System.out.println("DemoPrecedencia -> Before");

    }
    /**
     * Metodo tearDown para instancias de test
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        System.out.println("DemoPrecedencia -> After");
    }

    @Test
    public void testFuncion1() {
        System.out.println("DemoPrecedencia -> testFuncion1");
    }

    @Test
    public void testFuncion2() {
        System.out.println("DemoPrecedencia -> TestFuncion2");
    }
    @Test
    public void testFuncion3() {
        System.out.println("DemoPrecedencia -> TestFuncion3");
    }
}
