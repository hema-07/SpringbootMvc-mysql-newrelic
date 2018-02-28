package com.wipro.movie.repository;

import org.springframework.data.repository.CrudRepository;

import com.wipro.movie.bean.User;


public interface UserRepository  extends CrudRepository<User,String>{

}
