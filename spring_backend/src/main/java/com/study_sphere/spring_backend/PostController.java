package com.study_sphere.spring_backend;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
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
	
	@GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        Optional<Post> post = postRepository.findById(id);

        if (post.isPresent()) {
            postRepository.delete(post.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
