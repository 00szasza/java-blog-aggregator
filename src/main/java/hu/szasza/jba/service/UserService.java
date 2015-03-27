package hu.szasza.jba.service;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import hu.szasza.jba.entity.Blog;
import hu.szasza.jba.entity.Item;
import hu.szasza.jba.entity.User;
import hu.szasza.jba.repository.BlogRepository;
import hu.szasza.jba.repository.ItemRepository;
import hu.szasza.jba.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<User> findAll()
	{
		return this.userRepository.findAll();
	}

	public User findUserById(int id) {
		
		return this.userRepository.findOne(id);
	}

	@Transactional
	public User findUserByIdWithBlog(int id) {
		
		User user = this.findUserById(id);
		
		List<Blog> blogs = this.blogRepository.findByUser(user);
		
		for(Blog blog : blogs)
		{
			List<Item> items = this.itemRepository.findByBlog(blog, new PageRequest(0, 10, Direction.DESC, "publishedDate"));
			blog.setItems(items);
		}
		
		user.setBlogs(blogs);
		return user;
	}
}
