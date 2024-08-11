package com.roc.test4;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class StaffCallable implements Callable<Staff> {
    private final Staff staff;
    private final List<RedPacket> redPackets;
    private static boolean finished;
    private final Random r = new Random();

    public StaffCallable(int id, List<RedPacket> redPackets) {
        this.staff = new Staff(id, 0);
        this.redPackets = redPackets;
    }

    @Override
    public Staff call() throws InterruptedException {
        while (true) {
            synchronized (StaffCallable.class) {
                if (redPackets.isEmpty()) {
                    if (!finished) {
                        finished = true;
                        System.out.println("抢红包活动结束!");
                    }
                    break;
                }
                int index = r.nextInt(redPackets.size());
                RedPacket redPacket = redPackets.remove(index);
                staff.incrementAmount(redPacket.getAmount());
                System.out.println(staff.getId() + "号员工抢到了 " + redPacket);
            }
            Thread.sleep(100);
        }
        return staff;
    }
}
