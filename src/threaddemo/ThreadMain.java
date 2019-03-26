package threaddemo;

public class ThreadMain {
    public static void main(String[] arg){
        Person person=new Person();
         new MyThread(person).start();
         new MyThread(person).start();
        ThreadMain tm=new ThreadMain();
        ThreadMain.FirstThread firstThread = tm.new FirstThread(person);
        ThreadMain.SecondThread secondThread = tm.new SecondThread(person);
        firstThread.start();
        secondThread.start();
    }

     class FirstThread extends Thread{
        Person person;
        public FirstThread(Person person) {
             this.person=person;
         }

         @Override
         public void run() {
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                person.eat();
            }
         }
     }
    class SecondThread extends Thread{
        Person person;
        public SecondThread(Person person) {
            this.person=person;
        }

        @Override
        public void run() {
            while (true){
                person.cook();
            }
        }
    }
}
