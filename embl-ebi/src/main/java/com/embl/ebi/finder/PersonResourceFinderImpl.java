/**
 * 
 */
package com.embl.ebi.finder;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.embl.ebi.entity.PersonEntity;
import com.embl.ebi.mapper.PersonMapper;
import com.embl.ebi.repo.PersonRepository;
import com.embl.ebi.resource.PersonResource;

/**
 * @author A1855
 *
 */

@Named("personResourceFinder")
public class PersonResourceFinderImpl extends
		AbstractResourceFinder<PersonResource, PersonEntity, PersonRepository, Long> implements PersonResourceFinder {

	private PersonMapper mapper;

	@Inject
	public PersonResourceFinderImpl(PersonRepository repo, PersonMapper mapper) {
		super(repo);
		this.mapper = mapper;
	}

	@Override
	protected PersonResource toResource(PersonEntity entity) {
		return mapper.asObject(entity);
	}

	@Override
	public PersonResource findById(Long id) {
		PersonEntity entity = repo.findById(id).orElse(null);

		return mapper.asObject(entity);
	}

	@Override
	public List<PersonResource> findAll() {
		List<PersonEntity> list = repo.findAll();
		return mapper.asObjects(list);
	}
}
