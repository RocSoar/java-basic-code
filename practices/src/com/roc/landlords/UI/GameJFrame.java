package com.roc.landlords.UI;

import com.roc.landlords.Common;
import com.roc.landlords.PlayerOperation;
import com.roc.landlords.data.*;
import com.roc.landlords.event.EventManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class GameJFrame extends JFrame {
    //获取界面中的隐藏容器
    //现在统一获取了，后面直接用就可以了
    public Container container = getContentPane();

    public JButton claimBtn = new JButton("抢地主");
    public JButton noClaimBtn = new JButton("不     抢");
    public JButton submitBtn = new JButton("出牌");
    public JButton cancelBtn = new JButton("不要");

    //创建三个玩家前方的提示文字：倒计时
    public JTextField[] timeText = new JTextField[3];
    //创建地主图标
    JLabel landlord = new JLabel(new ImageIcon("practices/image/dizhu.png"));

    PokerDeck deck;
    public List<PokerHand> playerList;
    public PokerSet holeCards;

    PlayerOperation po;
    boolean nextPlayer = false;

    public GameJFrame() {
        EventManager.afterDeckCreated.addListener(this::onAfterDeckCreated);
        //设置界面
        initJFrame();
        //添加组件
        initView();
        //界面显示出来
        //先展示界面再发牌，因为发牌里面有动画，界面不展示出来，动画无法展示
        this.setVisible(true);
        initCard();
        initGame();
    }

    public void initCard() {
        deck = new PokerDeck(container);
        holeCards = deck.dealHoleCards();
        playerList = deck.dealHands();
        for (int i = 0; i < playerList.size(); i++) {
            List<PokerCard> list = playerList.get(i).getCards();
            Common.rePosition(this, list, i);
        }
    }

    //打牌之前的准备工作
    private void initGame() {
        //展示抢地主和不抢地主两个按钮
        claimBtn.setVisible(true);
        noClaimBtn.setVisible(true);

        //展示自己前面的倒计时文本
        timeText[1].setVisible(true);
        //倒计时10秒
        po = new PlayerOperation(this, 30);
        //开启倒计时
        po.start();
    }

    //设置界面
    public void initJFrame() {
        //设置标题
        this.setTitle("斗地主");
        //设置任务栏图标
        setIconImage(Toolkit.getDefaultToolkit().getImage("practices/image/dizhu.png"));
        //设置大小
        this.setSize(830, 620);
        //设置关闭模式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口无法进行调节
        this.setResizable(false);
        //界面居中
        this.setLocationRelativeTo(null);
        //取消内部默认的居中放置
        container.setLayout(null);
        //设置背景颜色
        container.setBackground(Color.LIGHT_GRAY);
    }

    //添加组件
    public void initView() {
        //设置位置
        claimBtn.setBounds(320, 400, 75, 20);
        //添加点击事件
        claimBtn.addActionListener(this::claimAction);
        //设置隐藏
        claimBtn.setVisible(false);
        //添加到界面中
        container.add(claimBtn);

        noClaimBtn.setBounds(420, 400, 75, 20);
        noClaimBtn.addActionListener(this::noClaimAction);
        noClaimBtn.setVisible(false);
        container.add(noClaimBtn);

        submitBtn.setBounds(320, 400, 60, 20);
        submitBtn.addActionListener(this::submitAction);
        submitBtn.setVisible(false);
        container.add(submitBtn);

        cancelBtn.setBounds(420, 400, 60, 20);
        cancelBtn.addActionListener(this::cancelAction);
        cancelBtn.setVisible(false);
        container.add(cancelBtn);

        //创建三个玩家前方的提示文字：倒计时
        //每个玩家一个
        //左边的电脑玩家是0
        //中间的自己是1
        //右边的电脑玩家是2
        for (int i = 0; i < timeText.length; i++) {
            timeText[i] = new JTextField("倒计时:");
            timeText[i].setEditable(false);
            timeText[i].setVisible(false);
            container.add(timeText[i]);
        }
        timeText[0].setBounds(140, 230, 60, 20);
        timeText[1].setBounds(374, 360, 60, 20);
        timeText[2].setBounds(620, 230, 60, 20);

        //创建地主图标
        landlord.setVisible(false);
        landlord.setSize(40, 40);
        container.add(landlord);
    }

    private void claimAction(ActionEvent e) {
        timeText[1].setText("抢地主");
        po.canRun = false;
    }

    private void noClaimAction(ActionEvent e) {
        timeText[1].setText("不抢");
        po.canRun = false;
    }

    private void submitAction(ActionEvent e) {
    }

    private void cancelAction(ActionEvent e) {
        //点击不要
        this.nextPlayer = true;
        playerList.get(1).set.getCards().clear();
        timeText[1].setText("不要");
    }

    private void onAfterDeckCreated(List<PokerCard> list) {
        list.forEach(c -> container.add(c));
    }
}
