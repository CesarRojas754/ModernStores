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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="facturas")
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="tarjeta_id")
	private TarjetaCredito tarjeta;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_factura",nullable = false)
	private Date fechaFactura;
	
	@OneToMany(mappedBy = "factura",fetch = FetchType.LAZY)
	private List<Detalle> detalles;
	
	public Factura() {
		detalles=new ArrayList<>();
	}
	public void addDetalle(Detalle detalle) {
		detalles.add(detalle);
	}
}
