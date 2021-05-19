package com.example.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.domain.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	@Query(nativeQuery=true, value="select * from user where mark = :mark")
	User findOneByMark(@Param("mark") Integer mark);
}
