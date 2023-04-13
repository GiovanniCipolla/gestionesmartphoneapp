package it.prova.gestionesmartphoneapp.service.app;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionesmartphoneapp.dao.EntityManagerUtil;
import it.prova.gestionesmartphoneapp.dao.app.AppDAO;
import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;

public class AppServiceImpl implements AppService {

	private AppDAO appDAO;

	public void setAppDAO(AppDAO appDAO) {
		this.appDAO = appDAO;
	}

	@Override
	public void inserisci(App input) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			
			appDAO.setEntityManager(entityManager);
			
			appDAO.insert(input);
			
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
		
	}
	
	@Override
	public void aggiornaVersioneEAggiornaDataUltimoUpdate(App daAggiornare, Integer versione) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			appDAO.setEntityManager(entityManager);
			entityManager.getTransaction().begin();
			daAggiornare.setVersione(versione);
			daAggiornare.setDataUltimoAggiornamento(LocalDate.now());
			appDAO.update(daAggiornare);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}

	@Override
	public List<App> listaA() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			appDAO.setEntityManager(entityManager);
			
			return appDAO.list();
		
		} catch (Exception e) {
		
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}
	
}
