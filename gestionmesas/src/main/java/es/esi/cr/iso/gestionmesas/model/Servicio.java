package es.esi.cr.iso.gestionmesas.model;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.esi.cr.iso.gestionmesas.model.enums.ComidaEnum;
import es.esi.cr.iso.gestionmesas.model.enums.TurnoEnum;

@Entity
@Table(name = "servicio")
@NamedQueries({ @NamedQuery(name = "Servicio.findByFecha", query = "SELECT s FROM Servicio s WHERE s.fecha = :fecha") })
public class Servicio extends AbstractEntity {

	private static final long serialVersionUID = 1799966858188924426L;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "comida")
	private ComidaEnum comida;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "turno")
	private TurnoEnum turno;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "servicio", orphanRemoval = true, fetch = FetchType.LAZY)
	private Set<Transaccion> transacciones = new TreeSet<>();

	public Servicio() {
		super();
	}

	public ComidaEnum getComida() {
		return comida;
	}

	public void setComida(ComidaEnum comida) {
		this.comida = comida;
	}

	public TurnoEnum getTurno() {
		return turno;
	}

	public void setTurno(TurnoEnum turno) {
		this.turno = turno;
	}

	public Set<Transaccion> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(Set<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}

	@Override
	public String toString() {
		return "Servicio [" + fecha + " - " + comida.toString() + " turno " + (turno.ordinal() + 1) + "]";
	}

}
