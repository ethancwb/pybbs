package co.yiiu.pybbs.service.impl;

import co.yiiu.pybbs.mapper.CategoryMapper;
import co.yiiu.pybbs.model.Category;
import co.yiiu.pybbs.model.Tag;
import co.yiiu.pybbs.model.TopicCategory;
import co.yiiu.pybbs.model.TopicTag;
import co.yiiu.pybbs.service.ICategoryService;
import co.yiiu.pybbs.service.ISystemConfigService;
import co.yiiu.pybbs.service.ITopicCategoryService;
import co.yiiu.pybbs.util.MyPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ITopicCategoryService topicCategoryService;
    @Autowired
    private ISystemConfigService systemConfigService;

    @Override
    public void selectCategoryByCategoryId(MyPage<Map<String, Object>> page) {
        page.getRecords().forEach(map -> {
            List<TopicCategory> topicCategories = topicCategoryService.selectByTopicId((Integer) map.get("id"));
            if (!topicCategories.isEmpty()) {
                List<Integer> categoryIds = topicCategories.stream().map(TopicCategory::getCategoryId).collect(Collectors.toList());
                List<Category> categories = this.selectByIds(categoryIds);
                map.put("categories", categories);
            }
        });
    }

    @Override
    public Category selectById(Integer id) {
        return categoryMapper.selectById(id);
    }

    @Override
    public Category selectByName(String name) {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Category::getName, name);
        return categoryMapper.selectOne(wrapper);
    }

    @Override
    public List<Category> selectByIds(List<Integer> ids) {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(Category::getId, ids);
        return categoryMapper.selectList(wrapper);
    }

    @Override
    public List<Category> selectByTopicId(Integer topicId) {
        List<TopicCategory> topicCategories = topicCategoryService.selectByTopicId(topicId);
        if (!topicCategories.isEmpty()) {
            List<Integer> categoryIds = topicCategories.stream().map(TopicCategory::getCategoryId).collect(Collectors.toList());
            QueryWrapper<Category> wrapper = new QueryWrapper<>();
            wrapper.lambda().in(Category::getId, categoryIds);
            return categoryMapper.selectList(wrapper);
        }
        return Lists.newArrayList();
    }

    @Override
    public List<Category> insertCategory(String newCategory) {
        return null; // Does not support insert category
    }

    @Override
    public void reduceCategoryCount(Integer id) {
        List<Category> categories = this.selectByTopicId(id);
        categories.forEach(category -> {
            category.setTopicCount(category.getTopicCount() - 1);
            categoryMapper.updateById(category);
        });
    }

    @Override
    public MyPage<Map<String, Object>> selectTopicByCategoryId(Integer categoryId, Integer pageNo) {
        MyPage<Map<String, Object>> iPage = new MyPage<>(pageNo, Integer.parseInt(systemConfigService.selectAllConfig()
                .get("page_size").toString()));
        return categoryMapper.selectTopicByCategoryId(iPage, categoryId);
    }

    @Override
    public IPage<Category> selectAll(Integer pageNo, Integer pageSize, String name) {
        IPage<Category> iPage = new MyPage<>(pageNo, pageSize == null ? Integer.parseInt(systemConfigService.selectAllConfig()
                .get("page_size").toString()) : pageSize);
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        // 当传进来的name不为null的时候，就根据name查询
        if (!StringUtils.isEmpty(name)) {
            wrapper.lambda().eq(Category::getName, name);
        }
        wrapper.orderByDesc("topic_count");
        return categoryMapper.selectPage(iPage, wrapper);
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateById(category);
    }

    @Override
    public void delete(Integer id) {
        categoryMapper.deleteById(id);

    }

    @Override
    public void async() {
        List<Category> categories = categoryMapper.selectList(null);
        categories.forEach(category -> {
            List<TopicCategory> topicCategories = topicCategoryService.selectByCategoryId(category.getId());
            category.setTopicCount(topicCategories.size());
            this.update(category);
        });
    }

    @Override
    public int countToday() {
        return categoryMapper.countToday();
    }
}
