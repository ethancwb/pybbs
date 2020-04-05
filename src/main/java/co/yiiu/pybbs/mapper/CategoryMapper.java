package co.yiiu.pybbs.mapper;

import co.yiiu.pybbs.model.Category;
import co.yiiu.pybbs.util.MyPage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface CategoryMapper extends BaseMapper<Category> {
    MyPage<Map<String, Object>> selectTopicByCategoryId(MyPage<Map<String, Object>> iPage, @Param("categoryId") Integer categoryId);

    int countToday();
}
