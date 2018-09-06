package com.minivision.core.upstream;

import com.alibaba.fastjson.JSONObject;
import com.minivision.api.Tuple;
import com.minivision.api.UpstreamConfig;
import com.minivision.api.UpstreamResponse;
import com.minivision.core.redis.core.RedisTemplate;

/**
 * <Description> 抽象策略<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018/8/29 <br>
 */
public class SimpleStrategy implements Strategy {
    /**
     * 数据源调用链
     */
    private TupleChain tupleChain;
    /**
     * The Redis template.
     */
    private RedisTemplate redisTemplate;


    /**
     * Instantiates a new Simple strategy.
     *
     * @param tupleChain    the tuple chain
     * @param redisTemplate the redis template
     */
    public SimpleStrategy(TupleChain tupleChain, RedisTemplate redisTemplate) {
        this.tupleChain = tupleChain;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public String execute(String param) {
        //调用上游
        while (tupleChain.hasNext()) {
            Tuple tuple = tupleChain.getNext();
            UpstreamConfig upstreamConfig = getUpstreamConfigByTuple(tuple);
            //执行调用
            UpstreamResponse upstreamResponse = tuple.call(param, upstreamConfig);
            if (upstreamResponse.isSuccess()) {
                return upstreamResponse.getResult();
            }
        }
        return null;
    }

    /**
     * 获取上游地址等配置信息
     *
     * @param tuple 上游调用单元
     * @return 配置
     */
    private UpstreamConfig getUpstreamConfigByTuple(Tuple tuple) {
        return JSONObject.parseObject(redisTemplate.get(tuple.getClass().getName()), UpstreamConfig.class);
    }

}
