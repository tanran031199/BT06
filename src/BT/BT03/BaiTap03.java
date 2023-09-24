package BT.BT03;

public class BaiTap03 {
    public static void main(String[] args) {
        int[] arr = new int[1000000];
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        for (int i = 0; i < arr.length; i++) {
            System.out.println(i);
            i++;
        }

        stopWatch.stop();

        System.out.println("Thời gian chạy của thuật toán là: " + stopWatch.getRunTime() + "ms");
    }
}
