/**
 * 
 */
package com.embl.ebi.resource;

/**
 * @author A1855
 *
 */
public interface Resource<T> {
	/**
	 * Gets the resource id.
	 *
	 * @return the resource id
	 */
	T getId();

	/**
	 * Sets the resource id.
	 *
	 * @param id the new resource id
	 */
	void setId(T id);
}
