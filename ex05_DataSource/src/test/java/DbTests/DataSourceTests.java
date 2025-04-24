package DbTests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

import javax.sql.DataSource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.app.domain.dao.MemoDaoImpl;
import com.example.app.domain.dto.MemoDto;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
class DataSourceTests {

	@Autowired
	private DataSource dataSource1;
	
	@Autowired
	private MemoDaoImpl memoDaoImpl;
	
	@Test
	@Disabled
	void test() throws Exception{
		System.out.println(dataSource1);
		Connection con = dataSource1.getConnection();
		PreparedStatement pstmt = con.prepareStatement("insert into tbl_book values('abcd','abcd','abcd','abcd')");
		pstmt.executeUpdate();
	}
	@Test
	void test2() throws Exception{
		memoDaoImpl.insert(new MemoDto(1,"a","a",LocalDateTime.now(),null));
	}

}
