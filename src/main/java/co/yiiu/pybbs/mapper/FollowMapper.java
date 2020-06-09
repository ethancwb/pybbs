package co.yiiu.pybbs.mapper;

import co.yiiu.pybbs.model.Follow;
import co.yiiu.pybbs.model.Tag;
import co.yiiu.pybbs.util.MyPage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FollowMapper extends BaseMapper<Follow> {
    List<Map<String, Object>> selectFollowsByUserFrom(@Param("userFrom") Integer userFrom);
    List<Map<String, Object>> selectFollowsByUserTo(@Param("userTo")Integer userTo);
    Follow selectByUserFromAndUserTo(@Param("userFrom") Integer userFrom, @Param("userTo") Integer userTo);
}
