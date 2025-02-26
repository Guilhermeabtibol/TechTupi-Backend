package gui.tech.blog.service;

import gui.tech.blog.entity.Post;
import gui.tech.blog.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

    @Autowired
    public PostServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1L, "Title 1", "Content 1")); // Certifique-se de que o construtor existe

        when(postRepository.findAll()).thenReturn(posts);

        List<Post> result = postService.findAll();
        assertEquals(1, result.size());
        assertEquals("Title 1", result.get(0).getTitle());
    }
}