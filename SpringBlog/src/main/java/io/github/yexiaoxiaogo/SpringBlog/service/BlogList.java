package io.github.yexiaoxiaogo.SpringBlog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import io.github.yexiaoxiaogo.SpringBlog.domain.Blog;

public interface BlogList extends PagingAndSortingRepository<Blog,Integer>{
	
	Page<Blog> findByDeletedFalse(Pageable pageable);

}
