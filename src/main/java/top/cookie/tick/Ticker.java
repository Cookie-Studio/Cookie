package top.cookie.tick;

public class Ticker extends Thread {
    private int tick = 1;
    @Override
    public void start() {
        while(true) {
            try {
                super.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (this.tick == 20)
                this.tick = 1;
            else
                this.tick++;
        }
    }
    public static void main(String[] args) {
        Ticker t = new Ticker();
        t.start();
    }
}
