package www.com.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import www.com.entity.Employee;
import www.com.entity.EmployeeMapper;
import www.com.entity.User;

@Api(value = "FastJson测试", tags = { "测试接口" })
@Controller
@RequestMapping("freemark")
//跨域请求，注解和配置选其一即可
//@CrossOrigin(origins="http://localhost:8088")
public class FreeMarkController {

	@Autowired
	private EmployeeMapper emp;
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello(Map<String,String> map) {
		map.put("hello", "你好！");
		return "hello";
	}
	@RequestMapping("/hello2")
	public String hello2(Map<String,String> map) {
		map.put("hello", "你好！");
		return "/hell";
	}
	
	@ApiOperation("获取用户信息")
	@ApiImplicitParam(name = "name", value = "用户名", dataType = "string", paramType = "query")
	@RequestMapping("/user/{name}")
	@ResponseBody
	public User getUserInfo(@PathVariable("name") String name) {
		User u=new User();
		u.setBirthday(new Date());
		u.setId(1);
		u.setPassword("123456789");
		u.setUsername(name);
		return u;
	}
	
	@ApiOperation("测试mybatis")
	@RequestMapping("/employee")
	@ResponseBody
	public Employee queryEmployee() {
		return emp.getById(1);
	}
}
