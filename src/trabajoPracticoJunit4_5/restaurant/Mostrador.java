package trabajoPracticoJunit4_5.restaurant;
import java.util.ArrayList;
import java.util.List;

public class Mostrador {
	static List<Pedido> pedidos;
	String nombreOperador;
	static ArrayList<Usuario> usuarios;

	public Mostrador() {
		super();
		if(pedidos==null) 
			pedidos= new ArrayList<Pedido>();
		this.usuarios = new ArrayList<>();
	}

	public boolean addUsuario(Usuario u) throws Exception{
		if(!this.usuarios.contains(u)){
			this.usuarios.add(u);
			return true;
		}else{
			System.out.println("El usuario ya existe");
			return false;
		}
	}

	public ArrayList<Usuario>getUsuarios(){
		return this.usuarios;
	}

	public  int agregarPedido(Pedido p)  {
		p.setEstado("ENCARGADO");
		pedidos.add(p);
		int id=Pedido.getNextID();
		p.setId(id);
		Pedido.setNextID(id+1);
		System.out.println("se ha generado el pedido con el id: "+id);
		return id;
	}
	
	public static void removerUltimoPedido() {
		pedidos.remove(pedidos.size()-1);
	}

	public void cobrarPedido(Pedido p) throws SinSaldoException {
		Usuario u = p.getUsuario();
		float saldo = u.getSaldo();
		
		if((saldo - p.totalPedido()) >= 0)
			System.out.println("Cobro pedido");
		else
			throw new SinSaldoException();
	}
	
	public static int getCantidadPedidos() {
		return pedidos.size();
	}

	public String getNombreOperador() {
		return nombreOperador;
	}

	public void setNombreOperador(String nombreOperador) {
		this.nombreOperador = nombreOperador;
	}

    public void agregar(Pedido p) {
		pedidos.add(p);
    }
}   
