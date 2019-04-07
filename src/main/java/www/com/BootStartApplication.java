package www.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
/** 现在还没有配置数据源，加上该注解，让spring先不加载数据源**/
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class BootStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootStartApplication.class, args);
	}

}
