package it.prova.gestionesmartphoneapp.service;

import it.prova.gestionesmartphoneapp.dao.MyDAOFactory;
import it.prova.gestionesmartphoneapp.service.app.AppService;
import it.prova.gestionesmartphoneapp.service.app.AppServiceImpl;
import it.prova.gestionesmartphoneapp.service.smartphone.SmartphoneService;
import it.prova.gestionesmartphoneapp.service.smartphone.SmartphoneServiceImpl;

public class MyServiceFactory {

	private static SmartphoneService SMARTPHONE_SERVICE_INSTANCE = null;
	private static AppService APP_SERVICE_INSTANCE = null;
	
	public static SmartphoneService getSmartphoneServiceInstance() throws Exception {
		if (SMARTPHONE_SERVICE_INSTANCE == null)
			SMARTPHONE_SERVICE_INSTANCE = new SmartphoneServiceImpl();

		SMARTPHONE_SERVICE_INSTANCE.setSmartphoneDAO(MyDAOFactory.getSmartphoneDAOInstance());
		return SMARTPHONE_SERVICE_INSTANCE;
	}

	public static AppService getAppServiceInstance() throws Exception {
		if (APP_SERVICE_INSTANCE == null)
			APP_SERVICE_INSTANCE = new AppServiceImpl();

		APP_SERVICE_INSTANCE.setAppDAO(MyDAOFactory.getAppDAOInstance());
		return APP_SERVICE_INSTANCE;
	}
	
}
