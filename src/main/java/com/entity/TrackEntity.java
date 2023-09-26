package com.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TrackEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long trackId;
	private String name;
	private String lycris;
	@JsonIgnoreProperties(value = "tracks")
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "albumId")
	private AlbumEntity album;
	
	public TrackEntity() { }

	public Long getTrackId() {
		return trackId;
	}

	public void setTrackId(Long trackId) {
		this.trackId = trackId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLycris() {
		return lycris;
	}

	public void setLycris(String lycris) {
		this.lycris = lycris;
	}

	public AlbumEntity getAlbum() {
		return album;
	}

	public void setAlbum(AlbumEntity album) {
		this.album = album;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this).toString();
	}
	
	private static final long serialVersionUID = 1786544567L;

}
