package com.wretchant.csdnchart.service;

import com.wretchant.csdnchart.entity.ArticleInfo;
import com.wretchant.csdnchart.repo.ArticleInfoRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Dream what you want to dream; go where you want to go; be what you want to be; because you have
 * only one life and one chance to do all the things you want to do． - - Online zuozuo / Frank /
 * TANJIAN
 *
 * @author Created by 谭健 on 2019/10/1 星期二 21:01.
 * @link <a href="http://qm.qq.com/cgi-bin/qm/qr?k=FJVK7slBx7qC5tKm_KdFTbwWOFHq1ASt">Join me</a>
 * @link <a href="http://blog.csdn.net/qq_15071263">CSDN Home Page</a>
 *     <p>
 *     <p>© All Rights Reserved.
 */
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
}
