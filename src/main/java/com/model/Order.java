


package com.model;

import java.util.List;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION) 
public class Order {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	
	@Persistent(mappedBy = "id")
    @Element(dependent = "true")
    private Gallery idGallery;
	
	@Persistent(mappedBy = "key")
    @Element(dependent = "true")
    private MediaObject idMO;
	
	@Persistent
	private long order;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Gallery getIdGallery() {
		return idGallery;
	}

	public void setIdGallery(Gallery idGallery) {
		this.idGallery = idGallery;
	}

	public MediaObject getIdMO() {
		return idMO;
	}

	public void setIdMO(MediaObject idMO) {
		this.idMO = idMO;
	}

	public long getOrder() {
		return order;
	}

	public void setOrder(long order) {
		this.order = order;
	}
}

