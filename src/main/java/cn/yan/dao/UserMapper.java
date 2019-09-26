package cn.yan.dao;


import cn.yan.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 【用户表】数据层接口
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

	@Select("select * from user where id = #{id}")
	User getById(@Param("id") Long id);

	User getXmlById(@Param("id") Long id);

}
