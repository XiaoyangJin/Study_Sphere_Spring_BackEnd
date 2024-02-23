import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.study_sphere.spring_backend.Post.Post;

public class PostTests {

    @Test
    public void testPostConstructorAndGetters() {
        // Create a Post object using the parameterized constructor
        Post post = new Post(1, "Test Title", "Test Summary", "Test Content");

        // Assert that the getters return the correct values
        assertEquals(1, post.getPost_id());
        assertEquals("Test Title", post.getTitle());
        assertEquals("Test Summary", post.getSummary());
        assertEquals("Test Content", post.getMain_content());
    }

    @Test
    public void testSetters() {
        // Create a Post object using the no-argument constructor
        Post post = new Post();

        // Set values using setters
        post.setPost_id(2);
        post.setTitle("New Title");
        post.setSummary("New Summary");
        post.setMain_content("New Content");

        // Assert that the getters return the new values set by the setters
        assertEquals(2, post.getPost_id());
        assertEquals("New Title", post.getTitle());
        assertEquals("New Summary", post.getSummary());
        assertEquals("New Content", post.getMain_content());
    }
}
