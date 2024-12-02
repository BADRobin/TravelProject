package dci.j24e01.TravelBlog.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String photoPath;

    @ManyToOne
    @JoinColumn(name = "vacation_point_id")
    private VacationPoint vacationPoint;

    public Photo() {
    }

    public Photo(Long id, String photoPath, VacationPoint vacationPoint) {
        this.id = id;
        this.photoPath = photoPath;
        this.vacationPoint = vacationPoint;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public VacationPoint getVacationPoint() {
        return vacationPoint;
    }

    public void setVacationPoint(VacationPoint vacationPoint) {
        this.vacationPoint = vacationPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Photo photo)) return false;
        return Objects.equals(id, photo.id) && Objects.equals(photoPath, photo.photoPath) && Objects.equals(vacationPoint, photo.vacationPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, photoPath, vacationPoint);
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", photoPath='" + photoPath + '\'' +
                ", vacationPoint=" + vacationPoint +
                '}';
    }
}