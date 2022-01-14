package test.domain;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Hello {

	static List<String> names = new ArrayList<String>(){{
		add("小红");
		add("小明");
		add("小刚");
		add("小强");
	}};

	public void sayHello(){
		System.out.println("Hello");
	}



	@Cacheable(cacheNames = "hello",key = "'get_'+#name")
	public String getHello(String name){
		System.out.println("log:getHello");
		if (name.contains(name)){
			return name;
		}else {
			return null;
		}
	}

	@Cacheable(cacheNames = "hello",key = "'list'")
	public String getHelloList(){
		System.out.println("log:getHelloList");
		return String.join(",",names);
	}

	@CacheEvict(cacheNames = "hello",key = "'list'")
	@CachePut(cacheNames = "hello",key = "'get_'+#name")
	public String addHello(String name){
		System.out.println("log:addHello");
		names.add(name);
		return name;
	}

	@Caching(evict = {
			@CacheEvict(cacheNames = "hello",key = "'get_'+#name"),
			@CacheEvict(cacheNames = "hello",key = "'list'")
	})
	public void delHello(String name){
		System.out.println("log:delHello");
		names.remove(name);
	}

	@CachePut(cacheNames = "hello",key = "'get_'+#name")
	public String updateHello(String oldName,String name){
		System.out.println("log:updateHello");
		int i = names.indexOf(oldName);
		names.set(i,name);
		return name;
	}
}
