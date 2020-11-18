package com.example.web_class.dao;

import com.example.web_class.domain.User;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * 添加了@Mapper注解之后这个接口在编译时会生成相应的实现类
 *
 * 需要注意的是：这个接口中不可以定义同名的方法，因为会生成相同的id
 * 也就是说这个接口是不支持重载的
 */
@Mapper
public interface UserMapper {
//    @Select("select * from users where username=#{username} and password=#{password}")
    User selectByUsernameAndPassword(User user);
    User selectByName(User user);
    User selectAll(User user);
}
