package pojo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    private String name;
    private String login;
    private Integer age;
    private String email;
    private String password;
    private String salt;

    public User() {
    }

    public User(String name, String login, Integer age, String email, String password, String salt) {
        this.name = name;
        this.login = login;
        this.age = age;
        this.email = email;
        this.password = password;
        this.salt = salt;
    }

    @OneToMany(mappedBy = "user1",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> userList;

   public Long getIdUser() {
        return idUser;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        if (idUser != null ? !idUser.equals(user.idUser) : user.idUser != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (age != null ? !age.equals(user.age) : user.age != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;
    }

    @Override
    public int hashCode() {
        int result = idUser != null ? idUser.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}