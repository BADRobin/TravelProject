package dci.j24e01.TravelBlog.models;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "routs")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String geoJson;

    @OneToOne
    @JoinColumn(name = "vacation_point_id")
    private VacationPoint vacationPoint;

    public Route() {
    }

    public Route(Long id, String geoJson, VacationPoint vacationPoint) {
        this.id = id;
        this.geoJson = geoJson;
        this.vacationPoint = vacationPoint;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGeoJson() {
        return geoJson;
    }

    public void setGeoJson(String geoJson) {
        this.geoJson = geoJson;
    }

    public VacationPoint getVacationPoint() {
        return vacationPoint;
    }

    public void setVacationPoint(VacationPoint vacationPoint) {
        this.vacationPoint = vacationPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Route route)) return false;
        return Objects.equals(id, route.id) && Objects.equals(geoJson, route.geoJson) && Objects.equals(vacationPoint, route.vacationPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, geoJson, vacationPoint);
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", geoJson='" + geoJson + '\'' +
                ", vacationPoint=" + vacationPoint +
                '}';
    }
}
