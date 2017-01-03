package com.abc.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EhCacheTestServiceImpl implements EhCacheTestService {

//	这里注解中value=”cacheTest”与ehcache-setting.xml中的cache名称属性值一致
	@Cacheable(value="cacheTest",key="#param")
    public String getTimestamp(String param) {
        Long timestamp = System.currentTimeMillis();
        return timestamp.toString();
    }

}
