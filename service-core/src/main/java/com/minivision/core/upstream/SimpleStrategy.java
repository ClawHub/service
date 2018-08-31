package com.minivision.core.upstream;

import java.util.List;

/**
 * <Description> 抽象策略<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018/8/29 <br>
 */
public class SimpleStrategy implements Strategy {
    private TupleChain tupleChain;

    public SimpleStrategy(TupleChain tupleChain) {
        this.tupleChain = tupleChain;
    }

    @Override
    public String execute(String param) {
        //调用上游
        while (tupleChain.hasNext()) {
            Tuple tuple = tupleChain.getNext();
            UpstreamConfig upstreamConfig = getUpstreamConfigByTuple(tuple);
            UpstreamResponse upstreamResponse = tuple.call(param, upstreamConfig);
            if (upstreamResponse.isSuccess()) {
                return upstreamResponse.getResult();
            }
        }
        return null;
    }

    private UpstreamConfig getUpstreamConfigByTuple(Tuple tuple) {
        return null;
    }


}
