package trabajoPracticoJunit4_5.test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import trabajoPracticoJunit4_5.restaurant.*;

import java.util.ArrayList;
import java.util.List;

public class PedidoTest {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeClass PedidoTest");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("afterClass PedidoTest");
    }

    @Test
    public void pedidoReduceSaldoDeUnUsuario() throws Exception {
        Usuario usuario = new Usuario("Jose Luis", 1, 2000, "JoseLuis@gmail.com", 303030);
        Producto producto = new ProductoBasico("Hamburguesa", 200, 500);
        ItemPedido itemPedido = new ItemPedido(1, producto);
        List<ItemPedido> listas = new ArrayList<ItemPedido>();
        listas.add(itemPedido);
        Pedido pedido = new Pedido(listas, usuario);

        double totalPedido = pedido.totalPedido();
        double supuestoGasto = usuario.getSaldo() - totalPedido;
        pedido.solicitarPedido();

        Assert.assertEquals(supuestoGasto,usuario.getSaldo(),0);
    }

}
