package thread;

public class ThreadEx9 {
    public static void main(String[] args) {
        ThreadGroup main = Thread.currentThread().getThreadGroup();
        ThreadGroup grp1 = new ThreadGroup("Group1");
        ThreadGroup grp2 = new ThreadGroup("Group2");

        // ThreadGroup (ThreadGroup parent, String name)
        ThreadGroup subGrpl = new ThreadGroup(grp1, "SubGroup1");

        grp1.setMaxPriority(3);  // 쓰레드 그룹 grpl의 최대 우선순위를 3으로 변경

        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) { }
            }
        };

        // Thread(ThreadGroup tg, Runnable r, String name)
        new Thread(grp1, r, "th1").start();
        new Thread(subGrpl, r, "th2").start();
        new Thread(grp2, r, "th3").start();

        System.out.println(">>List of ThreadGroup : " + main.getName()
                + ", Active ThreadGroup: " + main.activeGroupCount()
                + ", Active Thread: " + main.activeCount());
        main.list();
    }
}
