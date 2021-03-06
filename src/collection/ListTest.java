package collection;

import java.util.*;

public class ListTest {
    public static void main(String[] args) {

        //ArrayList集合collection
        Collection collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);






        //ArrayList集合list
        List list = new ArrayList();
        System.out.println("数组是否为空：" + list.isEmpty());

        list.add("a");
        list.add("b"); //将指定的元素添加到此列表的尾部
        list.add("c");
        list.add(1, "d"); //在元素第二个位置插入

        list.addAll(collection); //按照指定 collection 的迭代器所返回的元素顺序，将该 collection 中的所有元素添加到此列表的尾部。
        list.addAll(1, collection); //从指定的位置开始，将指定 collection 中的所有元素插入到此列表中。
//        List<String> listsub=list.subList(3,5);
        for (Object strSub : list) {
            System.out.println("subList 3至5 ：" + strSub.toString());
        }

        //打印ArrayList的长度
        System.out.println("集合的长度： " + list.size());

        //遍历方法  Iterator迭代器
        Iterator iterator = list.listIterator();
        while (iterator.hasNext()) {
            System.out.println("iterator:" + iterator.next().toString());
        }

        iterator.remove(); //该操作会删除list中的所有元素
        //遍历方法  ListIterator迭代器继承Iterator迭代器
        ListIterator<String> listiterator = list.listIterator();//List的实现的特有迭代器接口ListIterator，双向访问，允许元素插入替换，提供方法从指定位置迭代
        listiterator.add("e");
        while (listiterator.hasPrevious()) {   //hasPrevious从后向前访问
            System.out.println("ListIterator倒序输出：" + listiterator.previous()); //打印前一个元素l
//            listiterator.next();//会报错的

        }

        //java语法糖foreach，内部原理也是使用迭代器来遍历
        for (Object str : list) {
            System.out.println("foreach循环输出:" + str);
        }


        //for循环，根据List元素索引遍历
        for (int i = 0; i < list.size(); i++) {
            System.out.println("for循环输出：" + list.get(i).toString());
            if (i > 2) {
                System.out.println("删除之前第" + i + "个元素是" + list.get(i).toString());
                //删除元素后会，list的大小会立刻改变
                list.remove(0);
                //这个最后一个会报数组越界，因为list长度少了一个，但是 i 的值并没有变
//                System.out.println("删除之后第" + i + "个元素是" + list.get(i).toString());
            }

        }

        /**
         * 比如上例中一个 ArrayList 类，在添加一个元素的时候，它可能会有两步来完成：1. 在 Items[Size] 的位置存放此元素；2. 增大 Size 的值。
         在单线程运行的情况下，如果 Size = 0，添加一个元素后，此元素在位置 0，而且 Size=1；
         而如果是在多线程情况下，比如有两个线程，线程 A 先将元素存放在位置 0。但是此时 CPU 调度线程A暂停，线程 B 得到运行的机会。
         线程B也向此 ArrayList 添加元素，因为此时 Size 仍然等于 0 （注意哦，我们假设的是添加一个元素是要两个步骤哦，而线程A仅仅完成了步骤1），
         所以线程B也将元素存放在位置0。然后线程A和线程B都继续运行，都增加 Size 的值。
         */
        List<Integer> arrayList=new ArrayList<>();  //多线程操作可能会报错 比如add操作
        /**
         * Vector 的方法都是同步的，并且 Vector 明确地设计为在多线程环境中工作。
         * 但是它的线程安全性是有限制的，即在某些方法之间有状态依赖(类似地，如果在迭代过程中 Vector 被其他线程修改，
         * 那么由 Vector.iterator() 返回的 iterator会抛出ConcurrentModifiicationException。
          */
        List<Integer> vectors=new Vector<Integer>();    //线程安全，但是符合操作也可能引起线程问题
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<1000;i++){
                    vectors.add(i);  //线程安全
//                    arrayList.add(i);  //多个线程操很可能会报错，是不安全的
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<1000;i++){
                    vectors.add(i);
//                    arrayList.add(i);

                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<1000;i++){
                    vectors.add(i);
//                    arrayList.add(i);

                }
            }
        }).start();





        //LinkedList
        Collection collection1 = new ArrayList();
        collection1.add(1);
        collection1.add(1);
        collection1.add(2);
        collection1.add(3);
        LinkedList linkedList = new LinkedList(collection1);//构造一个包含指定 collection 中的元素的列表，这些元素按其 collection 的迭代器返回的顺序排列。
        System.out.println("LinkedList大小为："+linkedList.size());
        ListIterator listiterator2 =linkedList.listIterator(3); //指定从哪个位置开始
        while (listiterator2.hasPrevious()){
            System.out.println("descendingIterator遍历LinkedList:"+listiterator2.previous().toString());
        }
        linkedList.remove(0);
        linkedList.removeFirst();
        Iterator desiterator =linkedList.descendingIterator(); //很简单，就是游标直接在 迭代器尾部，然后颠倒黑白，说是向后遍历，实际是向前遍历
        while (desiterator.hasNext()){
//            System.out.println("1");
            System.out.println("descendingIterator遍历LinkedList:"+desiterator.next());  //在循环里必须执行desiterator.next();否则hasNext一直返回true
        }

        linkedList.addLast(3);
        linkedList.removeLastOccurrence(3);  //移除集合中第一次出现的指定元素
        for (int i=0;i<linkedList.size();i++){
            System.out.println(linkedList.get(i));
        }






        //Set
        //hashset 无序的
        HashSet hashset = new HashSet<>();
       boolean adda= hashset.add("a");
       boolean adda2= hashset.add("a");
        hashset.add("b");
        hashset.add("b");
        hashset.add("c");
        System.out.println("第一次添加a元素："+adda);
        System.out.println("第二次添加a元素："+adda2);
        Iterator hashiterator=hashset.iterator();
        while (hashiterator.hasNext()) {
            System.out.println(hashiterator.next());
        }
        //先重写person对象的equals和hashCode方法,判断是否为相同元素
        //不重写按java默认的equals和hashcode比较
        Person person1 = new Person("zhangsan",19);

        Person person2 = new Person("zhangsan",18);
        boolean addp1=hashset.add(person1);
        System.out.println("person1的hash值："+person1.hashCode());
        boolean addp2=hashset.add(person2);
        person1.age=20;  //取消注释这一行,注释掉下一行，变成addp3也是true，但是hashset中会有两个相同的person1  //默认的hashcode不会有
        System.out.println("person1的hash值："+person1.hashCode());
