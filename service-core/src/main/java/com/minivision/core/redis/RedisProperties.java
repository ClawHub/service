package com.minivision.core.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <Description>redis config <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018 -08-18 <br>
 */
@Component
@ConfigurationProperties(prefix = "redis")
public class RedisProperties {
    /**
     * The Nodes.
     */
    private String nodes;

    /**
     * The Connection timeout.
     */
    private int connectionTimeout;

    /**
     * The So timeout.
     */
    private int soTimeout;

    /**
     * The Max attempts.
     */
    private int maxAttempts;

    /**
     * The Password.
     */
    private String password;

    /**
     * The Pool config.
     */
    private GenericObjectPoolConfig poolConfig;

    /**
     * Gets connection timeout.
     *
     * @return the connection timeout
     */
    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    /**
     * Sets connection timeout.
     *
     * @param connectionTimeout the connection timeout
     */
    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    /**
     * Gets so timeout.
     *
     * @return the so timeout
     */
    public int getSoTimeout() {
        return soTimeout;
    }

    /**
     * Sets so timeout.
     *
     * @param soTimeout the so timeout
     */
    public void setSoTimeout(int soTimeout) {
        this.soTimeout = soTimeout;
    }

    /**
     * Gets max attempts.
     *
     * @return the max attempts
     */
    public int getMaxAttempts() {
        return maxAttempts;
    }

    /**
     * Sets max attempts.
     *
     * @param maxAttempts the max attempts
     */
    public void setMaxAttempts(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets pool config.
     *
     * @return the pool config
     */
    public GenericObjectPoolConfig getPoolConfig() {
        return poolConfig;
    }

    /**
     * Sets pool config.
     *
     * @param poolConfig the pool config
     */
    public void setPoolConfig(GenericObjectPoolConfig poolConfig) {
        this.poolConfig = poolConfig;
    }

    /**
     * Gets nodes.
     *
     * @return the nodes
     */
    public String getNodes() {
        return nodes;
    }

    /**
     * Sets nodes.
     *
     * @param nodes the nodes
     */
    public void setNodes(String nodes) {
        this.nodes = nodes;
    }

}
