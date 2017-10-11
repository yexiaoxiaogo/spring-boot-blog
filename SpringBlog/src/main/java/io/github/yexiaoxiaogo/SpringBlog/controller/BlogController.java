package io.github.yexiaoxiaogo.SpringBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.github.yexiaoxiaogo.SpringBlog.domain.Blog;
import io.github.yexiaoxiaogo.SpringBlog.service.BlogList;

@Controller
public class BlogController {

	@Autowired
	BlogList blogList;

	@RequestMapping(value = "/params", method = RequestMethod.GET)
	public Page<Blog> getEntryByParams(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "15") Integer size) {
		Sort sort = new Sort(Direction.DESC, "blogid");
		Pageable pageable = new PageRequest(page, size, sort);
		return blogList.findAll(pageable);
	}
	
	  @RequestMapping(value = "", method=RequestMethod.GET)
	    public Page<Blog> getEntryByPageable(@PageableDefault(value = 15, sort = { "blogid" }, direction = Sort.Direction.DESC) 
	        Pageable pageable) {
	        return blogList.findAll(pageable);
	    }
}
