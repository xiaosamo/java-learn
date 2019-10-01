package com.yuanshijia.javalearn.classname;

import com.yuanshijia.javalearn.initblock.A;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yuan
 * @date 2019/10/1
 * @description
 */
public class ObjectAnalyzer {

    /**
     * 记录已访问的对象，防止无限循环
     */
    private static ArrayList<Object> visited = new ArrayList<>();

    /**
     * 可供任意类使用的通用toString方法
     * @param obj
     * @return
     */
    public static String toString(Object obj){
        if(obj == null){
            return "null";
        }

        if (visited.contains(obj)) {
            return "...";
        }
        visited.add(obj);

        Class<?> clazz = obj.getClass();
        if (clazz == String.class) {
            // 如果是String类型，直接返回
            return (String) obj;
        }
        // 如果是数组
        if (clazz.isArray()) {
            // 获取数组类型
            String r = clazz.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) {
                    r += ",";
                }
                Object val = Array.get(obj, i);
                if (clazz.getComponentType().isPrimitive()) {
                    // 如果是基本类型
                    r += val;
                } else {
                    // 否则递归
                    r += toString(val);
                }
            }
            return r + "}";
        }

        // 获取包名
        StringBuilder result = new StringBuilder(clazz.getName());

        do {
//            if ("java.lang.Object".equals(clazz.getName())) {
//                break;
//            }
            result.append("[");
            // 获取类全部域(包括public、private)
            Field[] fields = clazz.getDeclaredFields();
            // 为反射对象设置可访问标志
            AccessibleObject.setAccessible(fields, true);
            for (Field f : fields) {
                if (!Modifier.isStatic(f.getModifiers())) {
                    if (result.lastIndexOf("[") != result.length() - 1) {
                        result.append(",");
                    }
                    result.append(f.getName()).append("=");

                    try {
                        Class<?> t = f.getType();
                        Object val = f.get(obj);
                        if (t.isPrimitive()) {
                            // 如果是基本类型
                            result.append(val);
                        } else {
                            result.append(toString(val));
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }

            result.append("]");
            clazz = clazz.getSuperclass();
        } while (clazz != null);
        return result.toString();
    }


    /**
     * 实现任意类型的数组拷贝
     * @param a 参数应声明为Object类型，不要声明为Object[]类型。整型数组类型int[] 可以转为Object，但不能转为对象数组(Object[])
     * @param newLength
     * @return
     */
    public static Object copyOf(Object a,int newLength){
        Class<?> clazz = a.getClass();
        if (!clazz.isArray()) {
            return null;
        }

        // 获取数组类型
        Class<?> componentType = clazz.getComponentType();
        int length = Array.getLength(a);
        // 构造新数组
        Object newArray = Array.newInstance(componentType, length);
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }


    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i * i);
        }

        System.out.println(toString(new Student("小花")));

        ArrayList<Article> students = new ArrayList<>();
        students.add(new Article("1", "测试文章", "测试内容", new Article.Category("1001")));
        students.add(new Article("2", "测试文章2", "测试内容2", new Article.Category("1002")));

        System.out.println(toString(students));
//        System.out.println(toString(new Article("1", "测试文章", "测试内容", new Article.Category("1001"))));


//        System.out.println(toString(new int[]{1, 2, 3, 4,5}));
//        System.out.println(toString(new Integer[]{1, 2, 3, 4,5}));


        int[] a = {1, 2, 3};
        int[] b = (int[]) copyOf(a, 10);
        b[1] = 3;

        Article[] articles = new Article[2];
        articles[0] = new Article("1", "title", "content", new Article.Category("1001"));
        articles[1] = new Article("2", "title1", "content1", new Article.Category("1002"));

        Article[] copyS = (Article[]) copyOf(articles, articles.length);

        for (Article article : copyS) {
            System.out.println(toString(article));
        }
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));
    }
}
