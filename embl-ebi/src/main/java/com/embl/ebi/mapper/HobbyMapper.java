package com.embl.ebi.mapper;

import java.util.List;

import com.embl.ebi.entity.HobbyEntity;
import com.embl.ebi.resource.HobbyResource;

import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

@Mapper(withIoC = IoC.SPRING, withIgnoreFields = { "persons" })
public interface HobbyMapper {
	@Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
	HobbyResource asObject(HobbyEntity entity);

	@Maps(withIgnoreMissing = IgnoreMissing.SOURCE)
	HobbyEntity asEntity(HobbyResource object);

	@Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
	List<HobbyResource> asObjects(List<HobbyEntity> entities);

	@Maps(withIgnoreMissing = IgnoreMissing.SOURCE)
	List<HobbyEntity> asEntities(List<HobbyResource> objects);

	@Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
	HobbyResource updateResource(HobbyEntity entity, HobbyResource resource);

	@Maps(withIgnoreMissing = IgnoreMissing.SOURCE)
	HobbyEntity updateEntity(HobbyResource resource, HobbyEntity entity);
}
