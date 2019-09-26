package cn.yan.service.impl;


import cn.yan.entity.User;
import cn.yan.dao.UserMapper;
import cn.yan.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 【用户表】服务层接口实现类
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


}
