/**
 * 
 */
package com.embl.ebi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.embl.ebi.resource.PersonResource;
import com.embl.ebi.resource.RestResponse;

/**
 * Service interface for person information management
 * 
 * @author Nandika Liyanage
 *
 */

@Service
public interface PersonService {

	/**
	 * Save or update one or more person
	 * 
	 * @param persons
	 * @return
	 */
	RestResponse saveOrUpdate(List<PersonResource> persons);

	/**
	 * Delete list of persons
	 * 
	 * @param persons
	 * @return
	 */
	RestResponse delete(List<PersonResource> persons);

	/**
	 * Delete a person by ID
	 * 
	 * @param id
	 * @return
	 */
	RestResponse delete(Long id);

}
