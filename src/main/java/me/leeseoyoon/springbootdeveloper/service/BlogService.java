package me.leeseoyoon.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.leeseoyoon.springbootdeveloper.domain.Article;
import me.leeseoyoon.springbootdeveloper.dto.AddArticleRequest;
import me.leeseoyoon.springbootdeveloper.dto.UpdateArticleRequest;
import me.leeseoyoon.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    //블로그 글목록 조회 메서드
    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    //블로그 글 조회 메서드
    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found: " + id));
    }

    //블로그 글 삭제 메서드
    public void delete(long id){
        blogRepository.deleteById(id);
    }

    //블로그 글 수정 메서드
    @Transactional
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
