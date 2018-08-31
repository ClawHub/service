package com.minivision.core.upstream;

/**
 * <Description> 上游接口抽象<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018/8/29 <br>
 */
public interface Tuple {
    /**
     * 调用上游
     *
     * @param param          调用参数
     * @param upstreamConfig 配置
     * @return 结果封装
     */
    UpstreamResponse call(String param, UpstreamConfig upstreamConfig);
}
