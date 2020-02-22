/**
 * 
 */
package com.embl.ebi.entity;

import java.io.Serializable;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.Data;

/**
 * @author A1855
 *
 */

@EntityScan(basePackages = { "com.embl.ebi.entity" })
@Data
public abstract class AbstractEntity<T extends Serializable> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1660404569494226362L;

	protected T id;

	public AbstractEntity(T id) {
		this.id = id;
	}

}
