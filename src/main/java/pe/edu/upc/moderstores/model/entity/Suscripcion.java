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

@Entity
@Table(name="suscrpciones")
public class Suscripcion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="fecha_suscripcion",nullable = false)
	private Date fechaSuscripcion;
	
	@Column(name="monto",nullable = false)
	private double monto;
	
	@Column(name="nombre",length = 7,nullable = false)
	private String nombre;
	
	@OneToMany(mappedBy = "suscripcion",fetch = FetchType.LAZY)
	private List<Comerciante> comerciantes;
	
	public Suscripcion() {
		comerciantes=new ArrayList<>();
	}
	public void addComerciante(Comerciante comerciante) {
		comerciantes.add(comerciante);
	}
}
