package hoc.tables;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class AddressEntity {

	@Id
	private short addressId;
	@Column
	private String address;
	@Column
	private String address2;
	@Column
	private String district;
	@Column
	private short cityId;
	@Column
	private String postalCode;
	@Column
	private String phone;
	@Column
	private String location;
	@Column
	private Date lastUpdate;
	
	public AddressEntity(short addressId, String address, String address2, String district, short cityId,
			String postalCode, String phone, String location, Date lastUpdate) {
		super();
		this.addressId = addressId;
		this.address = address;
		this.address2 = address2;
		this.district = district;
		this.cityId = cityId;
		this.postalCode = postalCode;
		this.phone = phone;
		this.location = location;
		this.lastUpdate = lastUpdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public short getAddressId() {
		return addressId;
	}

	public short getCityId() {
		return cityId;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}
	
}
