package trabajoPracticoJunit4_5.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import trabajoPracticoJunit4_5.restaurant.*;

public class ProductoTest {

    public boolean calcularGanancia(float compra, float venta){
        return ((venta-compra)/compra)*100 > 20;
    }

    @Test
    public void ventaDeProductosDejanGanananciaMayorAl20Porc(){
        //Creamos producto basico
        Producto productoBasico = new ProductoBasico("papas", 200, 400);
        //Creamos producto elaborado
        Receta polloAlDisco = new Receta("Pollo Al Disco",20,200,2);
        Ingrediente sal = new Ingrediente("sal", "gramos",1,20);
        Ingrediente pollo = new Ingrediente("pollo","gramos",1,50);
        polloAlDisco.addIngrediente(sal,1);
        polloAlDisco.addIngrediente(pollo,2);
        Producto productoElaborado = new ProductoElaborado("Pollo al disco", (float) (polloAlDisco.calcularCosto()*1.21), polloAlDisco);

        Producto productoBasicoFallo = new ProductoBasico("papas", 200, 210);
        Producto productoElaboradoFallo = new ProductoElaborado("Pollo al disco", (float) (polloAlDisco.calcularCosto()*1.10), polloAlDisco);

        Assertions.assertAll(
                () -> Assert.assertTrue("La ganancia de las papas es mayor al 20%",calcularGanancia(productoBasico.getPrecioUnitarioCompra(),productoBasico.getPrecioUnitarioVenta())),
                () -> Assert.assertTrue("La ganancia de el pollo al disco es mayor al 20%",calcularGanancia(productoElaborado.getPrecioUnitarioCompra(),productoElaborado.getPrecioUnitarioVenta())),
                () -> Assert.assertFalse("La ganancia de las papas es menor al 20%",calcularGanancia(productoBasicoFallo.getPrecioUnitarioCompra(),productoBasicoFallo.getPrecioUnitarioVenta())),
                () -> Assert.assertFalse("La ganancia de el pollo al disco es menor al 20%",calcularGanancia(productoElaboradoFallo.getPrecioUnitarioCompra(),productoElaboradoFallo.getPrecioUnitarioVenta()))

        );

    }

    /*
    @Test
    public void ventaDeProductosNOOODejanGananciaMayorAl20Porc(){
        Producto p1 = new Producto("papas", 200, 190) {
            @Override
            public void despachar(int cantidad) {
            }
        };
        boolean result = p1.dejaGananciaDel20Porc();
        Assert.assertFalse(result);
    }

     */
}
