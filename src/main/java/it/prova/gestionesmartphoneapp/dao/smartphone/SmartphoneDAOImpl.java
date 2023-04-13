package it.prova.gestionesmartphoneapp.dao.smartphone;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionesmartphoneapp.model.Smartphone;

public class SmartphoneDAOImpl implements SmartphoneDAO {
	
	private EntityManager entityManager;
	
	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Smartphone> list() throws Exception {
		return entityManager.createQuery("from Smartphone", Smartphone.class).getResultList();
	}

	@Override
	public Smartphone get(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Smartphone input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.merge(input);
		
	}

	@Override
	public void insert(Smartphone input) throws Exception {
		if(input==null)
			throw new Exception("errore di input");
		
		entityManager.persist(input);
		
	}

	@Override
	public void delete(Smartphone input) throws Exception {
		if(input==null)
			throw new Exception("errore di input");
		
		entityManager.remove(input);
		
	}
	
	@Override
	public void uninstallAllApps(Smartphone s) throws Exception {
		if (s == null || s.getId() == null || s.getId() < 1)
			throw new Exception("Impossibile eseguire operazione, input invalido");
		entityManager.createNativeQuery("delete from app_smartphone where smartphone_id=?1").setParameter(1,s.getId()).executeUpdate();
	}



	

}
