/**
 * 
 */
package com.embl.ebi.resource;

import java.util.List;

import lombok.Data;

/**
 * Resource class for Person
 * 
 * @author A1855
 *
 */

@Data
public class PersonResource extends AbstractResource<Long> {

	private String first_name;

	private String last_name;

	private String age;

	private String favourite_colour;

	private List<HobbyResource> hobbies;

	public PersonResource(Long id) {
		super(id);
	}

	public PersonResource() {
		super(null);
	}

}
