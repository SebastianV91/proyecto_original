/**
 * 
 */
package com.curso.ecommerce.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.ecommerce.dao.UserDao;
import com.curso.ecommerce.dao.UserLegacyDao;
import com.curso.ecommerce.model.api.User;

/**
 * @author raidentrance
 *
 */
@Service
public class UserService extends UserDao{
//	@Autowired
//	private UserDao userDao;

	@Autowired
	private UserLegacyDao userLegacyDao;

	public Map<String, Object> getUsers() throws Exception {
		return getTESTRepository("Sebastian");
	}

	public List<User> getLegacyUsers() {
		return userLegacyDao.findAll();
	}

}
