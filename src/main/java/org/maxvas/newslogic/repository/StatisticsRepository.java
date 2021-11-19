package org.maxvas.newslogic.repository;

import org.maxvas.newslogic.entity.Statistics;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatisticsRepository  extends CrudRepository<Statistics, Integer> {
    List<Statistics> findAll();
}
