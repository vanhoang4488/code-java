package hoc.tables;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import hoc.enums.Features;
import hoc.enums.Rating;

@Entity
@Table(name = "film")
public class FilmEntity {

	@Id
	private short filmId;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private String releaseYear;
	@Column
	private byte languageId;
	@Column
	private byte rentalDuration;
	@Column
	private int length;
	@Column
	private BigDecimal replacementCost;
	@Column
	private Rating rating;
	@Column
	private Features specialFeatures;
	@Column
	private Date lastUpdate;

	public FilmEntity(short filmId, String title, String description, String releaseYear, byte languageId,
			byte rentalDuration, int length, BigDecimal replacementCost, Rating rating, Features specialFeatures,
			Date lastUpdate) {
		super();
		this.filmId = filmId;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.lastUpdate = lastUpdate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public byte getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(byte rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public BigDecimal getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(BigDecimal replacementCost) {
		this.replacementCost = replacementCost;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public Features getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(Features specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public short getFilmId() {
		return filmId;
	}

	public byte getLanguageId() {
		return languageId;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

}
