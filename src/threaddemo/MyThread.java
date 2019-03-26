package threaddemo;

public class MyThread extends Thread {
    private Person person;
    public MyThread(Person person) {
        this.person=person;
    }

    private int count =0;
    int c=0;
    @Override
    public void run() {
        System.out.println("name="+this.getName()+"  id="+this.getId());
        person.run();
    }
}
