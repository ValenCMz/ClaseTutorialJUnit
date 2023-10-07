package trabajoPracticoJunit4_5.restaurant;

public interface Consumible {
	public void consumirStock(int cantidad);
	public void reponerStock(int cantidad);
	public int getStock();
	public String getNombre();
	public float getPrecioCompra();
}
