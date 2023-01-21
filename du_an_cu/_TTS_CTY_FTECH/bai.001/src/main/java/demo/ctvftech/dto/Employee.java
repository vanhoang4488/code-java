package demo.ctvftech.dto;

import java.sql.Date;

import demo.ctvftech.entity.EmployeesEntity;

public class Employee extends GenericDTO<EmployeesEntity> {

	private String id;
	private String fullName;
	private Date birthday;
	private String gioiTinh;
	private String country;
	private String city;
	private String district;
	private String village;
	private String addressExtra;
	private String phone;
	private String email;
	private String reportTo;
	private String reportName;
	private String jobTitle;
	private int salary;

	// số công việc hoàn thành.
	private int completedWorks;

	public Employee() {

		super(null);
	}

	public Employee(EmployeesEntity entity) {

		super(entity);
	}

	@Override
	public void init(EmployeesEntity entity) {

		if (entity != null) {

			this.id = entity.getId();
			this.fullName = entity.getFullName();
			this.birthday = entity.getBirthday();
			this.gioiTinh = entity.getGioiTinh();

			this.country = entity.getCountry();
			this.city = entity.getCity();
			this.district = entity.getDistrict();
			this.village = entity.getVillage();
			this.addressExtra = entity.getAddressExtra();

			this.phone = entity.getPhone();
			this.email = entity.getEmail();
			this.reportTo = entity.getManager().getId();
			this.reportName = entity.getManager().getFullName();
			this.jobTitle = entity.getJobTitle();
			this.salary = entity.getSalary();
		}

	}

	@Override
	public EmployeesEntity toEntity() {

		EmployeesEntity entity = new EmployeesEntity();

		entity.setFullName(fullName);
		entity.setBirthday(birthday);
		entity.setGioiTinh(gioiTinh);
		entity.setCountry(country);
		entity.setCity(city);
		entity.setDistrict(district);
		entity.setVillage(village);
		entity.setAddressExtra(addressExtra);
		entity.setPhone(phone);
		entity.setEmail(email);
		entity.setJobTitle(jobTitle);
		entity.setSalary(salary);

		return entity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getAddressExtra() {
		return addressExtra;
	}

	public void setAddressExtra(String addressExtra) {
		this.addressExtra = addressExtra;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReportTo() {
		return reportTo;
	}

	public void setReportTo(String reportTo) {
		this.reportTo = reportTo;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getCompletedWorks() {
		return completedWorks;
	}

	public void setCompletedWorks(int completedWorks) {
		this.completedWorks = completedWorks;
	}

}
