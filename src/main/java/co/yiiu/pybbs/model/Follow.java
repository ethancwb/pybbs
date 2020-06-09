package co.yiiu.pybbs.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

public class Follow implements Serializable {
    private static final long serialVersionUID = 7824693633858106664L;

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userFrom;
    private Integer userTo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(Integer userFrom) {
        this.userFrom = userFrom;
    }

    public Integer getUserTo() {
        return userTo;
    }

    public void setUserTo(Integer userTo) {
        this.userTo = userTo;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "id=" + id +
                ", userFrom=" + userFrom +
                ", userTo=" + userTo +
                '}';
    }
}
