package trabajoPracticoJunit4_5.test;

import org.testng.annotations.Test;
import trabajoPracticoJunit4_5.restaurant.Almacen;
import trabajoPracticoJunit4_5.restaurant.Consumible;
import trabajoPracticoJunit4_5.restaurant.ProductoBasico;

@Test
public class AlmacenTest {

    Consumible consumible = new ProductoBasico("pollo",200,300);
    int stockInicial = consumible.getStock();


    int cantidadIngresada = 50;



}
