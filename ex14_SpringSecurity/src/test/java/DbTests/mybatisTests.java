package DbTests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.app.domain.dto.UserDto;
import com.example.app.domain.mapper.MemoMapper;
import com.example.app.domain.mapper.UserMapper;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class mybatisTests {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private MemoMapper memoMapper;
	
	@Autowired
	 private UserMapper userMapper;
	
	@Test
	@Disabled
	void t1() {
		assertNotNull(sqlSessionFactory);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		assertNotNull(sqlSession);
	}
	
	@Test
	@Disabled
	void t2() {
//		memoMapper.insert(new MemoDto(1010,"a","a@naver.com",LocalDateTime.now(),null));
//		memoMapper.update(new MemoDto(1010,"aa","a@naver.com",LocalDateTime.now(),null));
//		memoMapper.delete(1);
//		System.out.println(memoMapper.selectAt(1));
		
//		List<MemoDto> list = memoMapper.selectAll();
//		list.forEach(System.out::println);
		
//		List<Map<String,Object>> list = memoMapper.selectAllResultMap(); 
//		list.forEach(System.out::println);
		
//		memoMapper.insertXml(new MemoDto(2020,"b","b@naver.com",LocalDateTime.now(),null));
		
//		List<Map<String, Object>> list = memoMapper.selectAllResultMapXml();
//		list.forEach(System.out::println);
		
//		MemoDto dto = new MemoDto(null, "a", "a@naver.com", LocalDateTime.now(),null);
//		memoMapper.insert(dto);
//		System.out.println("RESULT : " + dto);
	}
	
//	@Test
//	@Disabled
//	public void user_test() {
//		UserDto dto1 = UserDto.builder()
//				.userid("abab")
//				.username("홍길동")
//				.password("1234")
//				.build();
//		UserDto dto2 = UserDto.builder()
//				.userid("cdcd")
//				.username("남길동")
//				.password("1234")
//				.build();		
//		
//		userMapper.insert(dto1);
//		userMapper.insert(dto2);
//		dto1.setAddr1("대구");
//		userMapper.update(dto1);
//		userMapper.delete("cdcd");
//		
//		System.out.println(userMapper.selectAt("abab"));
//		
//		List<UserDto> list1 = userMapper.selectAll();
//		list1.forEach(System.out::println);
//		
//		List<Map<String,Object>>list2 =  userMapper.selectAllResultMapXml();	
//		list2.forEach(System.out::println);
//	}
	@Test
	void t3() {
		Map<String,Object> param = new HashMap();
		param.put("type", "writer");
		param.put("keyword", "TEST");
		
//		List<Map<String,Object>> response = memoMapper.Select_if_xml(param);
//		response.forEach(System.out::println);
		
		List<Map<String,Object>> response = memoMapper.Select_when_xml(param);
		response.forEach(System.out::println);
	}
}
