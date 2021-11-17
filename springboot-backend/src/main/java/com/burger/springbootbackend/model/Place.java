package com.burger.springbootbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "burger_places")
public class Place {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String location;
	
    @Column(name = "Image")
    private String image;
	
	@Column(name = "opening_time")
	private String openingTime;
	
	@Column(name = "taste_score")
	private long tasteScore;
	
	@Column(name = "texture_score")
	private long textureScore;

	@Column(name = "presentation_score")
	private long presentationScore;

	@Column(name = "user_id")
	private long userId;
	
	public Place() {
		
	}
	
	public Place(String name, String location, String image, String openingTime, long tasteScore, long textureScore,
			long presentationScore, long userId) {
		super();
		this.name = name;
		this.location = location;
		this.image = image;
		this.openingTime = openingTime;
		this.tasteScore = tasteScore;
		this.textureScore = textureScore;
		this.presentationScore = presentationScore;
		this.userId = userId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
	public String getOpeningTime() {
		return openingTime;
	}
	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}
	public long getTasteScore() {
		return tasteScore;
	}
	public void setTasteScore(long tasteScore) {
		this.tasteScore = tasteScore;
	}
	public long getTextureScore() {
		return textureScore;
	}
	public void setTextureScore(long textureScore) {
		this.textureScore = textureScore;
	}
	public long getPresentationScore() {
		return presentationScore;
	}
	public void setPresentationScore(long presentationScore) {
		this.presentationScore = presentationScore;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
}
