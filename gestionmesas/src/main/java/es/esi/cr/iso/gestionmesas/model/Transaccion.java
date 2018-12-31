package es.esi.cr.iso.gestionmesas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.esi.cr.iso.gestionmesas.model.enums.EstadoEnum;
import es.esi.cr.iso.gestionmesas.model.enums.MesaEnum;

@Entity
@Table(name = "transaccion")
public class Transaccion extends AbstractEntity {

	private static final long serialVersionUID = -1430304547514508248L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "servicio_id")
	private Servicio servicio;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "mesa")
	private MesaEnum mesa;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "estado")
	private EstadoEnum estado;

	@Column(name = "descripcion")
	private String descripcion;

	public Transaccion() {
		super();
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public MesaEnum getMesa() {
		return mesa;
	}

	public void setMesa(MesaEnum mesa) {
		this.mesa = mesa;
	}

	public EstadoEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
