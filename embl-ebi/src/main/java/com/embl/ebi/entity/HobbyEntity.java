/**
 * 
 */
package com.embl.ebi.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * Entity class for Hobby reference table
 * 
 * @author A1855
 *
 */

@Entity
@Table(name = "hobby")
@Data
public class HobbyEntity extends AbstractEntity<Integer> {

	private static final long serialVersionUID = -3466350792712016774L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id = super.id;

	@Column(name = "hobby", nullable = false)
	private String hobby;

	@OneToMany(mappedBy = "hobbies")
	private List<PersonEntity> persons;

	public HobbyEntity(Integer id) {
		super(id);
	}

	public HobbyEntity() {
		super(null);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		HobbyEntity other = (HobbyEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

}
