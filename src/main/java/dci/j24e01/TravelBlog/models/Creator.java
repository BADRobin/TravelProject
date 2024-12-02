package dci.j24e01.TravelBlog.models;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "about") // Maps to the 'about' table
public class Creator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String role;
    private String bio;

    @Column(name = "image_url")
    private String imageUrl;


    public Creator() {
    }


    public Creator(String name, String role, String bio, String imageUrl) {
        this.name = name;
        this.role = role;
        this.bio = bio;
        this.imageUrl = imageUrl;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creator creator = (Creator) o;
        return id == creator.id &&
                Objects.equals(name, creator.name) &&
                Objects.equals(role, creator.role) &&
                Objects.equals(bio, creator.bio) &&
                Objects.equals(imageUrl, creator.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role, bio, imageUrl);
    }

    @Override
    public String toString() {
        return "Creator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", bio='" + bio + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
