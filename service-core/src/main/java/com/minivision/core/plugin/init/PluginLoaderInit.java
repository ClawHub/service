package com.minivision.core.plugin.init;

import com.minivision.core.plugin.core.PluginClassLoader;
import com.minivision.core.plugin.core.PluginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * <Description> 类加载器初始化，并加载basePath下的jar包<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018/9/5 <br>
 */
@Component
public class PluginLoaderInit {
    /**
     * The Logger.
     */
    private static Logger logger = LoggerFactory.getLogger("PluginLoaderInit");

    /**
     * Init.
     */
    @PostConstruct
    public void init() {
        logger.info("============PLUGIN INIT BEGIN===================");
        //初始化插件管理器，并加载basePath下的jar
        PluginManager.setPluginClassLoader(new PluginClassLoader("F:\\tmp\\plugin"));
        logger.info("============PLUGIN INIT END===================");
    }
}
