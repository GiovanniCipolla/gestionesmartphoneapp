package it.prova.gestionesmartphoneapp.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "app")
public class App {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;;
	@Column(name = "nome")
	private String nome;
	@Column(name = "datainstallazione")
	private LocalDate dataInstallazione;
	@Column(name = "dataultimoaggiornamento")
	private LocalDate dataUltimoAggiornamento;
	@Column(name = "versione")
	private Integer versione;
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "apps")
	private Set<Smartphone> smartphones;
	
	
	
	public App() {
		super();
	}
	public App(String nome, LocalDate dataInstallazione, LocalDate dataUltimoAggiornamento, Integer versione) {
		super();
		this.nome = nome;
		this.dataInstallazione = dataInstallazione;
		this.dataUltimoAggiornamento = dataUltimoAggiornamento;
		this.versione = versione;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataInstallazione() {
		return dataInstallazione;
	}
	public void setDataInstallazione(LocalDate dataInstallazione) {
		this.dataInstallazione = dataInstallazione;
	}
	public LocalDate getDataUltimoAggiornamento() {
		return dataUltimoAggiornamento;
	}
	public void setDataUltimoAggiornamento(LocalDate dataUltimoAggiornamento) {
		this.dataUltimoAggiornamento = dataUltimoAggiornamento;
	}
	public Integer getVersione() {
		return versione;
	}
	public void setVersione(Integer versione) {
		this.versione = versione;
	}
	public Set<Smartphone> getSmartphones() {
		return smartphones;
	}
	public void setSmartphones(Set<Smartphone> smartphones) {
		this.smartphones = smartphones;
	}
	
	
}
