package com.study_sphere.spring_backend;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

// manually import
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;


import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(PostController.class)
class PostControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PostRepository postRepository;

	@Test
	public void createPostTest() throws Exception {
	    Post post = new Post(100, "Test Post Title", "Test Post Summary", "Test Post Content");
	    Mockito.when(postRepository.save(any(Post.class))).thenReturn(post);

	    mockMvc.perform(post("/api/posts")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(new ObjectMapper().writeValueAsString(post)))
	            .andExpect(status().isCreated())
	            .andExpect(jsonPath("$.title", is(post.getTitle())));
	}
	
	@Test
	public void getAllPostsTest() throws Exception {
	    List<Post> posts = Arrays.asList(new Post(101, "Test Get Title 1", "Test Get Summary 1", "Test Get Content 1"),
	                                     new Post(102, "Test Get Title 2", "Test Get Summary 2", "Test Get Content 2"));
	    given(postRepository.findAll()).willReturn(posts);

	    mockMvc.perform(get("/api/posts")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.size()").value(posts.size()));
	}


}
