package francescocristiano.U5_W2_D2.controllers;


import francescocristiano.U5_W2_D2.entities.BlogPost;
import francescocristiano.U5_W2_D2.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogposts")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;


    @GetMapping
    private List<BlogPost> getAllBlogPosts() {
        return blogPostService.getAllBlogPosts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private BlogPost saveBlogPost(@RequestBody BlogPost blogPost) {
        return blogPostService.saveBlogPost(blogPost);
    }

    @GetMapping("/{id}")
    private BlogPost findBlogPostById(@PathVariable int id) {
        return blogPostService.findBlogPostById(id);
    }

    @PutMapping("/{id}")
    private BlogPost findBlogPostByIdAndUpdate(@PathVariable int id, @RequestBody BlogPost blogPostUpdated) {
        return blogPostService.findBlogPostByIdAndUpdate(id, blogPostUpdated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteBlogPostById(@PathVariable int id) {
        blogPostService.deleteBlogPostById(id);
    }
}
