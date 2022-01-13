/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cache.interceptor;

import java.lang.reflect.Method;

/**
 * <p>缓存操作上下文。其定义了获取缓存操作、目标对象、方法和参数的接口。也就是说在SpringCache的整个过程中，都是通过该上下文来获取这些相关信息
 * <p>其在CacheInteceptor的抽象父类CacheAspectSupport中有实现
 * @see org.springframework.cache.interceptor.CacheAspectSupport.CacheOperationContext
 *
 * Representation of the context of the invocation of a cache operation.
 *
 * <p>The cache operation is static and independent of a particular invocation;
 * this interface gathers the operation and a particular invocation.
 *
 * @author Stephane Nicoll
 * @since 4.1
 * @param <O> the operation type
 */
public interface CacheOperationInvocationContext<O extends BasicOperation> {

	/**
	 * Return the cache operation.
	 */
	O getOperation();

	/**
	 * Return the target instance on which the method was invoked.
	 */
	Object getTarget();

	/**
	 * Return the method which was invoked.
	 */
	Method getMethod();

	/**
	 * Return the argument list used to invoke the method.
	 */
	Object[] getArgs();

}
