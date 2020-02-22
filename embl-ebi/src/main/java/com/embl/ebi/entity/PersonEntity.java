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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

/**
 * Entity class for Person master table
 * 
 * @author A1855
 *
 */

@Entity
@Table(name = "person")
@Data
public class PersonEntity extends AbstractEntity<Long> {

	private static final long serialVersionUID = -2578619293039090923L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id = super.id;

	@Column(name = "first_name", nullable = false, length = 30)
	private String first_name;

	@Column(name = "last_name", nullable = false, length = 30)
	private String last_name;

	@Column(name = "age", nullable = false)
	private String age;

	@Column(name = "favourite_colour", nullable = false)
	private String favourite_colour;

	@OneToMany
	@JoinTable(name = "person_hobbies", joinColumns = { @JoinColumn(name = "person_id") }, inverseJoinColumns = {
			@JoinColumn(name = "hobby_id") })
	@JsonManagedReference
	private List<HobbyEntity> hobbies;

	public PersonEntity(Long id) {
		super(id);
	}

	public PersonEntity() {
		super(null);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonEntity other = (PersonEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
