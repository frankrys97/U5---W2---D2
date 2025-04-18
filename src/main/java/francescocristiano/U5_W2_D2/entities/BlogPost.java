package francescocristiano.U5_W2_D2.entities;

import francescocristiano.U5_W2_D2.enums.Category;
import lombok.Data;

import java.util.Random;


@Data
public class BlogPost {
    private int id;
    private Category category;
    private String title;
    private String cover;
    private String body;
    private int readingTime;

    public BlogPost(String categoryString, String title, String body, int readingTime) {
        this.id = new Random().nextInt(1, 10000);
        this.category = this.categoryFromString(categoryString);
        this.title = title;
        this.cover = "https://picsum.photos/200/300";
        this.body = body;
        this.readingTime = readingTime;
    }

    public Category categoryFromString(String categoryString) {
        if (categoryString == null) {
            throw new IllegalArgumentException("categoryString cannot be null");
        }
        try {
            return Category.valueOf(categoryString.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("categoryString must be one of: NEWS, TECH, SCIENCE, ENTERTAINMENT, SPORT, LIFESTYLE, TRAVEL, FASHION");
        }
    }
}
