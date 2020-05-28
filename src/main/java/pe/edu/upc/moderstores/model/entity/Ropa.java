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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ropas")
public class Ropa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	@Column(name="precio",nullable = false)
	private double precio;
	
	@Column(name="stock",nullable = false)
	private int stock;
	
	@ManyToMany(mappedBy = "ropas")
	private List<Comerciante> comerciantes;
	
	@OneToMany(mappedBy = "ropa",fetch = FetchType.LAZY)
	private List<Detalle> detalles;
	
	@OneToMany(mappedBy = "ropa",fetch = FetchType.LAZY)
	private List<Calificacion> calificaciones;
	
	public Ropa() {
		comerciantes=new ArrayList<>();
		detalles=new ArrayList<>();
		calificaciones=new ArrayList<>();
	}
	public void addComerciante(Comerciante comerciante) {
		comerciantes.add(comerciante);
	}
	public void addDetalle(Detalle detalle) {
		detalles.add(detalle);
	}
	
	public void addCalificacion(Calificacion calificacion) {
		calificaciones.add(calificacion);
	}
}
