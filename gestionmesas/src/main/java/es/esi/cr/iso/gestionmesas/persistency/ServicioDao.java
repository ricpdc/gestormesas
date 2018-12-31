package es.esi.cr.iso.gestionmesas.persistency;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import es.esi.cr.iso.gestionmesas.model.Servicio;


@Repository
@Component
public class ServicioDao extends AbstractDao<Servicio> {

	private static final long serialVersionUID = -4410739821690354864L;

	public ServicioDao() {
		super();
		setClazz(Servicio.class);
	}

	public List<Servicio> findProjectsByUser(final Timestamp fecha) {
		TypedQuery<Servicio> query = entityManager.createNamedQuery("Servicio.findByFecha", Servicio.class);
		query.setParameter("fecha", fecha);
		return query.getResultList();
	}
}