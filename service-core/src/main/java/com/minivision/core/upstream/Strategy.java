package com.minivision.core.upstream;

/**
 * <Description> 上游接口调用策略抽象<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018/8/29 <br>
 */
public interface Strategy {
    /**
     * 执行调用
     *
     * @param param 请求入参
     * @return 响应结果
     */
    String execute(String param);
}
