/**
 * 
 */
package com.embl.ebi.finder;

import java.io.Serializable;

import com.embl.ebi.resource.AbstractResource;

/**
 * @author A1855
 *
 */
public interface ResourceFinder<R extends AbstractResource<? extends Serializable>, ID extends Serializable> {

	/**
	 * Find one.
	 *
	 * @param id the id
	 * @return the r
	 */
	R findOne(ID id);
}
