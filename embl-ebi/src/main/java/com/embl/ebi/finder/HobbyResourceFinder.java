package com.embl.ebi.finder;

import java.util.List;

import org.springframework.stereotype.Service;

import com.embl.ebi.resource.HobbyResource;

@Service
public interface HobbyResourceFinder extends ResourceFinder<HobbyResource, Integer> {

	List<HobbyResource> findAll();

	HobbyResource findById(Integer id);
}