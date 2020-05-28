package pe.edu.upc.moderstores.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="contraseña",length = 20,nullable = false)
	private String contraseña;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_usuario",nullable = false)
	private Date fechaUsuario;
	
	@Column(name="nombres",length = 50,nullable = false)
	private String nombres;
	
	@Column(name="apellidos",length = 50,nullable = false)
	private String apellidos;
	
	@Column(name="correo",length = 35,nullable = false)
	private String correo;
	
	@Column(name="direccion",length = 50,nullable = false)
	private String direccion;
	
	@OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY)
	private List<Calificacion> calificaciones;
	
	@OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY)
	private List<TarjetaCredito> tarjetas;
	
	public Usuario() {
	calificaciones=new ArrayList<>();	
	tarjetas=new ArrayList<>();
	}
	public void addCalificacion(Calificacion calificacion) {
		calificaciones.add(calificacion);
	}
	public void addTarjeta(TarjetaCredito tarjeta) {
		tarjetas.add(tarjeta);
	}
}
