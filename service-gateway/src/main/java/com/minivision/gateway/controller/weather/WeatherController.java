package com.minivision.gateway.controller.weather;

import com.alibaba.dubbo.config.annotation.Reference;
import com.minivision.gateway.base.BaseController;
import com.minivision.weather.WeatherFacade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <Description> 天气服务<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018/8/14 <br>
 */
@RestController
@RequestMapping("/weather")
public class WeatherController extends BaseController {

    /**
     * The Weather facade.
     */
    @Reference
    private WeatherFacade weatherFacade;


    @RequestMapping("/getWeatherByCityId")
    public String getWeatherByCityId() {

        return weatherFacade.getWeatherByCityId("101190408");
    }
}
