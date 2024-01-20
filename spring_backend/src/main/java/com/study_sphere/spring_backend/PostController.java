package com.study_sphere.spring_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
	private PostRepository postRepository;
	
	@PostMapping
	public ResponseEntity<Post> createPost(@RequestBody Post post) {
		Post savedPost = postRepository.save(post);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);	
	}
	
//	@GetMapping
//	public ResponseEntity<Post> getPost(@RequestBody Post post) {
//		Post savedPost = postRepository.;
//        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);	
//	}
}
