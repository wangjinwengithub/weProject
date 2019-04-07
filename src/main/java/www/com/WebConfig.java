package www.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import www.com.interceptor.InterceptorTest;
import www.com.listener.ListenerTest;
import www.com.servlet.ServletTest;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

	/**配置fastJSON**/
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		
		fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
		
		HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
		
		return new HttpMessageConverters(converter);
	}
	
	/**注册servlet**/
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
	    return new ServletRegistrationBean(new ServletTest(),"/servletTest");
	}
	
	/**注册过滤器（自定义过滤器可直接用注解注册@Component）这里一般用来注册第三方过滤器**/
	/*@Bean
	public FilterRegistrationBean timeFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		
		FilterTest timeFilter = new FilterTest();
		registrationBean.setFilter(timeFilter);
		
		List<String> urls = new ArrayList<>();
		urls.add("/*");
		registrationBean.setUrlPatterns(urls);
		
		return registrationBean;
	}*/
	
	/**注册监听器**/
	@Bean
	public ServletListenerRegistrationBean<ListenerTest> servletListenerRegistrationBean() {
	    return new ServletListenerRegistrationBean<ListenerTest>(new ListenerTest());
	}

	/**
	 * 注册拦截器
	 */
	@Autowired
	private InterceptorTest interceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor);
	}

	/**
	 * 配置允许跨域请求
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/freemark/**").allowedOrigins("http://localhost:8088");
	}
	
	
	
	
}
