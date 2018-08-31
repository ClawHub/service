package com.minivision.gateway.controller;

import com.minivision.gateway.base.BaseController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <Description> demo<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018 -08-17 <br>
 */
@RestController
@RequestMapping("/demo")
public class DemoController extends BaseController {


    /**
     * Index string.
     *
     * @return the string
     */
    @RequestMapping("/index")
    public String index() {
        return "Hello World";
    }

    /**
     * Post string.
     *
     * @param param the param
     * @return the string
     */
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public String post(@RequestBody String param) {
        return "post param is:" + param;
    }

    /**
     * Gets user.
     *
     * @param id the id
     * @return the user
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable(value = "id") Long id) {
        return "get id is:" + id;
    }
}
