/**
 * 
 */
package com.embl.ebi.service;

import org.springframework.stereotype.Service;

import com.embl.ebi.resource.HobbyResource;
import com.embl.ebi.resource.RestResponse;

/**
 * Service interface to manage hobby 
 * 
 * @author Nandika Liyanage
 *
 */

@Service
public interface HobbyService {

	/**
	 * Save or update a hobby
	 * 
	 * @param hobby
	 * @return
	 */
	HobbyResource saveOrUpdate(HobbyResource hobby);

	/**
	 * Delete an existing hobby
	 * 
	 * @param hobby
	 * @return
	 */
	RestResponse delete(HobbyResource hobby);

	/**
	 * Delete an existing hobby by ID
	 * 
	 * @param id
	 * @return
	 */
	RestResponse delete(Integer id);

}
