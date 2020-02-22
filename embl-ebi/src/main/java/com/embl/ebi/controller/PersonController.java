/**
 * 
 */
package com.embl.ebi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.embl.ebi.finder.PersonResourceFinder;
import com.embl.ebi.resource.PersonResource;
import com.embl.ebi.resource.RestResponse;
import com.embl.ebi.service.PersonService;

/**
 * @author A1855
 *
 */

@RequestMapping("/person")
@RestController
@Transactional
public class PersonController {

	/** The Constant logger. */
	public static final Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	PersonService service;

	@Autowired
	PersonResourceFinder finder;

	@PostMapping("/create")
	public ResponseEntity<RestResponse> creationOrUpdatePersons(@RequestBody List<PersonResource> request) {
		System.out.println(request.toString());

		RestResponse res = service.saveOrUpdate(request);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<PersonResource> getPersonById(@PathVariable("id") long id) {
		System.out.println(id);

		PersonResource res = finder.findById(id);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/find/all")
	public ResponseEntity<List<PersonResource>> listAllPersons() {
		List<PersonResource> res = finder.findAll();

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<RestResponse> delete(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting User with id {}", id);
		RestResponse response = service.delete(id);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<RestResponse> delete(@RequestBody List<PersonResource> request) {
		RestResponse response = service.delete(request);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
