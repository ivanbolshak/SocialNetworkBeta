package net.bolshak.socialnetwork.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ivan on 24.06.2016.
 */

    @Entity
    @Table(name = "person")
    public class Person {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;
       @Column (name = "first_name")
        private String firstName;
        @Column (name = "last_name")
        private String lastName;
        @Column (name = "birthday")
        private String birthday;
        @Column (name = "nickname")
        private String nickname;



    @OneToMany(mappedBy = "person")
        private List<Post> posts;

    public Person() {
    }

    public Person(String firstName, String lastName, String birthday, String nickname) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.nickname = nickname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
