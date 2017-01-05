package com.adelmo.json.test;

/**
 * 定义Json类
 *
 * @author Administrator
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TreeJson implements Serializable {

    /**
     * [{ "nodeName":aaa, "nodeId":"111", "url":url, ...... " children":[{
     * "nodeName":"File1", "url":url ... }] }]
     */
    private static final long serialVersionUID = 1L;

    // 节点id
    private String nodeId;
    // 节点内容
    private String nodeName;
    // 节点url
    private String url;
    // 节点url打开方式
    private String target;
    // 节点的父节点(nodeId)
    private String parentId;
    // 节点状态,'open'或者'closed',默认是'open'
    private String state = "open";
    // 指明检查节点是否选中.
    private boolean checked;

    private String moduleId;

    // 孩子节点
    private List<TreeJson> children = new ArrayList<TreeJson>();

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public List<TreeJson> getChildren() {
        return children;
    }

    public void setChildren(List<TreeJson> children) {
        this.children = children;
    }

    public TreeJson(String nodeId, String nodeName, String url, String target, String parentId, String state,
                    boolean checked, List<TreeJson> children) {
        super();
        this.nodeId = nodeId;
        this.nodeName = nodeName;
        this.url = url;
        this.target = target;
        this.parentId = parentId;
        this.state = state;
        this.checked = checked;
        this.children = children;
    }


    @Override
    public String toString() {
        return "TreeJson [nodeId=" + nodeId + ", nodeName=" + nodeName
                + ", url=" + url + ", target=" + target + ", parentId="
                + parentId + ", state=" + state + ", checked=" + checked
                + ", moduleId=" + moduleId + ", children=" + children + "]";
    }

    public TreeJson() {
        // TODO Auto-generated constructor stub
    }
}
