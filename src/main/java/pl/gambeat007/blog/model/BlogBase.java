package pl.gambeat007.blog.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

@MappedSuperclass
public abstract class BlogBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
