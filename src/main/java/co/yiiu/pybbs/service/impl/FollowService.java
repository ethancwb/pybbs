package co.yiiu.pybbs.service.impl;

import co.yiiu.pybbs.mapper.FollowMapper;
import co.yiiu.pybbs.model.Follow;
import co.yiiu.pybbs.model.User;
import co.yiiu.pybbs.service.IFollowService;
import co.yiiu.pybbs.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FollowService implements IFollowService {

    @Autowired
    private FollowMapper followMapper;

    @Autowired
    @Lazy
    private IUserService userService;

    @Override
    public List<Map<String, Object>> selectByUserFrom(Integer userFrom) {
        List<Map<String, Object>> followList = followMapper.selectFollowsByUserFrom(userFrom);
        return followList;
    }

    @Override
    public List<Map<String, Object>> selectByUserTo(Integer userTo) {
        List<Map<String, Object>> followList = followMapper.selectFollowsByUserTo(userTo);
        return followList;
    }

    @Override
    public void deleteFollow(Integer userFrom, Integer userTo) {
        Follow follow  = followMapper.selectByUserFromAndUserTo(userFrom, userTo);
        if (follow != null){
            followMapper.deleteById(follow.getId());
        }
    }

    @Override
    public Follow addFollow(Integer userFrom, Integer userTo) {
        Follow follow  = followMapper.selectByUserFromAndUserTo(userFrom, userTo);
        if (follow == null){
            follow = new Follow();
            follow.setUserFrom(userFrom);
            follow.setUserTo(userTo);
            followMapper.insert(follow);
        }
        return follow;

    }
}
