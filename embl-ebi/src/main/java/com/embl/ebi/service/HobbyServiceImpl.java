package com.embl.ebi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.embl.ebi.entity.HobbyEntity;
import com.embl.ebi.mapper.HobbyMapper;
import com.embl.ebi.repo.HobbyRepository;
import com.embl.ebi.resource.HobbyResource;
import com.embl.ebi.resource.RestResponse;

/**
 * Service implementation for hobby
 * 
 * @author Nandika Liyanage
 *
 */

@Service
public class HobbyServiceImpl implements HobbyService {

	@Autowired
	HobbyRepository repo; // JPA repository for hobby

	@Autowired
	HobbyMapper mapper; // Entity <-> Resource mapper

	@Override
	@Transactional(rollbackFor = Exception.class)
	public HobbyResource saveOrUpdate(HobbyResource hobby) {

		// Create new entry or update existing entry base on ID exists
		HobbyEntity entity = null;

		if (null == hobby.getId()) {
			entity = repo.save(mapper.asEntity(hobby));
		} else {
			// Search entity by ID
			Optional<HobbyEntity> optionalEntity = repo.findById(hobby.getId());

			// Update searched entity with new resource data & save
			entity = repo.save(mapper.updateEntity(hobby, optionalEntity.get()));
		}

		return mapper.asObject(entity);
	}

	@Override
	public RestResponse delete(HobbyResource hobby) {
		// Delete existing hobby
		if (null == hobby.getId()) {
			repo.deleteById(hobby.getId());
		}

		// Create a rest service response with status message
		RestResponse response = new RestResponse();
		response.setMessage("Hobby successfully deleted.");

		return response;
	}

	@Override
	public RestResponse delete(Integer id) {
		// Delete existing hobby by ID
		repo.deleteById(id);

		// Create a rest service response with status message
		RestResponse response = new RestResponse();
		response.setMessage("Hobby successfully deleted.");

		return response;
	}
}
