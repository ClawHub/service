package com.minivision.upstream.cma;

import com.minivision.api.Tuple;
import com.minivision.api.UpstreamConfig;
import com.minivision.api.UpstreamResponse;
import com.minivision.core.http.HttpGenerator;
import com.minivision.core.http.HttpResInfo;

/**
 * <Description> 实时天气1<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018/8/29 <br>
 */
public class GetWeatherByCityId implements Tuple {

    @Override
    public UpstreamResponse call(String cityId, UpstreamConfig upstreamConfig) {
        // http://www.weather.com.cn/data/sk/101190408.html
        String url = new StringBuilder("http://www.weather.com.cn/data/sk/")
                .append(cityId)
                .append(".html")
                .toString();
        HttpResInfo httpResInfo = HttpGenerator.sendGet(url, 6000, 6000, null, false);

        return new UpstreamResponse(httpResInfo.getSuccess(), httpResInfo.getResult());
    }


}
