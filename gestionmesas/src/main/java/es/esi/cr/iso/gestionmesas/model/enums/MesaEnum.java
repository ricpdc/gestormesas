package es.esi.cr.iso.gestionmesas.model.enums;

public enum MesaEnum {

	MESA_1(1, 2), MESA_2(2, 4), MESA_3(3, 6), MESA_4(4, 4);

	private int id;
	private int comensales;

	private MesaEnum(int id, int comensales) {
		this.id=id;
		this.comensales=comensales;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getComensales() {
		return comensales;
	}

	public void setComensales(int comensales) {
		this.comensales = comensales;
	}

	

}
