package it.prova.gestionesmartphoneapp.service.smartphone;

import javax.persistence.EntityManager;

import it.prova.gestionesmartphoneapp.dao.EntityManagerUtil;
import it.prova.gestionesmartphoneapp.dao.smartphone.SmartphoneDAO;
import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;


public class SmartphoneServiceImpl implements SmartphoneService{

	private SmartphoneDAO smartphoneDAO;


	@Override
	public void inserisci(Smartphone input) throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			
			smartphoneDAO.setEntityManager(entityManager);
			
			smartphoneDAO.insert(input);
			
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
	public void setSmartphoneDAO(SmartphoneDAO smartphoneDAO) throws Exception {
		this.smartphoneDAO=smartphoneDAO;
		
	}


	@Override
	public void aggiornaVersione(Smartphone smartphoneInstance, Integer versioneNuova) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			
			smartphoneDAO.setEntityManager(entityManager);
			
			smartphoneInstance.setVersioneOS(versioneNuova);
			
			smartphoneDAO.update(smartphoneInstance);
			
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
	public void rimuoviSmartphoneConAppInstallate(Smartphone daEliminare) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			smartphoneDAO.setEntityManager(entityManager);
			entityManager.getTransaction().begin();
			smartphoneDAO.uninstallAllApps(daEliminare);
			smartphoneDAO.delete(daEliminare);
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
	public void disinstallaiApp(Smartphone smartphoneInput, App appInstance) throws Exception {
		// questo è come una connection
				EntityManager entityManager = EntityManagerUtil.getEntityManager();

				try {
					// questo è come il MyConnection.getConnection()
					entityManager.getTransaction().begin();

					// uso l'injection per il dao
					smartphoneDAO.setEntityManager(entityManager);
					
					smartphoneInput = entityManager.merge(smartphoneInput);
					appInstance = entityManager.merge(appInstance);
					
					smartphoneInput.getApps().remove(appInstance);
					

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
	public void aggiungiApp(Smartphone smartphoneInput, App AppInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			smartphoneDAO.setEntityManager(entityManager);
			
			smartphoneInput = entityManager.merge(smartphoneInput);
			AppInstance = entityManager.merge(AppInstance);
			
			smartphoneInput.getApps().add(AppInstance);
			

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}
	
}
