package com.minivision.weather.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.minivision.weather.WeatherFacade;
import com.minivision.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <Description> 天气接口实现<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018/8/14 <br>
 */
@Service
public class WeatherFacadeImpl implements WeatherFacade {

    /**
     * The Weather service.
     */
    @Autowired
    private WeatherService weatherService;

    @Override
    public String getWeatherByCityId(String cityId) {
        return weatherService.getWeatherByCityId(cityId);
    }
}
