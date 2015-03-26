package hu.szasza.jba.repository;

import hu.szasza.jba.entity.Blog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
