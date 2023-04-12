package it.prova.gestionesmartphoneapp.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.prova.gestionesmartphoneapp.dao.EntityManagerUtil;
import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;
import it.prova.gestionesmartphoneapp.service.MyServiceFactory;
import it.prova.gestionesmartphoneapp.service.app.AppService;
import it.prova.gestionesmartphoneapp.service.smartphone.SmartphoneService;

public class TestGestionesmartphoneapp {
	public static void main(String[] args) throws Exception {

		SmartphoneService smartphoneServiceInstance = MyServiceFactory.getSmartphoneServiceInstance();
		AppService appServiceInstance = MyServiceFactory.getAppServiceInstance();

//	TEST

//		testInserisci(smartphoneServiceInstance);
//		testInserici(appServiceInstance);
		testAggiornaVersione(smartphoneServiceInstance);

		try {

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}
	}

	private static void testInserisci(SmartphoneService smartphoneServiceInstance) throws Exception {
		System.out.println("----------INIZIA IL TEST-----------------");

		Smartphone testInsert = new Smartphone("Samsung", "s10", 450, 7);

		smartphoneServiceInstance.inserisci(testInsert);

		System.out.println("----------FINISCE IL TEST-----------------");
	}

	private static void testInserici(AppService appServiceInstance) throws Exception {
		System.out.println("----------INIZIA IL TEST-----------------");

		App testInsert = new App("Github", LocalDate.parse("2020-03-04"), LocalDate.parse("2022-06-04"), 3);

		appServiceInstance.inserisci(testInsert);

		System.out.println("----------FINISCE IL TEST-----------------");
	}
	
	private static void testAggiornaVersione(SmartphoneService smartphoneServiceInstance) throws Exception {
		System.out.println("----------INIZIA IL TEST-----------------");
		
		Smartphone testInsert = new Smartphone("Apple", "12 pro max", 800, 4);

		smartphoneServiceInstance.inserisci(testInsert);
		
		smartphoneServiceInstance.aggiornaVersione(testInsert, 5);
		
		
		System.out.println("----------FINISCE IL TEST-----------------");
	}
	
	private static void testAggiornaVersioneEAggiornaDataUltimoUpdate(AppService appServiceInstance) throws Exception {
		System.out.println("----------INIZIA IL TEST-----------------");
		
		
		
		
		System.out.println("----------FINISCE IL TEST-----------------");
	}
}
