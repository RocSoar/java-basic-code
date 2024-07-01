package com.roc.landlords;

import com.roc.landlords.UI.GameJFrame;
import com.roc.landlords.data.PokerCard;

import java.awt.*;
import java.util.List;

public class Common {
    //移动牌（有移动的动画效果）
    public static void move(PokerCard card, Point from, Point to) {
        if (to.x != from.x) {
            double k = (1.0) * (to.y - from.y) / (to.x - from.x);
            double b = to.y - to.x * k;
            int offset = 0;   //每次的最小移动距离
            if (from.x < to.x)
                offset = 20;
            else {
                offset = -20;
            }
            for (int i = from.x; Math.abs(i - to.x) > 20; i += offset) {
                double y = k * i + b;
                card.setLocation(i, (int) y);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        card.setLocation(to);
    }

    //重新摆放牌
    public static void rePosition(GameJFrame m, List<PokerCard> list, int flag) {
        Point p = new Point();
        if (flag == 0) {  //表示左边的玩家
            p.x = 50;
            p.y = (450 / 2) - (list.size() + 1) * 15 / 2;
        }
        if (flag == 1) {  //表示中间的玩家
            p.x = (800 / 2) - (list.size() + 1) * 21 / 2;
            p.y = 450;
        }
        if (flag == 2) {  //表示右边的玩家
            p.x = 700;
            p.y = (450 / 2) - (list.size() + 1) * 15 / 2;
        }
        for (PokerCard card : list) {
            move(card, card.getLocation(), p);
            m.container.setComponentZOrder(card, 0);
            if (flag == 1)
                p.x += 21;
            else
                p.y += 15;
        }
    }
}
