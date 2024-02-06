package com.study_sphere.spring_backend.Post;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "post", path = "post")
public interface PostRepository extends JpaRepository<Post, Long> {
//	List<Post> findByLastName(@Param("name") String name);

}
