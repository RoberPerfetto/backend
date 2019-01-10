package com.youtube.tuto.service;

import java.util.List;

import com.youtube.tuto.model.User;

public interface UserService {

	//Guarda un usuario
	//Retorna el usario guardado
	User save(User user);

	//Recupera la lista de todos los usarios
	//retorna esa lista
	List<User> findAll();

	//Elimina un usario
	//No retorna nada
	void deleteUser(Long id);

}
