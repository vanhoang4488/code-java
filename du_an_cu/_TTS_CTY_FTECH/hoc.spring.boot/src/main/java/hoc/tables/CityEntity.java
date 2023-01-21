package hoc.tables;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class CityEntity {

	@Id
	private short cityId;
	@Column
	private String city;
	@Column
	private int countryId;
	@Column
	private Date lastUpdate;
	
	public CityEntity(short cityId, String city, int countryId, Date lastUpdate) {
		super();
		this.cityId = cityId;
		this.city = city;
		this.countryId = countryId;
		this.lastUpdate = lastUpdate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public short getCityId() {
		return cityId;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}
	
	
}
