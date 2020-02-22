/**
 * 
 */
package com.embl.ebi.resource;

import java.io.Serializable;

import lombok.Data;

/**
 * @author A1855
 *
 */

@Data
public abstract class AbstractResource<T extends Serializable> implements Resource<T> {

	/** The resource id. */
	protected T id;

	/**
	 * Instantiates a new abstract resource.
	 *
	 * @param resourceId the resource id
	 */
	public AbstractResource(T id) {
		this.id = id;
	}

}
