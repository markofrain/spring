

package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.config.AppConfig;
import test.domain.Hello;
import test.domain.HelloTest;

public class App {
	public static void main(String[] args) {
//		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//		Hello hello = (Hello)ac.getBean("hello");
//		hello.sayHello();
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("test.**");
		ctx.register(AppConfig.class);

//		Hello hello = ctx.getBean("hello", Hello.class);
//		hello.sayHello();

		HelloTest helloTest = ctx.getBean("helloTest", HelloTest.class);
		helloTest.test();
		ctx.close();
	}
}
