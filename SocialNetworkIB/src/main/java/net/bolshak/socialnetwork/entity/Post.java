package net.bolshak.socialnetwork.entity;

import javax.persistence.*;


/**
 * Created by Ivan on 15.07.2016.
 */

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
//    @Column(name = "person_id", insertable = false, updatable = false)
//    @Column(name = "person_id")
//    private Integer personId;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;


    public Post() {
    }

    public Post(String title, String content, Person person) {
        this.title = title;
        this.content = content;
        this.person = person;
//        this.personId = personId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


//    public Integer getPersonId() {
//        return personId;
//    }

//    public void setPersonId(Integer personId) {
//        this.personId = personId;
//    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", personId=" +
                '}';
    }
}
