package hoc.tables;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryEntity {

	@Id
	private short categoryId;
	@Column
	private String name;
	@Column
	private Date lastUpdate;
	public CategoryEntity(short categoryId, String name, Date lastUpdate) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.lastUpdate = lastUpdate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public short getCategoryId() {
		return categoryId;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	
	
}
