package es.esi.cr.iso.gestionmesas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import es.esi.cr.iso.gestionmesas.model.enums.ComidaEnum;
import es.esi.cr.iso.gestionmesas.model.enums.MesaEnum;
import es.esi.cr.iso.gestionmesas.model.enums.TurnoEnum;

@Entity
@Table(name = "reserva")
@NamedQueries({
		@NamedQuery(name = "Reserva.findReservasByServicio", query = "SELECT r FROM Reserva r WHERE r.fecha = :fecha and r.comida = :comida and turno = :turno") })
public class Reserva extends AbstractEntity {

	private static final long serialVersionUID = 5792274752446608133L;

	@Column(name = "nombre")
	private String nombre;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "comida")
	private ComidaEnum comida;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "turno")
	private TurnoEnum turno;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "mesa")
	private MesaEnum mesa;

	public Reserva() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public MesaEnum getMesa() {
		return mesa;
	}

	public void setMesa(MesaEnum mesa) {
		this.mesa = mesa;
	}


}
