package com.cloudin.admin.support.shiro;

import com.google.common.cache.CacheBuilder;
import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 基于 guava cache 的 授权信息缓存管理器
 *
 * @author 小天
 * @version 1.0.0, 2018/6/27 0027 16:18
 */
public class GuavaCacheManager extends AbstractCacheManager {
	
	/**
	 * 缓存最大数量
	 */
	private int cacheMaxSize         = 100;
	/**
	 * 初始缓存容量
	 */
	private int cacheInitialCapacity = 50;
	/**
	 * 距离最后一次访问的过期时间，单位：秒
	 */
	private int expireAfterAccess    = 10 * 60;
	
	public void setCacheMaxSize(int cacheMaxSize) {
		this.cacheMaxSize = cacheMaxSize;
	}
	
	public void setCacheInitialCapacity(int cacheInitialCapacity) {
		this.cacheInitialCapacity = cacheInitialCapacity;
	}
	
	public void setExpireAfterAccess(int expireAfterAccess) {
		this.expireAfterAccess = expireAfterAccess;
	}
	
	@Override
	protected Cache createCache(String s) throws CacheException {
		com.google.common.cache.Cache cache = CacheBuilder.newBuilder().initialCapacity(cacheInitialCapacity)
			.maximumSize(cacheMaxSize).expireAfterAccess(expireAfterAccess, TimeUnit.SECONDS).build();
		return new GuavaCache(cache);
	}
	
	class GuavaCache implements org.apache.shiro.cache.Cache {
		
		private com.google.common.cache.Cache cache;
		
		public GuavaCache(com.google.common.cache.Cache cache) {
			this.cache = cache;
		}
		
		@Override
		public Object get(Object o) throws CacheException {
			return cache.getIfPresent(o);
		}
		
		@Override
		public Object put(Object o, Object o2) throws CacheException {
			return cache.asMap().put(o, o2);
		}
		
		@Override
		public Object remove(Object o) throws CacheException {
			return cache.asMap().remove(o);
		}
		
		@Override
		public void clear() throws CacheException {
			cache.cleanUp();
		}
		
		@Override
		public int size() {
			return (int) cache.size();
		}
		
		@Override
		public Set keys() {
			return cache.asMap().keySet();
		}
		
		@Override
		public Collection values() {
			return cache.asMap().values();
		}
	}
}
