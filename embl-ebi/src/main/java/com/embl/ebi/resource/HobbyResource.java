/**
 * 
 */
package com.embl.ebi.resource;

import java.util.List;

import lombok.Data;

/**
 * Resource class for Hobby reference
 * 
 * @author A1855
 *
 */

@Data
public class HobbyResource extends AbstractResource<Integer> {

	private String hobby;

	private List<PersonResource> persons;

	public HobbyResource(Integer id) {
		super(id);
	}

	public HobbyResource() {
		super(null);
	}

}
