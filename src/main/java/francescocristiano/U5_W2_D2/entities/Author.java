package francescocristiano.U5_W2_D2.entities;

import lombok.Data;

import java.util.Date;
import java.util.Random;

@Data
public class Author {
    private int id;
    private String name;
    private String surname;
    private String email;
    private Date birthDate;
    private String avatar;

    public Author(String name, String surname, String email, Date birthDate, String avatar) {
        this.id = new Random().nextInt(1, 10000);
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthDate = birthDate;
        this.avatar = "https://ui-avatars.com/api/?name=" + name + "+" + surname;
    }

}
