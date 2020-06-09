package co.yiiu.pybbs.controller.api;
import co.yiiu.pybbs.exception.ApiAssert;
import co.yiiu.pybbs.model.Code;
import co.yiiu.pybbs.model.Follow;
import co.yiiu.pybbs.model.User;
import co.yiiu.pybbs.service.*;
import co.yiiu.pybbs.util.*;
import co.yiiu.pybbs.util.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.*;
import co.yiiu.pybbs.service.ICommentService;
import co.yiiu.pybbs.service.IFollowService;
import co.yiiu.pybbs.service.ITopicService;
import co.yiiu.pybbs.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/follow")
public class FollowApiController extends BaseApiController {

    @Autowired
    private IFollowService followService;

    @PostMapping("/add")
    public Result add(@RequestBody Map<String, String> body) {
        Integer userFrom = Integer.parseInt(body.get("from"));
        Integer userTo = Integer.parseInt(body.get("to"));
        Follow follow = followService.addFollow(userFrom, userTo);
        return success(follow);
    }

    @GetMapping("/getFrom/{userFrom}")
    public Result getFrom(@PathVariable Integer userFrom) {
        List<Map<String, Object>> list = followService.selectByUserFrom(userFrom);
        return success(list);
    }

    @GetMapping("/getTo/{userTo}")
    public Result getTo(@PathVariable Integer userTo) {
        List<Map<String, Object>> list = followService.selectByUserTo(userTo);
        return success(list);
    }

    @DeleteMapping("/delete/{userFrom}/{userTo}")
    public Result delete(@PathVariable Integer userFrom, @PathVariable Integer userTo) {
        followService.deleteFollow(userFrom, userTo);
        return success();
    }
}
