package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Provincia;

@Repository("repositorioProvincias")
public class RepositorioProvinciasImp implements RepositorioProvincias{
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public RepositorioProvinciasImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void guardar(Provincia provincia) {
		getSession().save(provincia);
	}

	@Override
	public void actualizar(Provincia provincia) {
		getSession().update(provincia);
	}

	@Override
	public void eliminar(Provincia provincia) {
		getSession().delete(provincia);
	}

	@Override
	public List<Provincia> traerProvincia() {
		return sessionFactory.getCurrentSession().createCriteria(Provincia.class).list();
	}
	@Override
	public void save(Provincia provincia) {
		sessionFactory.getCurrentSession().save(provincia);	
	}

	@Override
    public void delete(Provincia provinciaExistente) { 
		sessionFactory.getCurrentSession().delete(provinciaExistente);
    }

	@Override
    public void update(Provincia provinciaExistente) {
		sessionFactory.getCurrentSession().update(provinciaExistente);
    }

	@Override
	public Provincia buscarProvinciaPorId(Long provinciaId) {
		return (Provincia) sessionFactory.getCurrentSession().createCriteria(Provincia.class)
				.add(Restrictions.eq("id", provinciaId)).uniqueResult();
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
