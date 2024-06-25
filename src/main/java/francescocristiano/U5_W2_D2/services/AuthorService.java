package francescocristiano.U5_W2_D2.services;

import francescocristiano.U5_W2_D2.entities.Author;
import francescocristiano.U5_W2_D2.exeptions.NotFoundExpetion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    private List<Author> authors = new ArrayList<>();

    public Author saveAuthor(Author author) {
        authors.add(author);
        return author;
    }

    public List<Author> getAllAuthors() {
        return authors;
    }

    public Author findAuthorById(int id) {
        return authors.stream().filter(author -> author.getId() == id).findFirst().orElseThrow(() -> new NotFoundExpetion(id));
    }

    public Author findAuthorByIdAndUpdate(int id, Author authorUpdated) {
        Author found = this.findAuthorById(id);
        found.setName(authorUpdated.getName());
        found.setSurname(authorUpdated.getSurname());
        found.setEmail(authorUpdated.getEmail());
        found.setBirthDate(authorUpdated.getBirthDate());
        found.setAvatar(authorUpdated.getAvatar());
        return found;
    }

    public void deleteAuthorById(int id) {
        authors.removeIf(author -> author.getId() == id);
    }
}

