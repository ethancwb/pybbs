package co.yiiu.pybbs.service;

import co.yiiu.pybbs.model.Follow;
import co.yiiu.pybbs.model.User;

import java.util.List;
import java.util.Map;

public interface IFollowService {

    List<Map<String, Object>> selectByUserFrom(Integer userFrom);
    List<Map<String, Object>> selectByUserTo(Integer userTo);
    void deleteFollow(Integer userFrom, Integer userTo);
    Follow addFollow(Integer userFrom, Integer userTo);

}
