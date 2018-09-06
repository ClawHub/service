package com.minivision.core.upstream;

import com.minivision.api.Tuple;
import com.minivision.core.plugin.core.PluginManager;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * <Description> 上游调用链封装<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018 -09-06 <br>
 */
public class TupleChain {
    /**
     * The Nodes.
     */
    private Map<Integer, String> nodes;
    /**
     * The Index.
     */
    private int index;
    /**
     * The Size.
     */
    private int size;

    /**
     * Instantiates a new Tuple chain.
     *
     * @param nodes the nodes
     */
    public TupleChain(Map<Integer, String> nodes) {
        this.nodes = nodes;
        if (!CollectionUtils.isEmpty(this.nodes)) {
            index = 0;
            size = this.nodes.size();
        }
    }

    /**
     * Has next boolean.
     *
     * @return the boolean
     */
    public boolean hasNext() {
        if (index < size) {
            return true;
        }
        return false;
    }

    /**
     * Gets next.
     *
     * @return the next
     */
    public Tuple getNext() {
        String className = nodes.get(index);
        Tuple tuple = PluginManager.getPlugin(className, Tuple.class);
        index++;
        return tuple;
    }
}
