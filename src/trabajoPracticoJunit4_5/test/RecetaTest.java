package trabajoPracticoJunit4_5.test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import trabajoPracticoJunit4_5.restaurant.Ingrediente;
import trabajoPracticoJunit4_5.restaurant.ItemReceta;
import trabajoPracticoJunit4_5.restaurant.Receta;

public class RecetaTest {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("before class de RecetaTest");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("after class de RecetaTest");
    }


    @Test
    public void esUnaReceta(){
        Receta receta = new Receta("Panchos", 5, 1000, 1);
        Ingrediente salchicha = new Ingrediente("salchicha","kg",12,500);
        receta.addIngrediente(salchicha,24);
        receta.addIngrediente(salchicha,24);
        Receta recetaSinIngredientes = new Receta("Panchos", 5, 1000, 1);

        Assertions.assertAll(
                () -> Assert.assertTrue( receta.esReceta()),
                () -> Assert.assertFalse(recetaSinIngredientes.esReceta())
        );
    }



    @Test
    public void noEsPosibleRealizarLaReceta(){
        Receta receta = new Receta("pollo al disco", 30,5000,3);
        Ingrediente ingrediente1 = new Ingrediente("Pollo","kg",1,200);
        Ingrediente ingrediente2 = new Ingrediente("papas","kg",2,150);
        Ingrediente ingrediente3 = new Ingrediente("Crema","litro",1,50);

        receta.addIngrediente(ingrediente1,1);
        receta.addIngrediente(ingrediente2,1);

        Boolean condicion = receta.realizarReceta();
        Assert.assertFalse(condicion);
    }

    @Test
    public void esPosibleRelizarLaReceta(){
        Receta receta = new Receta("pollo al disco", 30,5000,3);
        Ingrediente ingrediente1 = new Ingrediente("Pollo","kg",1,200);
        Ingrediente ingrediente2 = new Ingrediente("papas","kg",2,150);
        Ingrediente ingrediente3 = new Ingrediente("Crema","litro",1,50);

        receta.addIngrediente(ingrediente1,1);
        receta.addIngrediente(ingrediente2,1);
        receta.addIngrediente(ingrediente3,1);


        Boolean condicion = receta.realizarReceta();
        Assert.assertTrue(condicion);
    }


}
