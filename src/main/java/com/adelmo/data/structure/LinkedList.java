package com.adelmo.data.structure;

import org.apache.commons.lang.Validate;

import java.util.Scanner;
/**
 * Created by znb on 17-5-3.
 */


/**
 * Created by znb on 17-4-23.
 */
public class LinkedList {

    public static void main(String[] args) {
        CLType node, head = null;
        CLType clType = new CLType();
        String key, findKey;
        Scanner scanner = new Scanner(System.in);
        System.out.printf("链表测试。输入数据格式为:关键字 姓名 年龄\n");
        do {
            DATA2 nodeData = new DATA2();
            nodeData.key = scanner.next();
            if (nodeData.key.equals("0")) {
                break;
            }
            nodeData.name = scanner.next();
            nodeData.age = scanner.nextInt();
            head = clType.CLAddEnd(head, nodeData);//在链表尾部添加结点
        } while (true);
        clType.CLAllNode(head);//显示所有结点

        System.out.printf("\n输入插入结点位置的关键字：\n");
        findKey = scanner.next();
        System.out.printf("输入插入结点的数据(关键字 姓名 年龄)：");
        DATA2 nodeData = new DATA2();
        nodeData.key = scanner.next();
        nodeData.name = scanner.next();
        nodeData.age = scanner.nextInt();

        head = clType.CLInsertNode(head, findKey, nodeData);//插入结点
        clType.CLAllNode(head);//显示所有结点

        System.out.println("输入要删除的关键字：");
        key = scanner.next();

        clType.CLDeleteNode(head, key);
        clType.CLAllNode(head);

        System.out.printf("\n输入要查找的关键字：\n");
        key = scanner.next();
        node = clType.CLFindNode(head, key);
        if (node != null) {
            nodeData = node.nodeData;
            System.out.printf("关键字%s对应的结点为(%s %s %d)\n", key, nodeData.key, nodeData.name, nodeData.age);
        } else {
            System.out.printf("未找到关键字%s对应的结点！", key);
        }
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
     * 在链表尾处追加结点
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
     * 插入头结点
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
        if ((node = new CLType()) == null) {
            System.out.println("申请内存空间失败！");
            return null;
        }

        //保存数据
        node.nodeData = nodeData;
        node.nextNode = head;
        head = node;
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
            System.out.println("申请内存失败!");
            return null;
        }
        node.nodeData = nodeData;//保存结点中的数据

        nodetemp = CLFindNode(head, findKey);
        if (nodetemp != null) {
            node.nextNode = nodetemp.nextNode;
            nodetemp.nextNode = node;
        } else {
            System.out.println("未找到要插入的结点位置!");
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
        Validate.notNull(key, "key should not be null!");
        CLType node, htemp;//node用来保存需要删除的结点
        htemp = head;
        node = head;
        while (htemp != null) {
            if (htemp.nodeData.key.compareTo(key) == 0) {
                node.nextNode = htemp.nextNode;
                return 1;
            } else {
                node = htemp;//指向当前结点
                htemp = htemp.nextNode;//指向下一个结点
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
