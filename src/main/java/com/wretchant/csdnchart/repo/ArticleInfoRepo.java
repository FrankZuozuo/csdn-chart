package com.wretchant.csdnchart.repo;

import com.wretchant.csdnchart.entity.ArticleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArticleInfoRepo extends JpaRepository<ArticleInfo, Long> {

  Optional<ArticleInfo> findByUrl(String url);

  @Query(
      nativeQuery = true,
      value = "select * from article_info a order by a.read_number desc limit ?1")
  List<ArticleInfo> listOrderByReadNumberLimit(Integer limit);

  @Query(
      nativeQuery = true,
      value = "select * from article_info a order by a.comment_number desc limit ?1")
  List<ArticleInfo> listOrderByCommentNumberLimit(Integer limit);

  @Query(
      nativeQuery = true,
      value = "select * from article_info a order by a.gmt_create desc limit ?1")
  List<ArticleInfo> listOrderByGmtCreateLimit(Integer limit);
}
