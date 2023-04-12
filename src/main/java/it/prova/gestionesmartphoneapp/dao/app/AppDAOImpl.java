package it.prova.gestionesmartphoneapp.dao.app;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;

public class AppDAOImpl implements AppDAO{
	private EntityManager entityManager;
	@Override
	public List<App> list() throws Exception {
		return entityManager.createQuery("from App", App.class).getResultList();
	}

	@Override
	public App get(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(App o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(App input) throws Exception {
		if(input==null)
			throw new Exception("errore");
		
		entityManager.persist(input);
		
	}

	@Override
	public void delete(App o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	

	
	

}
