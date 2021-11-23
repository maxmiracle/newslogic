package org.maxvas.newslogic.repository;

import org.maxvas.newslogic.entity.Factor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "rest")
public interface FactorRepository extends CrudRepository<Factor, Integer> {
    List<Factor> findAll();
    Optional<Factor> findByArticleId(String articleId);
}
