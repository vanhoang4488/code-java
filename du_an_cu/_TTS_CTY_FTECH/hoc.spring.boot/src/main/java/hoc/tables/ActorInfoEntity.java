package hoc.tables;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "actor_info")
public class ActorInfoEntity extends ActorEntity{

	@Column
	private String filmInfo;

	public ActorInfoEntity(short actorId, String firstName, String lastName, Date lastUpdate, String filmInfo) {
		super(actorId, firstName, lastName, lastUpdate);
		this.filmInfo = filmInfo;
	}

	public String getFilmInfo() {
		return filmInfo;
	}

	public void setFilmInfo(String filmInfo) {
		this.filmInfo = filmInfo;
	}
	
}
