package francescocristiano.U5_W2_D2.services;


import com.github.javafaker.Faker;
import francescocristiano.U5_W2_D2.entities.BlogPost;
import francescocristiano.U5_W2_D2.exeptions.NotFoundExpetion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostService {

    private List<BlogPost> blogPosts = new ArrayList<>();
    private Random random = new Random();
    private Faker faker = new Faker();


    public BlogPost saveBlogPost(BlogPost blogPost) {
        blogPost.setTitle(faker.book().title());
        blogPost.setBody(faker.lorem().paragraph(random.nextInt(1, 3)));
        /*blogPost.setCategory(Category.values()[random.nextInt(0, Category.values().length)]);*/
        blogPosts.add(blogPost);
        return blogPost;
    }

    public List<BlogPost> getAllBlogPosts() {
        return blogPosts;
    }

    public BlogPost findBlogPostById(int id) {
        return blogPosts.stream().filter(blogPost -> blogPost.getId() == id).findFirst().orElseThrow(() -> new NotFoundExpetion(id));
    }

    public BlogPost findBlogPostByIdAndUpdate(int id, BlogPost blogPostUpdated) {
        BlogPost found = null;
        found = this.findBlogPostById(id);
        found.setTitle(blogPostUpdated.getTitle());
        found.setBody(blogPostUpdated.getBody());
        found.setReadingTime(blogPostUpdated.getReadingTime());
        found.setCategory(blogPostUpdated.getCategory());
        found.setCover(blogPostUpdated.getCover());
        return found;
    }

    public void deleteBlogPostById(int id) {
        Iterator<BlogPost> iterator = blogPosts.iterator();
        while (iterator.hasNext()) {
            BlogPost currentBlogPost = iterator.next();
            if (currentBlogPost.getId() == id) {
                iterator.remove();
            }
        }
    }


}
