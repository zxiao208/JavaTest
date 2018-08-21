package collection;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add(1,"d"); //在元素第二个位置插入
        System.out.println(list.size());

        //遍历方法  Iterator迭代器
        Iterator<String> iterator = list.listIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
//            iterator.remove(); //该操作会删除list中的所有元素
        }
        //遍历方法  ListIterator迭代器继承Iterator迭代器
        ListIterator<String> listiterator = list.listIterator();//List的实现的特有迭代器接口ListIterator，双向访问，允许元素插入替换，提供方法从指定位置迭代
       listiterator.add("e");
        while(listiterator.hasPrevious()){   //hasPrevious从后向前访问
            System.out.println(listiterator.next());
        }
        //java语法糖foreach，内部原理也是使用迭代器来遍历
        for (String a:list) {
            System.out.println(a);
        }
        //for循环，根据List元素索引遍历
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
