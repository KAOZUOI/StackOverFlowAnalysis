CacheManager cm = CacheManager.getInstance();Cache cache = cm.getCache(&quot;AccessTokenCache&quot;);CacheConfiguration config = cache.getCacheConfiguration();cache.put(new Element(TOKEN_CACHE_KEY, accessToken));congif.setTimeToLiveSeconds(AccessTokenResponse.getExpire() - 120);