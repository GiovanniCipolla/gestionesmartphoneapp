package it.prova.gestionesmartphoneapp.dao;


import it.prova.gestionesmartphoneapp.dao.app.AppDAO;
import it.prova.gestionesmartphoneapp.dao.app.AppDAOImpl;
import it.prova.gestionesmartphoneapp.dao.smartphone.SmartphoneDAO;
import it.prova.gestionesmartphoneapp.dao.smartphone.SmartphoneDAOImpl;


public class MyDAOFactory {

	private static AppDAO APP_DAO_INSTANCE = null;
	private static SmartphoneDAO SMARTPHONE_DAO_INSTANCE =null;
	
	public static AppDAO getAppDAOInstance() {
		if (APP_DAO_INSTANCE == null)
			APP_DAO_INSTANCE = new AppDAOImpl();
		return APP_DAO_INSTANCE;
	}

	public static SmartphoneDAO getSmartphoneDAOInstance() {
		if (SMARTPHONE_DAO_INSTANCE == null)
			SMARTPHONE_DAO_INSTANCE = new SmartphoneDAOImpl();
		return SMARTPHONE_DAO_INSTANCE;
	}
}
