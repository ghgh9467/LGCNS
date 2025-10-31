package com.example.myproject.controller;

import com.example.myproject.dto.ArticleForm;
import com.example.myproject.entity.Article;
import com.example.myproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        log.info(form.toString());

        //1. dto를 entity로 변환
        Article article = form.toEntity();
        log.info(article.toString());

        //2. repository에게 entity를 DB에 저장하게 함
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        return "redirect:/articles";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id : " + id);
        //id로 데이터를 가져옴
        Article articleEntity = articleRepository.findById(id).orElse(null);

        //가져온 데이터를 모델에 등록
        model.addAttribute("article", articleEntity);

        //보여줄 페이지 설정
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model){
        //모든 데이터를 가져옴
        List<Article> articleEntityList = (List<Article>)articleRepository.findAll();
        log.info(articleEntityList.toString());

        //가져온 데이터를 모델에 등록
        model.addAttribute("articleList", articleEntityList);

        //보여줄 페이지 설정
        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        //수정할 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        log.info(articleEntity.toString());

        //모델에 데이터 등록
        model.addAttribute("article", articleEntity);

        //뷰 페이지 설정

        return "articles/edit";
    }

    @PostMapping("/articles/update")
    public String update(ArticleForm form){
        log.info(form.toString());

        //1. DTO를 엔티티로 변환
        Article articleEntity = form.toEntity();

        //2. 엔티티를 DB로 저장
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);
        log.info(target.toString());

        if(target != null){
            articleRepository.save(articleEntity);
            log.info(articleEntity.toString());
        }

        //3. 수정 결과 페이지로 리다이렉트
        return "redirect:/articles/"+articleEntity.getId();
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){
        log.info("삭제 요청");

//        1. 삭제 대상을 가져옴
        Article target = articleRepository.findById(id).orElse(null);

//        2. 대상을 삭제
        if(target != null){
            articleRepository.delete(target);
            log.info("삭제가 완료되었습니다.");
            rttr.addFlashAttribute("msg", "삭제가 완료되었습니다.");
        }

//        3. 결과 페이지로 리다이렉트
        return "redirect:/articles";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }
}
