package com.adelmo.data.structure;

import java.util.Scanner;

/**
 * Created by znb on 17-4-23.
 */
public class SequenceList {
    public static void main(String[] args) {

        int i;
        SLType slType = new SLType();
        DATA pdata;
        String key;
        System.out.print("Begin\n");

        slType.SLInit(slType);
        System.out.print("Init has done!\n");

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("输入添加的结点(学号 姓名 年龄)：");
            DATA data = new DATA();
            data.key = scanner.next();
            data.name = scanner.next();
            data.age = scanner.nextInt();

            if (data.age != 0) {
                if (slType.SLAdd(slType, data) == 0) {
                    break;
                }
            } else {
                break;
            }
        } while (true);
        System.out.print("\n顺序表中的结点顺序为：\n");
        slType.SLAll(slType);

        System.out.print("\n要取出结点的序号为：\n");
        i = scanner.nextInt();
        pdata = slType.SLFindByNum(slType, i);
        if (pdata != null) {
            System.out.printf("第%d个结点为：(%s,%s,%d)\n", i, pdata.key, pdata.name, pdata.age);
        }

        System.out.print("\n要查找的结点关键字：\n");
        key = scanner.next();
        i = slType.SLFindByCont(slType, key);
        pdata = slType.SLFindByNum(slType, i);
        if (pdata != null) {
            System.out.printf("第%d个结点为：(%s,%s,%d)\n", i, pdata.key, pdata.name, pdata.age);
        }
    }
}

class DATA {
    String key;//结点关键字
    String name;
    int age;
}

class SLType {
    public static final int MAXLEN = 100;
    DATA[] ListData = new DATA[MAXLEN + 1];//保存顺序表的结构数组
    int ListLen;//顺序表以存结点的数量

    /**
     * 初始化顺序表
     *
     * @param slType
     */
    void SLInit(SLType slType) {
        slType.ListLen = 0;
    }

    /**
     * 返回顺序表的元素数量
     *
     * @param slType
     * @return
     */
    int SLLength(SLType slType) {
        return slType.ListLen;
    }

    /**
     * 插入元素
     *
     * @param slType
     * @param n
     * @param data
     * @return
     */
    int SLInsert(SLType slType, int n, DATA data) {
        if (slType.ListLen >= MAXLEN) {
            System.out.println("顺序表已满，不能插入元素！\n");
            return 0;
        }
        if (n < 1 || n > slType.ListLen - 1) {
            System.out.println("插入元素序号出错，不能插入元素！\n");
            return 0;
        }
        for (int i = slType.ListLen; i >= n; i--) {
            slType.ListData[i + 1] = slType.ListData[i];
        }
        //插入结点
        slType.ListData[n] = data;
        slType.ListLen++;
        return 1;
    }

    /**
     * 增加元素到顺序表末尾
     *
     * @param slType
     * @param data
     * @return
     */
    int SLAdd(SLType slType, DATA data) {
        if (slType.ListLen >= MAXLEN) {
            System.out.println("顺序表已满，不能插入元素!\n");
            return 0;
        }
        slType.ListData[++slType.ListLen] = data;
        return 1;
    }

    /**
     * 删除顺序表中的元素
     *
     * @param slType
     * @param n
     * @return
     */
    int SLDelete(SLType slType, int n) {
        if (n < 1 || n > slType.ListLen) {
            System.out.println("删除结点序号出错，不能删除元素！\n");
            return 0;
        }
        for (int i = n; i < slType.ListLen; i++) {
            slType.ListData[i] = slType.ListData[i + 1];
        }
        slType.ListLen--;
        return 1;
    }

    /**
     * 根据序号返回数据元素
     *
     * @param slType
     * @param n
     * @return
     */
    DATA SLFindByNum(SLType slType, int n) {
        if (n < 1 || n > slType.ListLen) {
            System.out.println("结点序号错误，不能返回结点！\n");
            return null;
        }
        return slType.ListData[n];
    }

    /**
     * 按关键字查询结点
     *
     * @param slType
     * @param key
     * @return
     */
    int SLFindByCont(SLType slType, String key) {
        for (int i = 1; i < slType.ListLen; i++) {
            if (slType.ListData[i].key.compareTo(key) == 0) {
                return i;
            }
        }
        return 0;
    }

    int SLAll(SLType slType) {
        for (int i = 1; i <= slType.ListLen; i++) {
            System.out.printf("(%s,%s,%d)\n", slType.ListData[i].key, slType.ListData[i].name, slType.ListData[i].age);
        }
        return 0;
    }
}
