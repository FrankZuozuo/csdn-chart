package com.wretchant.csdnchart.service;

import com.google.common.collect.Lists;
import com.wretchant.csdnchart.entity.ArticleInfo;
import com.wretchant.csdnchart.entity.ConduitEnum;
import com.wretchant.csdnchart.repo.ArticleInfoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleInfoServiceImpl implements ArticleInfoService {

  private final ArticleInfoRepo articleInfoRepo;

  public ArticleInfoServiceImpl(ArticleInfoRepo articleInfoRepo) {
    this.articleInfoRepo = articleInfoRepo;
  }

  @Override
  public ArticleInfo create(ArticleInfo articleInfo) {

    Optional<ArticleInfo> byUrl = articleInfoRepo.findByUrl(articleInfo.getUrl());
    if (byUrl.isPresent()) {
      ArticleInfo article = byUrl.get();
      boolean b =
          article.getCommentNumber().equals(articleInfo.getCommentNumber())
              && article.getReadNumber().equals(articleInfo.getReadNumber());
      if (b) {
        return article;
      }

      article.setCommentNumber(articleInfo.getCommentNumber());
      article.setReadNumber(articleInfo.getReadNumber());
      return articleInfoRepo.saveAndFlush(article);
    }
    return articleInfoRepo.saveAndFlush(articleInfo);
  }

  @Override
  public List<ArticleInfo> list() {
    return articleInfoRepo.findAll();
  }

  @Override
  public long count() {
    return articleInfoRepo.count();
  }

  @Override
  public List<ArticleInfo> list(ConduitEnum conduit) {
    int number = 10;
    switch (conduit) {
      case NEW_MOST:
        return articleInfoRepo.listOrderByGmtCreateLimit(number);
      case VISIT_MOST:
        return articleInfoRepo.listOrderByReadNumberLimit(number);
      case COMMENT_MOST:
        return articleInfoRepo.listOrderByCommentNumberLimit(number);
      default:
    }
    return Lists.newArrayList();
  }
}
