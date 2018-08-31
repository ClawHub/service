package com.minivision.core.upstream;

/**
 * <Description> 策略工厂抽象<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018/8/29 <br>
 */
public class StrategyFactory {
    //根据服务名获取策略
    public static Strategy getStrategy(String serviceName) {
        //根据服务名获取策略ID
        String strategyId = getStrategyIdByServiceName(serviceName);
        //获取上游调用链
        TupleChain tupleChain = getTupleChain(strategyId);
        return new SimpleStrategy(tupleChain);
    }

    /**
     * 根据服务名获取策略ID
     *
     * @param serviceName 服务名
     * @return 策略ID
     */
    private static String getStrategyIdByServiceName(String serviceName) {
        //根据服务名获取策略id
        //redis获取
        return "";
    }

    /**
     * 根据策略ID获取上游调用链
     *
     * @param strategyId 策略ID
     * @return 上游调用链
     */
    private static TupleChain getTupleChain(String strategyId) {
        return null;
    }
}
