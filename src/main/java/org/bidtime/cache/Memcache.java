package org.bidtime.cache;

import org.bidtime.cache.AbstractCache;

import net.spy.memcached.MemcachedClient;

/**
 * 
 * jss
 */
public class Memcache extends AbstractCache {
	
	private MemcachedClient memcacheClient;
	
  @Override
	public void set(String key, int seconds, Object o) throws Exception {
		memcacheClient.set(key, seconds, o);
	}
	
  @Override
	public void delete(String key) throws Exception {
		memcacheClient.delete(key);
	}
	
  @Override
	public void replace(String key, int seconds, Object o) throws Exception {
		memcacheClient.replace(key, seconds, o);
	}
	
	@Override
	public Object get(String key, boolean del) throws Exception {
		Object o = memcacheClient.get(key);
		if (del) {
		  this.delete(key);
		}
		return o;
	}
	
  @Override
  public String getString(String key, boolean del) throws Exception {
    String val = String.valueOf(memcacheClient.get(key));
    if (del) {
      delete(key);
    }
    return val;
  }
  
  @Override
  public void setString(String key, int seconds, String s) throws Exception {
    memcacheClient.set(key, seconds, s);
  }

}
