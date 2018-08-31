package com.minivision.core.redis;

import io.dubbo.springboot.DubboProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <Description> redis操作<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018/8/17 <br>
 */
@Component
@EnableConfigurationProperties(DubboProperties.class)
public class RedisClusterClient {

    /**
     * 一天的秒数
     */
    public static final int ONE_DAY = 86400;

    /**
     * The Redis properties.
     */
    @Autowired
    private RedisProperties redisProperties;

    /**
     * The Jedis cluster.
     */
    private JedisCluster jedisCluster;

    /**
     * Init.
     */
    @PostConstruct
    public void init() {
        jedisCluster = new JedisCluster(getJedisClusterNode(), redisProperties.getConnectionTimeout(),
                redisProperties.getSoTimeout(),
                redisProperties.getMaxAttempts(), redisProperties.getPassword(), redisProperties.getPoolConfig());
    }

    /**
     * Gets jedis cluster node.
     *
     * @return the jedis cluster node
     */
    private Set<HostAndPort> getJedisClusterNode() {
        String nodes = redisProperties.getNodes();
        if (StringUtils.isBlank(nodes)) {
            return Collections.emptySet();
        }
        String[] nodeArray = nodes.split(",");
        if (nodeArray.length < 1) {
            return Collections.emptySet();
        }

        Set<HostAndPort> hostAndPorts = new HashSet<>();
        HostAndPort hostAndPort;
        String[] ipPort;
        for (String node : nodeArray) {
            ipPort = node.split(":");
            if (ipPort.length < 1) {
                continue;
            }
            hostAndPort = new HostAndPort(ipPort[0], Integer.parseInt(ipPort[1]));
            hostAndPorts.add(hostAndPort);
        }
        return hostAndPorts;
    }

    /**
     * Hset long.
     *
     * @param key the key
     * @param field the field
     * @param value the value
     * @return the long
     */
    public Long hset(String key, String field, String value) {
        return jedisCluster.hset(key, field, value);
    }

    /**
     * Expire long.
     *
     * @param key the key
     * @param seconds the seconds
     * @return the long
     */
    public Long expire(String key, int seconds) {
        return jedisCluster.expire(key, seconds);
    }

    /**
     * Hget string.
     *
     * @param key the key
     * @param field the field
     * @return the string
     */
    public String hget(String key, String field) {
        return jedisCluster.hget(key, field);
    }

    /**
     * Hget all map.
     *
     * @param key the key
     * @return the map
     */
    public Map<String, String> hgetAll(String key) {
        return jedisCluster.hgetAll(key);
    }

}
