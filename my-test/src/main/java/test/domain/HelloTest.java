package test.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloTest {

	private Hello hello;

	@Autowired
	public HelloTest(Hello hello) {
		this.hello = hello;
	}

	public void test(){
		// 首次查询列表
		System.out.println(hello.getHelloList());
		// 再次查询列表
		System.out.println(hello.getHelloList());
		//新增数据，查询列表，查询新增数据
		hello.addHello("小朵");
		System.out.println(hello.getHelloList());
		System.out.println(hello.getHello("小朵"));
		// 删除数据，查询列表
		hello.delHello("小强");
		System.out.println(hello.getHelloList());
		// 更新数据，查询列表。查询更新数据
		hello.updateHello("小红","晓朵");
		System.out.println(hello.getHello("晓朵"));
		System.out.println(hello.getHelloList());
	}

}
