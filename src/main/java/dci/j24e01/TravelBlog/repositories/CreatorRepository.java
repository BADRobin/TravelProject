package dci.j24e01.TravelBlog.repositories;

import dci.j24e01.TravelBlog.models.Creator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatorRepository extends JpaRepository<Creator, Integer> {

    // If needed, you can add custom queries here ;D
}
