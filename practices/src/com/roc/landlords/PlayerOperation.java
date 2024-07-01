package com.roc.landlords;

import com.roc.landlords.UI.GameJFrame;
import com.roc.landlords.data.PokerCard;

public class PlayerOperation extends Thread {
    //游戏主界面
    GameJFrame gameJFrame;

    //是否能走
    public boolean canRun = true;

    //倒计时
    int waitTime;

    public PlayerOperation(GameJFrame m, int waiTime) {
        this.gameJFrame = m;
        this.waitTime = waiTime;
    }

//    @Override
//    public void run() {
//        while (waitTime > -1 && canRun) {
//            gameJFrame.timeText[1].setText("倒计时:" + waitTime--);
//            try {
//                sleep(1);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        if (waitTime == -1) {
//            gameJFrame.timeText[1].setText("不抢");
//        }
//        gameJFrame.claimBtn.setVisible(false);
//        gameJFrame.noClaimBtn.setVisible(false);
//        for (PokerCard card : gameJFrame.playerList.get(1).getCards()) {
//            card.canClick = true;// 可被点击
//        }
//
//        if (gameJFrame.timeText[1].getText().equals("抢地主")) {
//            gameJFrame.playerList.get(1).getCards().addAll(gameJFrame.holeCards.getCards());
//            openHoleCards(true);
//            try {
//                sleep(2);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            Common.order(gameJFrame.playerList.get(1));
//            Common.rePosition(gameJFrame, gameJFrame.playerList.get(1), 1);
//            gameJFrame.publishCard[1].setEnabled(false);
//            setlord(1);
//        } else {
//            if (Common.getScore(gameJFrame.playerList.get(0)) < Common.getScore(gameJFrame.playerList.get(2))) {
//                gameJFrame.timeText[2].setText("抢地主");
//                gameJFrame.timeText[2].setVisible(true);
//                setlord(2);
//                openlord(true);
//                sleep(3);
//                gameJFrame.playerList.get(2).addAll(gameJFrame.lordList);
//                Common.order(gameJFrame.playerList.get(2));
//                Common.rePosition(gameJFrame, gameJFrame.playerList.get(2), 2);
//                openlord(false);
//            } else {
//                gameJFrame.timeText[0].setText("抢地主");
//                gameJFrame.timeText[0].setVisible(true);
//                setlord(0);
//                openlord(true);
//                sleep(3);
//                gameJFrame.playerList.get(0).addAll(gameJFrame.lordList);
//                Common.order(gameJFrame.playerList.get(0));
//                Common.rePosition(gameJFrame, gameJFrame.playerList.get(0), 0);
//                openlord(false);
//            }
//        }
//        gameJFrame.landlord[0].setVisible(false);
//        gameJFrame.landlord[1].setVisible(false);
//        turnOn(false);
//        for (int i = 0; i < 3; i++) {
//            gameJFrame.timeText[i].setText("不要");
//            gameJFrame.timeText[i].setVisible(false);
//        }
//        gameJFrame.turn = gameJFrame.dizhuFlag;
//        while (true) {
//
//            if (gameJFrame.turn == 1) {
//
//                if (gameJFrame.timeText[0].getText().equals("不要") && gameJFrame.timeText[2].getText().equals("不要"))
//                    gameJFrame.publishCard[1].setEnabled(false);
//                else {
//                    gameJFrame.publishCard[1].setEnabled(true);
//                }
//                turnOn(true);
//                timeWait(30, 1);
//                turnOn(false);
//                gameJFrame.turn = (gameJFrame.turn + 1) % 3;
//                if (win())
//                    break;
//            }
//            if (gameJFrame.turn == 0) {
//                computer0();
//                gameJFrame.turn = (gameJFrame.turn + 1) % 3;
//                if (win())
//                    break;
//            }
//            if (gameJFrame.turn == 2) {
//                computer2();
//                gameJFrame.turn = (gameJFrame.turn + 1) % 3;
//                if (win())
//                    break;
//            }
//        }
//    }

    public void openHoleCards(boolean isLord) {
        for (int i = 0; i < 3; i++) {
            if (isLord)
                gameJFrame.holeCards.getCards().get(i).turnFront();
            else {
                gameJFrame.holeCards.getCards().get(i).turnBack();
            }
            gameJFrame.holeCards.getCards().get(i).canClick = true;
        }
    }
}
