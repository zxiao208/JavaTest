package threaddemo;

public class Person  {
    private int age;
    private String name;
    private int foodnum=0;//食物数量
    private  boolean hasfood=false;//是否还有食物
    public synchronized void run(){
        System.out.println("one in the same time");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void eat(){
       if(hasfood){
           System.out.println("吃了第"+foodnum+"个馒头");
           hasfood=false;
           this.notify();
       }else{
           try {
               this.wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }


    public synchronized void cook(){
            if(!hasfood){
                foodnum++;
                System.out.println("这是做的第"+foodnum+"个馒头");
                hasfood=true;
                this.notify();
            }else{
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}
