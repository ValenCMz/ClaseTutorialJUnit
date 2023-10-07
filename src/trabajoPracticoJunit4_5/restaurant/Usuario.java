package trabajoPracticoJunit4_5.restaurant;
import java.util.Date;
import java.util.Objects;

public class Usuario {
static int nextID;
int id;
String nombreYApellido;
int tipoUsuario;
float saldoCuenta;
Date ultimaRecarga;

int dni;
String email;
public Usuario(String nombreYApellido, int tipoUsuario, float saldoCuenta,String email, int dni) throws Exception {
	super();
	this.nombreYApellido = nombreYApellido;
	this.tipoUsuario = tipoUsuario;
	this.saldoCuenta = saldoCuenta;
	if(email.contains("@"))
		this.email=email;
	else
		throw new Exception("No se puede crear un usuario con mail invalido");
	this.dni = dni;
}

public void cargarCredito(float cuanto) {
	saldoCuenta+=cuanto;
	
}

float descontarSaldo(float cuanto) throws SinSaldoException {
	if((saldoCuenta-cuanto)<0) throw new SinSaldoException();
	else
		saldoCuenta-= cuanto;
	return saldoCuenta;
	
}
public float getSaldo() {
	return saldoCuenta;
}

	public int getDni() {
		return dni;
	}

	@Override
	public boolean equals(Object o) {
		Usuario usuario = (Usuario) o;
		if(usuario.getDni()==this.getDni())
			return true;
		else
			return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}
}


