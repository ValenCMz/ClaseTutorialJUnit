package trabajoPracticoJunit4_5.restaurant;
import java.util.ArrayList;
import java.util.List;

public class Receta {
	List<ItemReceta> ingredientes;
	String nombreInterno;
	int tiempoDeCoccion;
	private float precioVenta;
	private int cantIngredientes;
	public Receta( String nombreInterno, int tiempoDeCoccion, float precioVenta, int cantIngredientes) {
		super();
		this.ingredientes = new ArrayList<ItemReceta>();
		this.nombreInterno = nombreInterno;
		this.tiempoDeCoccion = tiempoDeCoccion;
		this.precioVenta = precioVenta;
		this.cantIngredientes = cantIngredientes;
	}
	
	public List<ItemReceta> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(List<ItemReceta> ingredientes) {
		this.ingredientes = ingredientes;
	}
	public String getNombreInterno() {
		return nombreInterno;
	}
	public void setNombreInterno(String nombreInterno) {
		this.nombreInterno = nombreInterno;
	}
	public int getTiempoDeCoccion() {
		return tiempoDeCoccion;
	}
	public void setTiempoDeCoccion(int tiempoDeCoccion) {
		this.tiempoDeCoccion = tiempoDeCoccion;
	}

	/*
	public void addIngrediente(Ingrediente i) {
		ingredientes.add(i);
	}

	 */
	
	public void addIngrediente(Ingrediente ingrediente, int cantidad ) {
		ItemReceta item = new ItemReceta(ingrediente, cantidad);
		ingredientes.add(item);
	}
	
	public float calcularCosto() {
		float total = 0;
		
		for (ItemReceta item : ingredientes) {
			total += (item.getCantidad()) * (item.getIngrediente().getPrecioCompra());
		}
		
		return total;
	}

	public float getPrecioVenta() {
		return this.precioVenta;
	}

	public boolean esReceta(){
		if(this.getIngredientes().size() >= 1)
			return true;
		else return false;
	}


	public boolean realizarReceta(){
		if(this.getIngredientes().size()==cantIngredientes) {
			return true;
		}else{
			return false;
		}
	}
}
