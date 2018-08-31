package com.minivision.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * <Description>网关服务启动 <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018 -08-14 <br>
 */
@SpringBootApplication
public class GatewayApp {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext confApp = null;
        try {
            confApp = SpringApplication.run(GatewayApp.class, args);
        } finally {
            close(confApp);
        }
    }

    /**
     * Close.
     *
     * @param confApp the conf app
     */
    private static void close(ConfigurableApplicationContext confApp) {

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (confApp != null) {
                confApp.close();
            }
        }));
    }
}
