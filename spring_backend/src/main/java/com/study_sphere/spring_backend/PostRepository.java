package com.study_sphere.spring_backend;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PostRepository extends JpaRepository<Post, Long> {
//	List<Post> findByLastName(@Param("name") String name);

}
