package trabajoPracticoJunit4_5.restaurant;

public class ProductoBasico extends Producto implements Consumible {
	private int stock;

	public ProductoBasico(String nombre, float precioUnitarioCompra, float precioUnitarioVenta) {
		super(nombre, precioUnitarioCompra, precioUnitarioVenta);
		this.stock = 0;

	}



	@Override
	public void consumirStock(int cantidad) {
		if(this.stock >= cantidad){
			stock-=cantidad;
		}
	}

	@Override
	public void reponerStock(int cantidad) {
		stock+=cantidad;
	}

	@Override
	public int getStock() {
		return this.stock;
	}
	public String toString() {
		return nombre;
	}

	//@Override
	public void despachar(int cantidad) {
		Almacen.ExtraerConsumibles(this, cantidad);

	}


	@Override
	public float getPrecioCompra() {
		return this.precioUnitarioCompra;
	}
}
