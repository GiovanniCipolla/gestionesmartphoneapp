
package it.prova.gestionesmartphoneapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "smartphone")
public class Smartphone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "marca")
	private String marca;
	@Column(name = "modello")
	private String modello;
	@Column(name = "prezzo")
	private int prezzo;
	@Column(name = "versioneos")
	private Integer versioneOS;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinTable(name = "smartphone_app", joinColumns = @JoinColumn(name = "smartphone_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "app_id", referencedColumnName = "ID"))
	private Set<App> apps;
	
	
	public Smartphone() {
		super();
	}
	
	
	
	public Smartphone(String marca, String modello, int prezzo, Integer versioneOS) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.prezzo = prezzo;
		this.versioneOS = versioneOS;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}



	public String getModello() {
		return modello;
	}



	public void setModello(String modello) {
		this.modello = modello;
	}



	public int getPrezzo() {
		return prezzo;
	}



	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}



	public Integer getVersioneOS() {
		return versioneOS;
	}



	public void setVersioneOS(Integer versioneOS) {
		this.versioneOS = versioneOS;
	}



	public Set<App> getApps() {
		return apps;
	}



	public void setApps(Set<App> apps) {
		this.apps = apps;
	}



	@Override
	public String toString() {
		return "Smartphone [id=" + id + ", marca=" + marca + ", modello=" + modello + ", prezzo=" + prezzo
				+ ", versioneOS=" + versioneOS + "]";
	}



	
	
	
	
}
