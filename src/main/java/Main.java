import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static final Thread[] serviceArr = new Thread[100];
    static int index = 0;
    public static void main(String[] args) {
        Thread hearBeat = new ServiceHeartBeat();
        hearBeat.start();

        // 사용자 하나 접속했다 치자
        generateNewService();
    }

    // 원래 게임이라면 소켓큐를 감시하여 사용자 접속에 대해 게임 서비스 쓰레드를 만들어줘야 함
    static void generateNewService() {
        serviceArr[index] = new Thread(new Service());
        serviceArr[index].start(); // 사용자가 게임 수행
        index += 1;
    }
}