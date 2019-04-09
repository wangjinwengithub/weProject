package www.com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;

import www.com.entity.Employee;
import www.com.entity.EmployeeMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootStartApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	private EmployeeMapper emp;
	
	@Test
	public void testMybatis() {
		Employee e=emp.getById(1);
		System.out.println(JSON.toJSON(e));
	}

}
