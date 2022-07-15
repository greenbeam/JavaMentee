public class Employee implements Runnable {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String name;
    int id;

    public long SLEEP_TIMEOUT = 3000;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(SLEEP_TIMEOUT);
        } catch (InterruptedException e) {
            System.out.println("Delay for thread is failed");
        }

    }
}
