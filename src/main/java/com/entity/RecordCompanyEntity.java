package com.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class RecordCompanyEntity  implements Serializable {
	@Id
	private String tittle;
	@JsonIgnoreProperties(value = "recordCompany", allowSetters = true)
	@OneToMany(mappedBy = "recordCompany")
	private Set<AlbumEntity> albums;
	
	public RecordCompanyEntity() { }

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public Set<AlbumEntity> getAlbums() {
		return albums;
	}

	public void addAlbum(AlbumEntity album) {
		this.albums = new HashSet<>();
		this.albums.add(album);
	}

	@Override
	public String toString() {
		return new Gson().toJson(this).toString();
	}

	private static final long serialVersionUID = -8941398747644265559L;
}
