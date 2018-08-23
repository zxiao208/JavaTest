package collection;

import java.util.*;

public class ListTest {
    public static void main(String[] args) {

        //ArrayList集合collection
        Collection collection = new ArrayList<String>();
        collection.add(1);
        collection.add(2);

        //ArrayList集合list
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b"); //将指定的元素添加到此列表的尾部
        list.add("c");
        list.add(1, "d"); //在元素第二个位置插入
        list.addAll(collection); //按照指定 collection 的迭代器所返回的元素顺序，将该 collection 中的所有元素添加到此列表的尾部。
        list.addAll(1, collection); //从指定的位置开始，将指定 collection 中的所有元素插入到此列表中。


        //打印ArrayList的长度
        System.out.println("集合的长度： " + list.size());

        //遍历方法  Iterator迭代器
        Iterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            System.out.println("iterator:"+iterator.next());
        }

        iterator.remove(); //该操作会删除list中的所有元素
        //遍历方法  ListIterator迭代器继承Iterator迭代器
        ListIterator<String> listiterator = list.listIterator();//List的实现的特有迭代器接口ListIterator，双向访问，允许元素插入替换，提供方法从指定位置迭代
        listiterator.add("e");
        while (listiterator.hasPrevious()) {   //hasPrevious从后向前访问
            System.out.println("ListIterator倒序输出：" + listiterator.previous()); //打印前一个元素
        }


        //java语法糖foreach，内部原理也是使用迭代器来遍历
        for (String str : list) {
            System.out.println("foreach循环输出:" + str);
        }


        //for循环，根据List元素索引遍历
        for (int i = 0; i < list.size(); i++) {
            System.out.println("for循环输出：" + list.get(i));
        }
    }
}
