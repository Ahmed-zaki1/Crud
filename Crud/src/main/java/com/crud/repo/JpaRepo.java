package com.crud.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.crud.entity.BeanPojo;

@Repository
public interface JpaRepo extends JpaRepository<BeanPojo, Integer> {

	Page<BeanPojo> findByPincode(String pincode, Pageable page);

	@Query(value = "select * from Finicity where name = :name", nativeQuery = true)
	List<BeanPojo> findByName(@Param("name") String name);

}
