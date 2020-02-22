package com.embl.ebi.finder;

import java.util.List;

import org.springframework.stereotype.Service;

import com.embl.ebi.resource.PersonResource;

@Service
public interface PersonResourceFinder extends ResourceFinder<PersonResource, Long> {

	List<PersonResource> findAll();

	PersonResource findById(Long id);
}