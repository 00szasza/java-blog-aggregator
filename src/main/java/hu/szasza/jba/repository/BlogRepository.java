package hu.szasza.jba.repository;

import java.util.List;

import hu.szasza.jba.entity.Blog;
import hu.szasza.jba.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

	List<Blog> findByUser(User user);
}
