package com.roc.test4;

public class RedPacket {
    private int id;
    private int amount;

    public RedPacket() {
    }

    public RedPacket(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "[第" + id + "号红包, " + "价值" + amount + "元]";
    }
}
