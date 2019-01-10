package com.youtube.tuto.controllers;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtube.tuto.dao.UserRepository;
import com.youtube.tuto.model.User;
import com.youtube.tuto.service.UserService;
import com.youtube.tuto.util.RestResponse;

@RestController
public class UserController {

	@Autowired
	protected UserService userService;

	protected ObjectMapper mapper;
	
	//@RequestBody indica que es un parametro
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException {
		//mapper convierte los objetos json a la clase User en este caso
		this.mapper = new ObjectMapper();
		User user = this.mapper.readValue(userJson, User.class);  
		
		if(!this.validate(user)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no se encuentran diligenciados");
		}
		
		this.userService.save(user);
		
		return new RestResponse(HttpStatus.OK.value(),"Operacion exitosa!");
	}
	
	private boolean validate(User user) {
		boolean isValid = true;
		
		if(StringUtils.trimToNull(user.getFirstName()) == null) {
			isValid = false;
		}
		if(StringUtils.trimToNull(user.getFirstSurname()) == null) {
			isValid = false;
		}
		if(StringUtils.trimToNull(user.getAdress()) == null) {
			isValid = false;
		}
		
		return isValid;
	}
	
}
