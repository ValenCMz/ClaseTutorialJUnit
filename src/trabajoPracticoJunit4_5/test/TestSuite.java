package trabajoPracticoJunit4_5.test;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tudai.tdv.junit.test.DemoPrecedencia;
import tudai.tdv.junit.test.PersonaTest;


@RunWith(Suite.class)

@Suite.SuiteClasses({
        //Aca pongo las clases que voy a correr
        UsuarioTest.class,
        RecetaTest.class,
        PedidoTest.class
})

public class TestSuite {
//CLASE VACIA
}