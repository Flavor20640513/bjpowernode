package com.bjpowernode.util;

/**
 * 目的：确保在工程运行期间，ThreadLocal对象只有一个
 * 行业标准规则:
 *   第一步: 将指定类作为私有静态属性声明
 *   第二步: 通过静态语句块完成属性初始化
 */
public class ThreadUtil {

    private static  ThreadLocal tl; //此处static有什么用，tl对象活的久一些。

    static{
        tl = new ThreadLocal();
    }

    public static void set(Object data){
        tl.set(data);
    }

    public static Object get(){
        return tl.get();
    }
}
