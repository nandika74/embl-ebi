/**
 * 
 */
package com.embl.ebi.mapper;

import java.util.List;

import com.embl.ebi.entity.PersonEntity;
import com.embl.ebi.resource.PersonResource;

import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

/**
 * @author A1855
 *
 */

@Mapper(withIoC = IoC.SPRING)
public interface PersonMapper {
	@Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
	PersonResource asObject(PersonEntity entity);

	@Maps(withIgnoreMissing = IgnoreMissing.SOURCE)
	PersonEntity asEntity(PersonResource object);

	@Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
	List<PersonResource> asObjects(List<PersonEntity> entities);

	@Maps(withIgnoreMissing = IgnoreMissing.SOURCE)
	List<PersonEntity> asEntities(List<PersonResource> objects);

	@Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
	PersonResource updateResource(PersonEntity entity, PersonResource resource);

	@Maps(withIgnoreMissing = IgnoreMissing.SOURCE)
	PersonEntity updateEntity(PersonResource resource, PersonEntity entity);
}
