package hoc.tables;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "actor")
public class ActorEntity {

	@Id
	private short actorId;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;

	@Column
	private Date lastUpdate;

	public ActorEntity(short actorId, String firstName, String lastName, Date lastUpdate) {
		super();
		this.actorId = actorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastUpdate = lastUpdate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public short getActorId() {
		return actorId;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}
	
	
}
