package com.study_sphere.spring_backend;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(PostController.class)
class PostControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	
	private ObjectMapper objectMapper;

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
