/**
 * 
 */
package com.embl.ebi.finder;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.embl.ebi.entity.HobbyEntity;
import com.embl.ebi.mapper.HobbyMapper;
import com.embl.ebi.repo.HobbyRepository;
import com.embl.ebi.resource.HobbyResource;

/**
 * @author A1855
 *
 */

@Named("hobbyResourceFinder")
public class HobbyResourceFinderImpl extends
		AbstractResourceFinder<HobbyResource, HobbyEntity, HobbyRepository, Integer> implements HobbyResourceFinder {

	private HobbyMapper mapper;

	@Inject
	public HobbyResourceFinderImpl(HobbyRepository repo, HobbyMapper mapper) {
		super(repo);
		this.mapper = mapper;
	}

	@Override
	protected HobbyResource toResource(HobbyEntity entity) {
		return mapper.asObject(entity);
	}

	@Override
	public HobbyResource findById(Integer id) {
		HobbyEntity entity = repo.findById(id).orElse(null);

		return mapper.asObject(entity);
	}

	@Override
	public List<HobbyResource> findAll() {
		List<HobbyEntity> list = repo.findAll();

		return mapper.asObjects(list);
	}
}
