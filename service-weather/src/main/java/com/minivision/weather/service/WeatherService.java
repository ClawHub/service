package com.minivision.weather.service;

/**
 * <Description> 天气接口服务<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018/8/14 <br>
 */
public interface WeatherService {
    /**
     * Gets weather by city id.
     *
     * @param cityId the city id
     * @return the weather by city id
     */
    String getWeatherByCityId(String cityId);
}
