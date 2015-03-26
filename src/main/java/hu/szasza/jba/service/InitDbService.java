package hu.szasza.jba.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import hu.szasza.jba.entity.Blog;
import hu.szasza.jba.entity.Item;
import hu.szasza.jba.entity.Role;
import hu.szasza.jba.entity.User;
import hu.szasza.jba.repository.BlogRepository;
import hu.szasza.jba.repository.ItemRepository;
import hu.szasza.jba.repository.RoleRepository;
import hu.szasza.jba.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class InitDbService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@PostConstruct
	public void init()
	{
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		this.roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		this.roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setName("admin");
		List<Role>roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		this.userRepository.save(userAdmin);
		
		Blog blogJavaVids = new Blog();
		blogJavaVids.setName("JavaVids");
		blogJavaVids.setUrl("http://feeds.feedburner.com/javavids?format=xml");
		blogJavaVids.setUser(userAdmin);
		this.blogRepository.save(blogJavaVids);
		
		Item item1 = new Item();
		item1.setBlog(blogJavaVids);
		item1.setTitle("first");
		item1.setLink("http://www.javavids.com/");
		item1.setPublishedDate(new Date());
		this.itemRepository.save(item1);
		
		Item item2 = new Item();
		item2.setBlog(blogJavaVids);
		item2.setTitle("second");
		item2.setLink("http://www.javavids.com/");
		item2.setPublishedDate(new Date());
		this.itemRepository.save(item2);
		
	}

}
