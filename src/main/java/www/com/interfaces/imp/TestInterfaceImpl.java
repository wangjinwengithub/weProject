package www.com.interfaces.imp;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class TestInterfaceImpl implements www.com.interfaces.TestInterface{

	@Override
	public String test() {
		return "dubbo连接测试";
	}

	@Override
	public String test1(String param) {
		return "dubbo连接测试"+param;
	}

}
