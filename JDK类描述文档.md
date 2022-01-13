## 注释

### @Inherited
```java
/**
 * @author  Joshua Bloch
 * @since 1.5
 * @jls 9.6.4.3 @Inherited
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Inherited {
}
```
标识 自动继承注释。

如果在注解类上声明了这个注解。那么用户在某个类上查找某个注解，而没有找到的话，会从该类的超类上自动查找。
会一直重复查找，知道知道，并一直到Object超类。如果还没找到就是没找到。

这个注解只会导致注解从超类继承;对已实现接口的注解没有任何作用。

## 词语含义

enclosing classes
封闭类（外围类） 类似静态内部类
