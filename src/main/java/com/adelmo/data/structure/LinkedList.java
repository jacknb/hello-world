package com.adelmo.data.structure;

import org.apache.commons.lang.Validate;

/**
 * Created by znb on 17-5-3.
 */
public class LinkedList {
    public static void main(String[] args) {

    }
}

class DATA2 {
    String key;
    String name;
    int age;
}

class CLType {
    DATA2 nodeData = new DATA2();
    CLType nextNode;


    /**
     * 追加结点
     *
     * @param head
     * @param nodeData
     * @return
     */
    CLType CLAddEnd(CLType head, DATA2 nodeData) {
        CLType node, htemp;
        if ((node = new CLType()) == null) {
            System.out.println("申请内存失败！\n");
            return null;
        }
        node.nodeData = nodeData;
        node.nextNode = null;
        if (head == null) {
            head = node;
            return head;
        }
        htemp = head;
        while (htemp.nextNode != null) {
            htemp = htemp.nextNode;
        }
        htemp.nextNode = node;
        return head;
    }

    /**
     * 从头结点插入
     *
     * @param head
     * @param nodeData
     * @return
     */
    CLType CLAddFirst(CLType head, DATA2 nodeData) {
        CLType node, htemp;
        if ((node = new CLType()) == null) {
            System.out.println("申请内存失败！\n");
            return null;
        }
        node.nodeData = nodeData;//保存数据
        node.nextNode = head;//指向头引用所指向结点
        head = node;//头引用指向新增结点
        return head;
    }

    /**
     * 查找结点
     *
     * @param head
     * @param key
     * @return
     */
    CLType CLFindNode(CLType head, String key) {
        CLType htemp;
        htemp = head;
        Validate.notNull(key, "key should not null!");
        while (htemp != null) {
            if (htemp.nodeData.key.compareTo(key) == 0) {
                return htemp;
            }
            htemp = htemp.nextNode;
        }
        return null;
    }

    /**
     * 插入结点
     *
     * @param head
     * @param findKey
     * @param nodeData
     * @return
     */
    CLType CLInsertNode(CLType head, String findKey, DATA2 nodeData) {
        CLType node, nodetemp;
        if ((node = new CLType()) == null) {
            System.out.println("申请内存失败！\n");
            return null;
        }
        node.nodeData = nodeData;
        nodetemp = CLFindNode(head, findKey);
        if (nodetemp == null) {
            System.out.print("未找到正确的位置！\n");
        } else {
            node.nextNode = nodetemp.nextNode;
            nodetemp.nextNode = node;
        }
        return head;
    }

    /**
     * 删除结点
     *
     * @param head
     * @param key
     * @return
     */
    int CLDeleteNode(CLType head, String key) {
        CLType node, htemp;
        htemp = head;
        node = head;
        Validate.notNull(key, "key should not be null!");
        while (htemp != null) {
            if (htemp.nodeData.key.compareTo(key) == 0) {
                node.nextNode = htemp.nextNode;//
                htemp = null;
                return 1;
            } else {
                node = htemp;
                htemp = htemp.nextNode;
            }
        }
        return 0;
    }

    /**
     * 计算链表长度
     *
     * @param head
     * @return
     */
    int CLLength(CLType head) {
        CLType htemp;
        int len = 0;
        htemp = head;
        while (htemp != null) {
            len++;
            htemp = htemp.nextNode;
        }
        return len;
    }

    /**
     * 遍历链表
     *
     * @param head
     */
    void CLAllNode(CLType head) {
        CLType htemp;
        DATA2 nodeData;
        htemp = head;
        System.out.printf("当前链表共有%d个结点。链表所有数据如下：\n", CLLength(head));
        while (htemp != null) {
            nodeData = htemp.nodeData;
            System.out.printf("结点(%s,%s,%d)\n", nodeData.key, nodeData.name, nodeData.age);
            htemp = htemp.nextNode;
        }
    }

}

