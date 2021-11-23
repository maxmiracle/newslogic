package org.maxvas.newslogic.service;

import lombok.AllArgsConstructor;
import org.maxvas.batchnews.entity.Article;
import org.maxvas.newslogic.entity.Factor;
import org.maxvas.newslogic.entity.Stat;
import org.maxvas.newslogic.entity.Statistics;
import org.maxvas.newslogic.repository.ArticleRepository;
import org.maxvas.newslogic.repository.FactorRepository;
import org.maxvas.newslogic.repository.StatisticsRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.*;

@Component
@AllArgsConstructor
public class StatisticsService {

    private final StatisticsRepository statisticsRepository;

    private final FactorRepository factorRepository;

    private final ArticleRepository articleRepository;

    @Transactional
    public void calculateStatistics(String word) {
        Statistics statistics = new Statistics();
        statistics.setAnalysisDate(new Date());
        statistics.setDescription("Occurance of ".concat(word));
        String statisticsId = "OccuranceOf_".concat(word);
        statistics.setId(statisticsId);
        statisticsRepository.save(statistics);
        List<Article> articles = articleRepository.findAll();
        Iterator<Article> articleIterator = articles.iterator();
        try {
            while (articleIterator.hasNext()) {
                Article article = articleIterator.next();
                createFactor(article, word, statisticsId);
            }
        } finally {

        }
    }

    @Transactional
    public void createFactor(Article article, String word, String statisticsId) {
        Optional<Factor> optionalFactor = factorRepository.findByArticleId(article.get_id());
        long count = StringUtils.countOccurrencesOf(article.getText(), word);
        Stat stat = new Stat();
        stat.setCount(count);
        Factor factor;
        if (optionalFactor.isPresent()) {
            factor = optionalFactor.get();
            factor.getStats().put(statisticsId, stat);
        } else {
            factor = new Factor();
            factor.setArticleId(article.get_id());
            factor.setDate(article.getDate());
            factor.setLink(article.getLink());
            factor.setStats(Map.of(statisticsId, stat));
        }
        factorRepository.save(factor);
    }

    public List<Statistics> findAll() {
        return statisticsRepository.findAll();
    }


}
