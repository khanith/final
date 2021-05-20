package com.ltts.shadow;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ltts.shadow.Repositories.UserJPA;
import com.ltts.shadow.model.UsersLog;

@SpringBootApplication
public class SpringBootHelloWorldApplication {

	@Autowired
	UserJPA ujpa;
	@PostConstruct
	public void initUsers()
	{
		List<UsersLog> users= Stream.of(new UsersLog(1,"sarvesh","$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6"),new UsersLog(2,"user","$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6")).collect(Collectors.toList());
		ujpa.saveAll(users);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloWorldApplication.class, args);
	}
}