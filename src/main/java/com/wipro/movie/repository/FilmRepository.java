package com.wipro.movie.repository;

import org.springframework.data.repository.CrudRepository;

import com.wipro.movie.bean.Film;

public interface FilmRepository extends CrudRepository<Film,String>{


}
