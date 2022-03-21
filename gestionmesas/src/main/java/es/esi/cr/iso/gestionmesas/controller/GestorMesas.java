package es.esi.cr.iso.gestionmesas.controller;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.esi.cr.iso.gestionmesas.model.Servicio;
import es.esi.cr.iso.gestionmesas.model.Transaccion;
import es.esi.cr.iso.gestionmesas.model.enums.ComidaEnum;
import es.esi.cr.iso.gestionmesas.model.enums.EstadoEnum;
import es.esi.cr.iso.gestionmesas.model.enums.MesaEnum;
import es.esi.cr.iso.gestionmesas.model.enums.TurnoEnum;
import es.esi.cr.iso.gestionmesas.persistency.ServicioDao;

@ManagedBean(name = "gestorMesas")
@Controller
@ViewScoped
public class GestorMesas implements Serializable {

	private static final long serialVersionUID = 1220451072138440791L;

	static Logger LOGGER = LoggerFactory.getLogger(GestorMesas.class);

	@Autowired
	private ServicioDao servicioDao;

	private EstadoEnum[] estados;

	private Servicio servicioActivo;

	private Date fechaServicio;
	private boolean comidaServicio;
	private int turnoServicio;

	private int[] ultimoEstadoMesa;

	public GestorMesas() {
		super();
	}

	@PostConstruct
	public void init() {
		reload();
	}

	void reload() {
		setEstados(EstadoEnum.values());
		fechaServicio = new Date();
		comidaServicio = true;
		turnoServicio = 0;

		ultimoEstadoMesa = new int[MesaEnum.values().length];
		for (int i = 0; i < ultimoEstadoMesa.length; i++) {
			ultimoEstadoMesa[i] = 0;
		}

		if(RequestContext.getCurrentInstance()!=null) {
			RequestContext.getCurrentInstance().update("mainForm");
		}
	}

	public void definirServicio() {
		servicioActivo = new Servicio();
		servicioActivo.setFecha(new Timestamp(fechaServicio.getTime()));
		servicioActivo.setComida(comidaServicio ? ComidaEnum.COMIDA : ComidaEnum.CENA);
		servicioActivo.setTurno(TurnoEnum.values()[turnoServicio]);
		servicioActivo = servicioDao.update(servicioActivo);
		// TODO Comprobar si hay reservas para la fecha y servicio para marcar el estdo
		// de cada mesa
	}

	public void definirEstado(int mesaId, int estadoId) {
		MesaEnum mesa = MesaEnum.values()[mesaId - 1];
		EstadoEnum estado = EstadoEnum.values()[estadoId];
		Transaccion transaccion = new Transaccion();
		transaccion.setServicio(servicioActivo);
		transaccion.setFecha(new Timestamp(new Date().getTime()));
		transaccion.setMesa(mesa);
		transaccion.setEstado(estado);
		servicioActivo.getTransacciones().add(transaccion);
		servicioActivo = servicioDao.update(servicioActivo);
		ultimoEstadoMesa[mesaId - 1] = estadoId;
	}

	public String getStyleClass(int mesaId, int estadoId) {
		if (EstadoEnum.values().length - 1 == ultimoEstadoMesa[mesaId - 1] && estadoId==0) {
			return "estado-futuro";
		}
		else if (estadoId > ultimoEstadoMesa[mesaId - 1]) {
			return "estado-futuro";
		} else if (estadoId < ultimoEstadoMesa[mesaId - 1]) {
			return "estado-pasado";
		} else {
			return "estado-actual";
		}
	}

	public boolean isEnabled(int mesaId, int estadoId) {
		if (EstadoEnum.values().length - 1 == ultimoEstadoMesa[mesaId - 1] && estadoId==0) {
			return true;
		} else {
			return servicioActivo != null && estadoId >= ultimoEstadoMesa[mesaId - 1]; 
		}
	}

	public EstadoEnum[] getEstados() {
		return estados;
	}

	public void setEstados(EstadoEnum[] estados) {
		this.estados = estados;
	}

	public Servicio getServicioActivo() {
		return servicioActivo;
	}

	public void setServicioActivo(Servicio servicioActivo) {
		this.servicioActivo = servicioActivo;
	}

	public Date getFechaServicio() {
		return fechaServicio;
	}

	public void setFechaServicio(Date fechaServicio) {
		this.fechaServicio = fechaServicio;
	}

	public boolean isComidaServicio() {
		return comidaServicio;
	}

	public void setComidaServicio(boolean comidaServicio) {
		this.comidaServicio = comidaServicio;
	}

	public int getTurnoServicio() {
		return turnoServicio;
	}

	public void setTurnoServicio(int turnoServicio) {
		this.turnoServicio = turnoServicio;
	}

}