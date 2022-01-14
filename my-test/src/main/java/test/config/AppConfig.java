package test.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheFactoryBean;
import org.springframework.cache.interceptor.CacheAspectSupport;
import org.springframework.cache.interceptor.CacheInterceptor;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.SimpleCacheResolver;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@EnableCaching
@Configuration
public class AppConfig extends CachingConfigurerSupport {

	public static ConcurrentMap<Object,Object> map = new ConcurrentHashMap<>(10);

	@Override
	@Bean
	public CacheManager cacheManager(){
		SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
		ConcurrentMapCacheFactoryBean factoryBean = new ConcurrentMapCacheFactoryBean();
		factoryBean.setName("hello");
		factoryBean.setStore(map);
		factoryBean.setAllowNullValues(false);
		factoryBean.afterPropertiesSet();
		simpleCacheManager.setCaches(Collections.singletonList(factoryBean.getObject()));
		return simpleCacheManager;
	}


//	@Bean
//	public Hello hello(){
//		return new Hello();
//	}

//	@Bean
//	public HelloTest helloTest(Hello hello){
//		HelloTest helloTest = new HelloTest(hello);
//		return helloTest;
//	}


}
