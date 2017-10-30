package io.github.yexiaoxiaogo.SpringBlog.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.yexiaoxiaogo.SpringBlog.domain.Log;

public interface LogRepository { // extends MongoRepository<Log, Long> {
	public void log();
	public void err();

}
