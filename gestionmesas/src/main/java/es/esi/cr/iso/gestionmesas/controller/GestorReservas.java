package es.esi.cr.iso.gestionmesas.controller;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.esi.cr.iso.gestionmesas.model.Reserva;
import es.esi.cr.iso.gestionmesas.model.enums.ComidaEnum;
import es.esi.cr.iso.gestionmesas.model.enums.MesaEnum;
import es.esi.cr.iso.gestionmesas.model.enums.TurnoEnum;
import es.esi.cr.iso.gestionmesas.persistency.ReservaDao;

@ManagedBean(name = "gestorReservas")
@Controller
@ViewScoped
public class GestorReservas implements Serializable {

	private static final long serialVersionUID = -6274199558088278143L;

	static Logger LOGGER = LoggerFactory.getLogger(GestorReservas.class);

	@Autowired
	private ReservaDao reservaDao;

	private Date fechaReserva;
	private boolean comidaReserva;
	private int turnoReserva;
	private int mesaReserva;
	private String nombreReserva;

	private List<Reserva> reservas;

	public GestorReservas() {
		super();
	}

	@PostConstruct
	public void init() {
		reload();
	}

	private void reload() {
		reservas = reservaDao.findAll();
		fechaReserva = new Date();
		comidaReserva = true;
		turnoReserva = 0;
		mesaReserva = 0;
		nombreReserva = "";

		RequestContext.getCurrentInstance().update("mainForm");
	}

	public void realizarReserva() {
		Reserva reserva = new Reserva();
		reserva.setFecha(new Timestamp(fechaReserva.getTime()));
		reserva.setComida(comidaReserva ? ComidaEnum.COMIDA : ComidaEnum.CENA);
		reserva.setTurno(TurnoEnum.values()[turnoReserva]);
		reserva.setMesa(MesaEnum.values()[mesaReserva]);
		reserva.setNombre(nombreReserva);
		reservaDao.persist(reserva);
		reservas = reservaDao.findAll();		
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public boolean isComidaReserva() {
		return comidaReserva;
	}

	public void setComidaReserva(boolean comidaReserva) {
		this.comidaReserva = comidaReserva;
	}

	public int getTurnoReserva() {
		return turnoReserva;
	}

	public void setTurnoReserva(int turnoReserva) {
		this.turnoReserva = turnoReserva;
	}

	public int getMesaReserva() {
		return mesaReserva;
	}

	public void setMesaReserva(int mesaReserva) {
		this.mesaReserva = mesaReserva;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public String getNombreReserva() {
		return nombreReserva;
	}

	public void setNombreReserva(String nombreReserva) {
		this.nombreReserva = nombreReserva;
	}

}