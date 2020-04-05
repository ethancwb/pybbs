package co.yiiu.pybbs.service;

import co.yiiu.pybbs.model.Category;
import co.yiiu.pybbs.model.Tag;
import co.yiiu.pybbs.model.TopicCategory;
import co.yiiu.pybbs.model.TopicTag;

import java.util.List;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
public interface ITopicCategoryService {
    List<TopicCategory> selectByTopicId(Integer topicId);

    List<TopicCategory> selectByCategoryId(Integer categoryId);

    void insertTopicCategory(Integer topicId, List<Category> categoryList);

    // 删除话题所有关联的标签记录
    void deleteByTopicId(Integer id);
}
