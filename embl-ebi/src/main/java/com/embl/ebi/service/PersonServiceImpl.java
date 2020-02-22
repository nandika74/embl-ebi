package com.embl.ebi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.embl.ebi.entity.PersonEntity;
import com.embl.ebi.mapper.PersonMapper;
import com.embl.ebi.repo.PersonRepository;
import com.embl.ebi.resource.PersonResource;
import com.embl.ebi.resource.RestResponse;

/**
 * Service implementation for person information management
 * 
 * @author Nandika Liyanage
 *
 */

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository repo;	//JPA repository for person

	@Autowired
	PersonMapper mapper;	//Entity <-> Resource mapper

	@Override
	@Transactional(rollbackFor = Exception.class)
	public RestResponse saveOrUpdate(List<PersonResource> persons) {
		String message = "";
		
		for (PersonResource personResource : persons) {
			// Create new entry or update esisting entry base on ID exists
			if (null == personResource.getId()) {
				repo.save(mapper.asEntity(personResource));
				message = "Successfully created";
			} else {
				// Search entity by ID
				Optional<PersonEntity> optionalEntity = repo.findById(personResource.getId());
				
				// Update searched entity with new resource data & save
				repo.save(mapper.updateEntity(personResource, optionalEntity.get()));
				message = "Successfully updated";
			}
		}

		// Create a rest service response with status message
		RestResponse response = new RestResponse();
		response.setMessage(message);

		return response;
	}

	@Override
	public RestResponse delete(List<PersonResource> persons) {
		// Delete existing persons
		repo.deleteAll(mapper.asEntities(persons));

		// Create a rest service response with status message
		RestResponse response = new RestResponse();
		response.setMessage("Successfully deleted " + persons.size() + " persons");

		return response;
	}

	@Override
	public RestResponse delete(Long id) {
		// Delete existing person by ID
		repo.deleteById(id);

		// Create a rest service response with status message
		RestResponse response = new RestResponse();
		response.setMessage("Successfully deleted");

		return response;
	}
}
