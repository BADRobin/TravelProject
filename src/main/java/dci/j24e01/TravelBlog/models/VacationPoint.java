package dci.j24e01.TravelBlog.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "vacation_points")
public class VacationPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private double latitude;
    private double longitude;

    @Column(columnDefinition = "TEXT")
    private String route;

    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "vacationPoint", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Photo> photos;
    private boolean approved;


    public VacationPoint() {
    }

    public VacationPoint(Long id, String title, String description, double latitude, double longitude, String route, LocalDateTime createdAt, List<Photo> photos, boolean approved) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.route = route;
        this.createdAt = createdAt;
        this.photos = photos;
        this.approved = approved;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof VacationPoint that)) return false;
        return Double.compare(latitude, that.latitude) == 0 && Double.compare(longitude, that.longitude) == 0 && approved == that.approved && Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(route, that.route) && Objects.equals(createdAt, that.createdAt) && Objects.equals(photos, that.photos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, latitude, longitude, route, createdAt, photos, approved);
    }

    @Override
    public String toString() {
        return "VacationPoint{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", route='" + route + '\'' +
                ", createdAt=" + createdAt +
                ", photos=" + photos +
                ", approved=" + approved +
                '}';
    }
}