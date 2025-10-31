package com.example.myproject.service;

import com.example.myproject.dto.ArticleForm;
import com.example.myproject.entity.Article;
import com.example.myproject.repository.ArticleRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> index() {
        return (List<Article>)articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(Article entity) {
        return articleRepository.save(entity);
    }

    public Article update(Long id, ArticleForm dto) {
        //1. 수정용 엔티티 생성
        Article article = dto.toEntity();
        log.info("{}, {}", id, article.toString());

        //2. 대상 엔티티를 조회
        Article target = articleRepository.findById(id).orElse(null);

        //3. 잘못된 요청 처리 검사
        if(target == null || id != article.getId()){
            log.info("잘못된 요청");
            return null;
        }

        //4. 업데이트 및 정상 응답
        target.patch(article);

        Article updated = articleRepository.save(target);
        return updated;

    }

    public Article delete(Long id) {
        //대상 찾기
        Article target = articleRepository.findById(id).orElse(null);

        //잘못된 요청 처리
        if(target == null){
            return null;
        }

        //대상 삭제
        articleRepository.delete(target);
        return target;
    }

    @Transactional
    public List<Article> createArticles(List<ArticleForm> dtos) {
        List<Article> articleList = dtos.stream().map(dto->dto.toEntity()).collect(Collectors.toList());

        articleList.stream().forEach(article -> articleRepository.save(article));

articleRepository.findById(-1L).orElseThrow(
        ()-> new IllegalArgumentException("결재실패")
);

        return null;
    }
}
