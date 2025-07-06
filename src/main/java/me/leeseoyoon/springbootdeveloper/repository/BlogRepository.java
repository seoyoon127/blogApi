package me.leeseoyoon.springbootdeveloper.repository;

import me.leeseoyoon.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
