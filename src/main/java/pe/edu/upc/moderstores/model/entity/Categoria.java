package pe.edu.upc.moderstores.model.entity;

import java.util.ArrayList;
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
@Table(name = "categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombre", length = 40, nullable = false)
	private String nombre;

	@Column(name = "descripcion", length = 50, nullable = false)
	private String descripcion;

	@Column(name = "tendencia", length = 20, nullable = false)
	private String tendencia;

	@OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
	private List<Ropa> ropas;

	public Categoria() {
		ropas = new ArrayList<>();
	}

	public void addCategoria(Ropa ropa) {
		ropas.add(ropa);
	}
}
