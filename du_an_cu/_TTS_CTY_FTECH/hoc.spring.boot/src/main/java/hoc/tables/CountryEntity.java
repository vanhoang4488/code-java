package hoc.tables;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class CountryEntity {

	@Id
	private short countryId;
	@Column
	private String country;
	@Column
	private Date lastUpdate;
	
	public CountryEntity(short countryId, String country, Date lastUpdate) {
		super();
		this.countryId = countryId;
		this.country = country;
		this.lastUpdate = lastUpdate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public short getCountryId() {
		return countryId;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}
}
