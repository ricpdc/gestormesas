package es.esi.cr.iso.gestionmesas.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable, Comparable<AbstractEntity> {

	private static final long serialVersionUID = -1728118424063172773L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	protected Long id;

	@Column(name = "fecha")
	protected Timestamp fecha;

	@Version
	protected Long version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "AbstractEntity [id=" + id + ", fecha=" + fecha + ", version=" + version + "]";
	}

	@Override
	public int compareTo(AbstractEntity o) {
		if (o == null || o.getId() == null) {
			return 1;
		} else if (getId() == null) {
			return -1;
		}
		return getId().compareTo(o.getId());
	}

}
