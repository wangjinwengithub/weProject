package www.com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Configuration {

	@Bean
	public Docket accessToken() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("api")// 定义组
			    .select() // 选择那些路径和 api 会生成 document
			    .apis(RequestHandlerSelectors.basePackage("www.com.controller")) // 拦截的包路径
			    .paths(PathSelectors.regex("/freemark/.*"))// 拦截的接口路径
			    .build() // 创建
			    .apiInfo(apiInfo()); // 配置说明
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()//
				.title("spring-boot-test-api")// 标题
				.description("swagger2测试专用")// 描述
				.termsOfServiceUrl("www.baidu.com")//
				.contact(new Contact("moonlightL", "www.taobao.com", "1510712025@qq.com"))// 联系
				.version("1.0")// 版本
				.build();
	}
}
