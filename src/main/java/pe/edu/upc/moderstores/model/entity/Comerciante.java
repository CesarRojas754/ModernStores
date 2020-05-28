package pe.edu.upc.moderstores.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="comerciantes")
public class Comerciante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="suscripcion_id")
	private Suscripcion suscripcion;
	
	@Column(name="contraseña",length = 15,nullable = false)
	private String contraseña;
	
	@Column(name="celular",length = 9,nullable = false)
	private String celular;
	
	@Column(name="correo",length = 35,nullable = false)
	private String correo;
	
	@Column(name="nombres",length = 50,nullable = false)
	private String nombres;
	
	@Column(name="apellidos",length = 50,nullable = false)
	private String apellidos;
	
	@Column(name="dni",length = 8,nullable = false)
	private String dni;
	
	@ManyToMany
	@JoinTable(name="comerciante_ropa",
	joinColumns = {@JoinColumn(name="comerciante_id",referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name="ropa_id",referencedColumnName = "id")})		
	private List<Ropa> ropas;

	@OneToMany(mappedBy = "comerciante",fetch = FetchType.LAZY)
	private List<TarjetaCredito> tarjetas;
	
	public Comerciante() {
		ropas=new ArrayList<>();
		tarjetas=new ArrayList<>();
	}
	
	public void addRopa(Ropa ropa) {
		ropas.add(ropa);
	}
	public void addTarjeta(TarjetaCredito tarjeta) {
		tarjetas.add(tarjeta);
	}
}
