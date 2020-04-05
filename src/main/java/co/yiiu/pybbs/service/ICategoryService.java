package co.yiiu.pybbs.service;

import co.yiiu.pybbs.model.Category;
import co.yiiu.pybbs.util.MyPage;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;
import java.util.Map;

public interface ICategoryService {
    void selectCategoryByCategoryId(MyPage<Map<String, Object>> page);

    Category selectById(Integer id);

    Category selectByName(String name);

    List<Category> selectByIds(List<Integer> ids);

    // 根据话题查询关联的所有类别
    List<Category> selectByTopicId(Integer Category);

    // 将创建话题时填的Category处理并保存
    List<Category> insertCategory(String newCategory);

    // 将标签的话题数都-1
    void reduceCategoryCount(Integer id);

    // 查询标签关联的话题
    MyPage<Map<String, Object>> selectTopicByCategoryId(Integer categoryId, Integer pageNo);

    // 查询标签列表
    IPage<Category> selectAll(Integer pageNo, Integer pageSize, String name);

    void update(Category category);

    // 如果 Category 表里还有关联的数据，这里删除会报错
    void delete(Integer id);

    //同步标签的话题数
    void async();

    // 查询今天新增的标签数
    int countToday();
}
