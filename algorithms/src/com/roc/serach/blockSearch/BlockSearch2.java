package com.roc.serach.blockSearch;

public class BlockSearch2 {
    public static void main(String[] args) {

        int[] arr = {27, 22, 30, 40, 36,
                13, 19, 16, 20,
                7, 10,
                43, 50, 48};
        Block2 b1 = new Block2(22, 40, 0, 4);
        Block2 b2 = new Block2(13, 20, 5, 8);
        Block2 b3 = new Block2(7, 10, 9, 10);
        Block2 b4 = new Block2(43, 50, 11, 13);
        Block2[] block2Arr = {b1, b2, b3, b4};
    }

    public static int getIndex(Block2[] block2Arr, int[] arr, int num) {
        int indexBlock = findIndexBlock(block2Arr, num);
        if (indexBlock == -1)
            return -1;

        int startIndex = block2Arr[indexBlock].getStartIndex();
        int endIndex = block2Arr[indexBlock].getEndIndex();
        for (int i = startIndex; i <= endIndex; i++) {
            if (arr[i] == num)
                return i;
        }
        return -1;
    }

    public static int findIndexBlock(Block2[] blockArr, int num) {
        for (int i = 0; i < blockArr.length; i++) {
            if (num >= blockArr[i].getMin() && num <= blockArr[i].getMax())
                return i;
        }
        return -1;
    }
}

class Block2 {
    private int min;
    private int max;
    private int startIndex;
    private int endIndex;

    public Block2(int min, int max, int startIndex, int endIndex) {
        this.min = min;
        this.max = max;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
}
