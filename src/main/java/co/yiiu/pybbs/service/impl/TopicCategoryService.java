package co.yiiu.pybbs.service.impl;

import co.yiiu.pybbs.mapper.TopicCategoryMapper;
import co.yiiu.pybbs.model.Category;
import co.yiiu.pybbs.model.Tag;
import co.yiiu.pybbs.model.TopicCategory;
import co.yiiu.pybbs.model.TopicTag;
import co.yiiu.pybbs.service.ITopicCategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
@Service
@Transactional
public class TopicCategoryService implements ITopicCategoryService {

    @Autowired
    private TopicCategoryMapper topicCategoryMapper;

    @Override
    public List<TopicCategory> selectByTopicId(Integer topicId) {
        QueryWrapper<TopicCategory> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(TopicCategory::getTopicId, topicId);
        return topicCategoryMapper.selectList(wrapper);
    }

    @Override
    public List<TopicCategory> selectByCategoryId(Integer categoryId) {
        QueryWrapper<TopicCategory> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(TopicCategory::getCategoryId, categoryId);
        return topicCategoryMapper.selectList(wrapper);
    }

    @Override
    public void insertTopicCategory(Integer topicId, List<Category> categoryList) {
        // 先删除topicId对应的所有记录
        this.deleteByTopicId(topicId);
        // 循环保存对应关联
        categoryList.forEach(category -> {
            TopicCategory topicCategory = new TopicCategory();
            topicCategory.setTopicId(topicId);
            topicCategory.setCategoryId(category.getId());
            topicCategoryMapper.insert(topicCategory);
        });
    }

    // 删除话题所有关联的标签记录
    @Override
    public void deleteByTopicId(Integer id) {
        QueryWrapper<TopicCategory> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(TopicCategory::getTopicId, id);
        topicCategoryMapper.delete(wrapper);
    }
}
