package com.roc.test4;

public class Staff {
    private int id;
    private int amount;

    public Staff(int id, int amount) {
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

    public void incrementAmount(int delta) {
        amount += delta;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
