package com.minivision.upstream.cma;

import com.minivision.api.Tuple;
import com.minivision.api.TupleConfig;
import com.minivision.api.TupleResponse;
import com.minivision.core.http.HttpGenerator;
import com.minivision.core.http.HttpResInfo;

/**
 * <Description> 实时天气2<br>
 * http://www.weather.com.cn/data/cityinfo/101190408.html
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018/9/6 <br>
 */
public class GetWeatherByCityIdV1 implements Tuple {

    @Override
    public TupleResponse call(String cityId, TupleConfig tupleConfig) {
        String url = new StringBuilder("http://www.weather.com.cn/data/cityinfo/")
                .append(cityId)
                .append(".html")
                .toString();
        HttpResInfo httpResInfo = HttpGenerator.sendGet(url, 6000, 6000, null, false);

        return new TupleResponse(httpResInfo.getSuccess(), httpResInfo.getResult());
    }


}
