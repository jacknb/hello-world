package com.adelmo.json.test;

import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 定义一些方法
 *
 * @author root
 */
public class JsonUtils {

    /**
     * 把一个List排列为具有父子关系的list
     *
     * @param list
     * @return
     */
    public static List<TreeJson> formatTree(List<TreeJson> list) {

        TreeJson root = new TreeJson();
        TreeJson node = new TreeJson();
        // 拼凑好的json格式的数据
        List<TreeJson> treelist = new ArrayList<TreeJson>();
        // parentnodes存放所有的父节点
        List<TreeJson> parentnodes = new ArrayList<TreeJson>();

        if (list != null && list.size() > 0) {
            root = list.get(0);
            // 循环遍历oracle树查询的所有节点
            for (int i = 1; i < list.size(); i++) {
                node = list.get(i);
                if (node.getParentId().equals(root.getNodeId())) {
                    // 为tree root 增加子节点
                    parentnodes.add(node);
                    root.getChildren().add(node);
                } else {// 获取root子节点的孩子节点
                    getChildrenNodes(parentnodes, node);
                    parentnodes.add(node);
                }
            }
        }
        treelist.add(root);
        return treelist;
    }

    /**
     * 获取节点的孩子节点
     *
     * @param parentnodes
     * @param node
     */
    public static void getChildrenNodes(List<TreeJson> parentnodes, TreeJson node) {
        // 循环遍历所有父节点和node进行匹配，确定父子关系
        for (int i = parentnodes.size() - 1; i >= 0; i--) {

            TreeJson pnode = parentnodes.get(i);
            // 如果是父子关系，为父节点增加子节点，退出for循环
            if (pnode.getNodeId().equals(node.getParentId())) {
                pnode.setState("closed"); // 关闭二级树
                pnode.getChildren().add(node);
                return;
            } else {
                // 如果不是父子关系，删除父节点栈里当前的节点，
                // 继续此次循环，直到确定父子关系或不存在退出for循环
                parentnodes.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        List<TreeJson> children = new ArrayList<TreeJson>();
        children.add(new TreeJson("10011", "bbb", "bbb.jsp", "bb", "1001", "closed", true, null));
        TreeJson treeJson = new TreeJson("1001", "aaa", "aaa.jsp", "aa", "0", "open", true, children);
        List<TreeJson> parent = new ArrayList<TreeJson>();
        parent.add(treeJson);
        List<TreeJson> list = formatTree(parent);
        Iterator<TreeJson> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
        System.out.println("-----");
        JSONArray jsonArray = JSONArray.fromObject(list);
        Iterator iterator = jsonArray.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

}