//        person1=new Person("zhangsan",19);
        boolean addp3=hashset.add(person1);
        System.out.println("第一次添加person1元素："+addp1);
        System.out.println("第一次添加person2元素："+addp2);
        System.out.println("第二次添加person1元素："+addp3);
        Collection collection2 = new ArrayList();
//        collection2.add("a");
//        hashset.retainAll(collection2);
        for (Object obj:hashset) {
            System.out.println(obj.hashCode()+" "+ obj.toString());
        }

        //Treeset 不重复元素
        Set<String> treeSet=new TreeSet<>();
        treeSet.add("3");
        treeSet.add("2");
        treeSet.add("1");
        treeSet.add("1");
        treeSet.add("4");
        Iterator<String> stringIterator = treeSet.iterator();
        System.out.println(treeSet);
        while (stringIterator.hasNext()){
            System.out.println(stringIterator.next());
        }

        TreeSet<Person> treeSet1=new TreeSet<>();
        treeSet1.add(new Person("王五",20));
        treeSet1.add(new Person("王五",19));
        treeSet1.add(new Person("李四",18));
        treeSet1.add(new Person("张三",21));
        treeSet1.add(new Person("赵六",20));
        System.out.println(treeSet1); //不能直接输出，必须实现接口comparable重写接口中的compareTo

        //还可以自定义比较器进行排序
        TreeSet<Person> treeSet2=new TreeSet<>(new CompareByLen());
        treeSet2.add(new Person("周杰伦",36));
        treeSet2.add(new Person("李建",40));
        treeSet2.add(new Person("哈林",50));
        treeSet2.add(new Person("谢霆锋",35));
        treeSet2.add(new Person("旦增尼玛",28));
        System.out.println(treeSet2); //

    }


    static class Person implements Comparable<Person>{
        String  name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object obj) {
//            System.out.println("equals");
            if (this == obj){ // 如果两个对象地址一样 返回true
                return true;

            }
            if (obj == null){// 如果传进来的对象是空 返回false
                return false;
            }
            if (getClass() != obj.getClass()) {    // 如果两个对象不是一个类创建出来的
                return false;
            }// 就返回 false
            Person other = (Person) obj;        // 向下转型(准备调用特有方法)
            if (age != other.age) {
                return false;
            }
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name)) {
                return false;
            }
            return true;
        }

        //继承父类的hashcode(),无论你怎样改变person1的属性值，person1的对象创建后的哈希值是相同的 即 addp3=false
        //重写后 addp3=true *注意* 虽然addp3为true，两个person1元素属性都会变成20
        //写的比较乱，各位童鞋还是自己动手多写写就明白了
        @Override
        public int hashCode() {
            final int prime = 100;
            int result = 1;
            result = prime * result + age;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            System.out.println("hash值："+result);
            return result;
//            return super.hashCode();
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }


        @Override
        public int compareTo(Person o) {
            int num=this.age-o.age;
            return num==0?this.name.compareTo(o.name):num;
        }
    }


    //TreeSet比较器 //根据人的名字长度进行排序
    static class CompareByLen implements Comparator<Person>{

        @Override
        public int compare(Person o1,Person o2) {
            int num=o1.name.length()-o2.name.length();
            return num==0?o1.name.compareTo(o2.name):num;  //如果长度相同根据内容
        }
    }



}
