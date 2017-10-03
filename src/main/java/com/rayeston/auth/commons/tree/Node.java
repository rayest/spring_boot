package com.rayeston.auth.commons.tree;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dello on 2016/7/27.
 * 节点属性和EasyUI的树形结构相配
 */
@Data
public class Node implements Comparable<Node> {

    private Long id;
    private Long parentId;
    private String text;
    private String state;   //节点的状态
    private Integer order;
    private NodeAttribute nodeAttribute;
    private List<Node> children = new LinkedList<>();

    @Override
    public int compareTo(Node o) {
        if (order > o.order)
            return 1;
        if (order < o.order)
            return -1;
        return 0;
    }

    public Node(Long id, Long parentId, String text, String state, Integer order, NodeAttribute nodeAttribute) {
        this.id = id;
        this.parentId = parentId;
        this.text = text;
        this.state = state;
        this.order = order;
        this.nodeAttribute = nodeAttribute;
    }
}
