package com.example.app.domain.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.app.domain.dto.UserDto;

@Mapper
public interface UserMapper {
	
	//@SelectKey(statement="select max(id)+1 from tbl_memo",keyProperty = "id",before = false, resultType = int.class)
	@Insert(value = "insert into tbl_user values(#{userid},#{username},#{password},#{addr1})")
	public int insert(UserDto userDto);
	
	@Update("update tbl_user set addr1=#{addr1} where userid=#{userid}")
	public int update(UserDto userDto);
	
	@Delete("delete from tbl_user where userid=#{userid}")
	public int delete(String userid);
	
	@Select("select * from tbl_user where userid=#{userid}")
	public UserDto selectAt(String userid);
	
	@Select("select * from tbl_user")
	public List<UserDto> selectAll();
	 
	@Select("select * from tbl_user")
	public List<Map<String,Object>> selectAllResultMap();
	
	// Xml
	public int insertXml(UserDto userDto);
	public int updateXml(UserDto userDto);
	public int deleteXml(String userid);
	public UserDto selectAtXml(String userid);
	public List<UserDto> selectAllXml();
	public List<Map<String, Object>> selectAllResultMapXml();
	
}
