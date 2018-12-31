package es.esi.cr.iso.gestionmesas.model.enums;

public enum EstadoEnum {

	LIBRE(0, "Libre"), RESERVADA(1, "Reservada"), OCUPADA(2, "Ocupada"), PIDIENDO(3, "Pidiendo"), ESPERANDO_COMIDA(4,
			"Esperando Comida"), SERVIDOS(5, "Servidos"), ESPERANDO_CUENTA(6,
					"Esperando Cuenta"), PAGANDO(7, "Pagando"), EN_PREPARACION(8, "En Preparación");

	private int id;
	private String descripcion;

	private EstadoEnum(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
