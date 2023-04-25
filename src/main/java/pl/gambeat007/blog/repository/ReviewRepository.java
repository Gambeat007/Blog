package pl.gambeat007.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gambeat007.blog.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}