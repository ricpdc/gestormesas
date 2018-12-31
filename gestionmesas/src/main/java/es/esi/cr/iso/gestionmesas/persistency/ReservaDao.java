package es.esi.cr.iso.gestionmesas.persistency;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import es.esi.cr.iso.gestionmesas.model.Reserva;


@Repository
@Component
public class ReservaDao extends AbstractDao<Reserva> {

	private static final long serialVersionUID = 1602801517875157200L;

	public ReservaDao() {
		super();
		setClazz(Reserva.class);
	}

	public List<Reserva> findProjectsByUser(final Timestamp fecha) {
		TypedQuery<Reserva> query = entityManager.createNamedQuery("Reserva.findReservasByServicio", Reserva.class);
		query.setParameter("fecha", fecha);
		return query.getResultList();
	}
}