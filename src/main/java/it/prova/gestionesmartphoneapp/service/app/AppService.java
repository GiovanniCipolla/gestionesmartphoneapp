package it.prova.gestionesmartphoneapp.service.app;

import java.util.List;

import it.prova.gestionesmartphoneapp.dao.app.AppDAO;
import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;

public interface AppService {
	
	public void setAppDAO(AppDAO appDAO)throws Exception;
	
	public void inserisci(App input)throws Exception;
	
	public void aggiornaVersioneEAggiornaDataUltimoUpdate(App daAggiornare, Integer versione) throws Exception;
	
	public List<App> listaA()throws Exception;
	
}
