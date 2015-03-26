package hu.szasza.jba.service;

import java.util.List;

import hu.szasza.jba.entity.User;
import hu.szasza.jba.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll()
	{
		return this.userRepository.findAll();
	}

	public User findUserById(int id) {
		
		return this.userRepository.findOne(id);
	}
}
