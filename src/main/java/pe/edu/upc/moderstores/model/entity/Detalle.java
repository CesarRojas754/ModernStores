package pe.edu.upc.moderstores.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalles")
public class Detalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="factura_id")
	private Factura factura;
	
	@Column(name="cantidad_comprada",nullable = false)
	private int cantidadComprada;
	
	@Column(name="monto_pagar",nullable = false)
	private double montoPagar;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ropa_id")
	private Ropa ropa;
	
}
