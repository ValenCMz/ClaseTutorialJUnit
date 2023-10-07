package trabajoPracticoJunit4_5.test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;
import trabajoPracticoJunit4_5.restaurant.Mostrador;
import trabajoPracticoJunit4_5.restaurant.Usuario;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.AssertionsKt.assertDoesNotThrow;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class UsuarioTest {

    private static ArrayList<String> emails = new ArrayList<>();

    @BeforeClass
    public static void cargarUsuarios() throws Exception{
        emails.add("piripopo.com");
        emails.add("piripopo@gmai.com");
        emails.add("jose.com");
        emails.add("jose@gmai.com");
        emails.add("juansito.com");
        emails.add("juansito@gmai.com");
    }

    @AfterClass
    public static void tearDownAfterClass()throws Exception{
        System.out.println("After class");
    }

    @Test
    public void testAgregarUsuariosRepetidos() throws Exception {
        Usuario repetido = new Usuario("Mario Luis",0,200,"MarioLuis@gmail.com",303030);
        Mostrador mostrador = new Mostrador();
        mostrador.addUsuario(repetido);
        Assert.assertFalse("Testeamos que no se puede agregar mismo usuario",mostrador.addUsuario(repetido));

    }

    @Test
    public void cargarEmailInvalido() throws Exception {
        assertThrows(Exception.class, () -> {
                new Usuario("Mario Luis",0,200,"MarioLuisgmail.com",303030);
            });
    }

    @Test
    public void cargarEmailValido()throws Exception{
        Assert.assertNotNull(new Usuario("Mario Luis",0,200,"MarioLuis@gmail.com",303030));
    }

    @TestFactory
    public Stream<DynamicTest> cargarEmailsDinamico(){
        return emails.stream().map(email -> {
            String testName = "Prueba para " + email;

            // Creamos un ejecutable que contiene la lógica del test
            /*Executable executable = () -> {

            };*/

            // Creamos un test dinámico para cada dato de entrada
            return dynamicTest(testName, () -> {
                if(!email.contains("@")){
                    // Verifications que el ejecutable arroje la excepción esperada
                    assertThrows(Exception.class, ()-> {
                        new Usuario("Mario Luis",0,200,email,303030);
                    });
                }else {
                    Assert.assertNotNull(new Usuario("Mario Luis",0,200,email,303030));
                }
            });
        });
    }

}

