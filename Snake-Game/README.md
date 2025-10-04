## 经典游戏 贪吃蛇

#### 游戏逻辑

1. 方向键控制移动

2. ${SHIFT}$ 加速移动

3. 吃到食物蛇增长, 蛇越长速度越快

4. 冲出边界或撞到自身游戏结束



#### 包 / 库

- 框架 : awt + swing
  - GUI : JFrame(主窗口), FPanel(画板),
  - 逻辑 : Timer(定时器), KeyListener(监听键盘事件)
  - ImageIcon 加载图片

- java.utile.* 中 ArrayList, Deque 之类的基本容器

&nbsp;

#### 文件构成

- 主逻辑 - Game.java

- 蛇类 - Snake.java

- 物品类 - Item.jave

- 方块类 - Block.java

- 常量 - CONST.java

&nbsp;

#### **细节相关**

- timer 相当 while 循环, 主要来调用 update() 更新游戏帧
- GUI 坐标系屏幕左上角 (0, 0), x 轴水平, 向右为正, y 轴垂直, 向下为正

&nbsp;

#### [ OTHER ]

感觉写起来还是和 python 比较相似的,

拿来练手还是蛮舒服的,

但是感觉 awt + swing 比 pygame + pyautogui 好用怎么回事

&nbsp;

写完感觉对 java 的基本语法比较熟悉了

java 的容器没有 C++ 的 STL 用起来顺手, 可能是平常 STL 用的多 (?)

&nbsp;

虽然码量很少，300多行，但是因为刚接触 java 且纯手写，还是写了好多小时

