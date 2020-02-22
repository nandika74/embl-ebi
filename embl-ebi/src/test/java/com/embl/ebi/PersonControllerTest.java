/**
 * 
 */

package com.embl.ebi;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.embl.ebi.controller.PersonController;
import com.embl.ebi.finder.PersonResourceFinder;
import com.embl.ebi.resource.HobbyResource;
import com.embl.ebi.resource.PersonResource;
import com.embl.ebi.resource.RestResponse;
import com.embl.ebi.service.HobbyService;

/**
 * @author A1855
 *
 */

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = { "com.embl.ebi.controller", "com.embl.ebi.finder", "com.embl.ebi.service",
		"com.embl.ebi.mapper", "com.embl.ebi.model" })
public class PersonControllerTest extends AbstractControllerTest{

	Logger LOG = LoggerFactory.getLogger(PersonControllerTest.class);

	@Autowired
	HobbyService hobbyService;

	@Autowired
	PersonResourceFinder finder;

	@Autowired
	PersonController controller;

	private List<PersonResource> createPerson(Long id) {
		PersonResource person = new PersonResource();

		if (-1 != id) {
			person.setId(id);
		}

		person.setFirst_name("Nandika");
		person.setLast_name("Liyanage");
		person.setAge("10");
		person.setFavourite_colour("Green");

		HobbyResource hobby = createHobby();

		List<HobbyResource> hobbies = new ArrayList<HobbyResource>();
		hobbies.add(hobby);
		person.setHobbies(hobbies);

		List<PersonResource> persons = new ArrayList<PersonResource>();
		persons.add(person);

		return persons;
	}

	private HobbyResource createHobby() {
		HobbyResource hobby = new HobbyResource();
		hobby.setHobby("Music");

		System.out.println("HOBBY: " + hobby.toString());
		System.out.println("hobbyService: " + hobbyService);

		return hobbyService.saveOrUpdate(hobby);
	}

	@Test
	@Order(1)
	public void testCreatePersonsMethod() {
		ResponseEntity<RestResponse> response = controller.creationOrUpdatePersons(createPerson(-1l));
		assertNotNull(response.getBody());
		assertEquals(response.getBody().getMessage(), "Successfully created");

		LOG.info(response.getBody().getMessage());
	}

	@Test
	@Order(2)
	public void testUpdatePersonsMethod() {
		ResponseEntity<RestResponse> response = controller.creationOrUpdatePersons(createPerson(1l));
		assertNotNull(response.getBody());
		assertEquals(response.getBody().getMessage(), "Successfully updated");

		LOG.info(response.getBody().getMessage());
	}

	@Test
	@Order(3)
	public void testListAllPersonsMethod() {
		List<PersonResource> list = controller.listAllPersons().getBody();
		assertNotNull(list);
		
		LOG.info("List size: " + list.size());
	}

	@Test
	@Order(4)
	public void testDeleteByIdMethod() {
		RestResponse response = controller.delete(1l).getBody();
		assertNotNull(response);
		assertEquals(response.getMessage(), "Successfully deleted");
		
		LOG.info(response.getMessage());
	}

}
