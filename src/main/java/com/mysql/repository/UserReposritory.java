package com.mysql.repository;

import org.springframework.data.repository.CrudRepository;

import com.mysql.domain.User;

public interface UserReposritory extends CrudRepository<User,Long> {

}
