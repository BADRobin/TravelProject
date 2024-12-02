package dci.j24e01.TravelBlog.repositories;

import dci.j24e01.TravelBlog.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
