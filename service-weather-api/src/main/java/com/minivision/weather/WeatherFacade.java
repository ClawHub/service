package com.minivision.weather;

/**
 * <Description> 天气接口<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018/8/14 <br>
 */
public interface WeatherFacade {
    /**
     * Gets weather by city id.
     *
     * @param cityId the city id
     * @return the weather by city id
     */
    String getWeatherByCityId(String cityId);
}
