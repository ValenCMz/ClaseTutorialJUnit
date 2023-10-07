package trabajoPracticoJunit4_5.restaurant;

import java.util.List;

public class ProductoElaborado extends Producto {
	private String nombreComercial;
	private int tiempoDeCoccion;
	private Receta receta;


	public ProductoElaborado(String nombre,float precioUnitarioVenta, Receta receta) {
		super(nombre, 0, precioUnitarioVenta);
		this.receta = receta;
		this.precioUnitarioCompra = this.receta.calcularCosto();
	}

	public Receta getReceta() {
	return receta;
}

	public void setReceta(Receta receta) {
	this.receta = receta;
}

	public String getNombreComercial() {
	return nombreComercial;
}

	public void setNombreComercial(String nombreComercial) {
	this.nombreComercial = nombreComercial;
}

	public int getTiempoDeCoccion() {
	return tiempoDeCoccion;
}

	public void setTiempoDeCoccion(int tiempoDeCoccion) {
	this.tiempoDeCoccion = tiempoDeCoccion;
}

	@Override
	public void despachar(int cantidad) {
		Receta r = this.getReceta();
		for(int i= 0;i<r.getIngredientes().size();i++) {
			ItemReceta ingredienteActual = r.getIngredientes().get(i);
			Almacen.ExtraerConsumibles(ingredienteActual.getIngrediente(), ingredienteActual.getCantidad()*cantidad);
		}

	}
	public String toString() {
		return nombre;
	}
}
