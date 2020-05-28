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
@Table(name="tarjeta_de_credito")
public class TarjetaCredito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="comerciante_id")
	private Comerciante comerciante;
	
	@Column(name="codigo_control",nullable = false)
	private int codigoControl;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_expiracion")
	private Date fechaExpiracion;
	
	@Column(name="tipo",length = 15,nullable = false)
	private String tipo;
	
	@OneToMany(mappedBy = "tarjeta",fetch = FetchType.LAZY)
	private List<Factura> facturas;
	
	public TarjetaCredito() {
		facturas= new ArrayList<>();
	}
	public void addFactura(Factura factura) {
		
		facturas.add(factura);
	}
}
