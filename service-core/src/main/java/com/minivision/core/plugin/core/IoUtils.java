package com.minivision.core.plugin.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;

/**
 * <Description> IoUtils <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018/9/4 <br>
 */
public class IoUtils {

    /**
     * The Logger.
     */
    private static Logger logger = LoggerFactory.getLogger("IoUtils");

    /**
     * Close quietly.
     *
     * @param closeable the closeable
     */
    public static void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException e) {
            logger.error("IoUtils closeQuietly fail!", e);
        }
    }
}
