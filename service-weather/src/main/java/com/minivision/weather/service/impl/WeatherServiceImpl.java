package com.minivision.weather.service.impl;

import com.minivision.core.upstream.StrategyFactory;
import com.minivision.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <Description> 天气接口服务实现<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018/8/14 <br>
 */
@Service
public class WeatherServiceImpl implements WeatherService {

    @Override
    public String getWeatherByCityId(String cityId) {
        return StrategyFactory.getStrategy("getWeatherByCityId").execute(cityId);
    }
}
