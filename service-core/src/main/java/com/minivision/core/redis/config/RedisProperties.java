package com.minivision.core.redis.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <Description> <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018 -09-06 <br>
 */
@Component
@ConfigurationProperties(prefix = "redis.cache", ignoreUnknownFields = true)
public class RedisProperties {
    /**
     * The Pool config.
     */
    private GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
    /**
     * The Host.
     */
    private String host = "localhost";
    /**
     * The Port.
     */
    private int port = 6379;
    /**
     * The So timeout.
     */
    private int soTimeout;
    /**
     * The Connection timeout.
     */
    private int connectionTimeout;
    /**
     * The Password.
     */
    private String password;
    /**
     * The Database.
     */
    private int database = 0;
    /**
     * The Max attempts.
     */
    private int maxAttempts = 5;
    /**
     * The Connect string.
     */
    private String connectString;

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
     * Gets host.
     *
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * Sets host.
     *
     * @param host the host
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Gets port.
     *
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * Sets port.
     *
     * @param port the port
     */
    public void setPort(int port) {
        this.port = port;
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
     * Gets database.
     *
     * @return the database
     */
    public int getDatabase() {
        return database;
    }

    /**
     * Sets database.
     *
     * @param database the database
     */
    public void setDatabase(int database) {
        this.database = database;
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
     * Gets connect string.
     *
     * @return the connect string
     */
    public String getConnectString() {
        return connectString;
    }

    /**
     * Sets connect string.
     *
     * @param connectString the connect string
     */
    public void setConnectString(String connectString) {
        this.connectString = connectString;
    }
}
