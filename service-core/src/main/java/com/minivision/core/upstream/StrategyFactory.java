package com.minivision.core.upstream;

import com.minivision.core.redis.core.RedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * <Description> 策略工厂抽象<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018/8/29 <br>
 */
@Component
public class StrategyFactory {

    /**
     * The Redis template.
     */
    @Autowired
    private RedisTemplate redisTemplateAuto;

    /**
     * The constant redisTemplate.
     */
    private static RedisTemplate redisTemplate;

    /**
     * Init.
     */
    @PostConstruct
    public void init() {
        redisTemplate = redisTemplateAuto;
    }

    /**
     * 根据服务名获取策略
     *
     * @param serviceName the service name
     * @return the strategy
     */
    public static Strategy getStrategy(String serviceName) {
        //根据服务名获取策略ID
        String strategyId = getStrategyIdByServiceName(serviceName);
        //获取上游调用链
        TupleChain tupleChain = getTupleChain(strategyId);
        return new SimpleStrategy(tupleChain, redisTemplate);
    }

    /**
     * 根据服务名获取策略ID
     *
     * @param serviceName 服务名
     * @return 策略ID
     */
    private static String getStrategyIdByServiceName(String serviceName) {
        String redisKey = "service:strategy-id:" + serviceName;
        return redisTemplate.get(redisKey);
    }

    /**
     * 根据策略ID获取上游调用链
     *
     * @param strategyId 策略ID
     * @return 上游调用链
     */
    private static TupleChain getTupleChain(String strategyId) {
        String redisKey = "service:tuple-chain:" + strategyId;
        //key:权重 0最优先，val：上游className
//        Map<String, String> nodes = redisTemplate.hgetAll(redisKey);
        Map<Integer, String> nodes = new HashMap<>();
        nodes.put(0, "com.minivision.upstream.cma.GetWeatherByCityId");
        nodes.put(1, "com.minivision.upstream.cma.GetWeatherByCityIdV1");
        return new TupleChain(nodes);
    }
}
