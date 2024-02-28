package com.study_sphere.spring_backend.Post;

import static org.mockito.ArgumentMatchers.any;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.study_sphere.spring_backend.Post.Post;
import com.study_sphere.spring_backend.Post.PostController;
import com.study_sphere.spring_backend.Post.PostRepository;


@WebMvcTest(PostController.class)
class PostControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PostRepository postRepository;
	
	@Autowired
    private ObjectMapper objectMapper;

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
	
	@Test
	public void deletePostTest_PostExists() throws Exception {
	    int postId = 103;
	    Post post = new Post(postId, "Test Delete Title", "Test Delete Summary", "Test Delete Content");
	    given(postRepository.findById((long)postId)).willReturn(Optional.of(post));

	    mockMvc.perform(delete("/api/posts/{id}", postId))
	            .andExpect(status().isNoContent());

	    verify(postRepository, times(1)).delete(post);
	}

	@Test
	public void deletePostTest_PostNotFound() throws Exception {
	    int postId = 104;
	    given(postRepository.findById((long)postId)).willReturn(Optional.empty());

	    mockMvc.perform(delete("/api/posts/{id}", postId))
	            .andExpect(status().isNotFound());
	}

	@Test
	public void updatePostTest_PostExists() throws Exception {
	    int postId = 105;
	    Post existingPost = new Post(postId, "Old Title", "Old Summary", "Old Content");
	    Post updatedDetails = new Post(postId, "New Title", "New Summary", "New Content");
	    given(postRepository.findById((long)postId)).willReturn(Optional.of(existingPost));
	    given(postRepository.save(any(Post.class))).willReturn(updatedDetails);

	    mockMvc.perform(put("/api/posts/{id}", postId)
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(objectMapper.writeValueAsString(updatedDetails)))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.title").value(updatedDetails.getTitle()));
	}

	@Test
	public void updatePostTest_PostNotFound() throws Exception {
	    int postId = 106;
	    Post updatedDetails = new Post(postId, "New Title", "New Summary", "New Content");
	    given(postRepository.findById((long)postId)).willReturn(Optional.empty());

	    mockMvc.perform(put("/api/posts/{id}", postId)
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(objectMapper.writeValueAsString(updatedDetails)))
	            .andExpect(status().isNotFound());
	}


}
