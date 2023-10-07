package tudai.tdv.junit.test;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import trabajoPracticoJunit4_5.test.UsuarioTest;


@RunWith(Suite.class)

@Suite.SuiteClasses({
        //Aca pongo las clases que voy a correr
        DemoPrecedencia.class,
        PadronTest.class,
        PersonaTest.class
})

public class TestSuite {
//CLASE VACIA
}