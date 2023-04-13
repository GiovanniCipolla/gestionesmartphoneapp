package it.prova.gestionesmartphoneapp.service.smartphone;

import java.util.List;

import it.prova.gestionesmartphoneapp.dao.smartphone.SmartphoneDAO;
import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;

public interface SmartphoneService {
	
	public void setSmartphoneDAO(SmartphoneDAO smartphoneDAO)throws Exception;
	
	public void inserisci(Smartphone input)throws Exception;
	
	public void aggiornaVersione(Smartphone smartphoneInstance, Integer versioneNuova) throws Exception;
	
	public void rimuoviSmartphoneConAppInstallate(Smartphone daEliminare) throws Exception;
	
	public void aggiungiApp(Smartphone smartphoneInput, App AppInstance) throws Exception;
	
	public void disinstallaiApp(Smartphone smartphoneInput, App appInstance) throws Exception;
	
	public List<Smartphone> listaS()throws Exception;
}
