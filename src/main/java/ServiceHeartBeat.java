public class ServiceHeartBeat extends Thread{

    @Override
    public void run() {
        System.out.print("heartbeat start");
        int index = 0;
        while(true) {
            check(index, Main.serviceArr[index]);
            index = (index+1) % 100;
        }
    }

    private void check(int index, Thread service) {
        if(service == null) {
            return;
        }

        if(Thread.State.TERMINATED.equals(service.getState())) {
            askNewService(index);
        }
    }

    private void askNewService(int index) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int answer = Main.sc.nextInt();
        if(answer == 1) {
            Main.serviceArr[index] = new Thread(new Service());
            Main.serviceArr[index].start(); // 사용자에게 다시 게임 시켜줘야 함
        }
        else if(answer == 2) {
            Main.serviceArr[index] = null; // 서버와 사용자의 연결을 끊어야 함
        }
    }
}
