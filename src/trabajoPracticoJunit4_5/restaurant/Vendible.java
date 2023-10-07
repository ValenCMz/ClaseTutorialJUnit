package trabajoPracticoJunit4_5.restaurant;

public interface Vendible {
	public float getPrecioVenta();
	public void preparar() throws SinSuficientesIngredientesException;
}
