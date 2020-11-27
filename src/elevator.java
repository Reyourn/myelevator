class elevator implements elevatotbutton {
    private boolean doornow;//电梯门目前的状态
    private int floor;//当前楼层
    private int weight;//当前电梯内人员重量
    final int maxweight=1200;//电梯承重上限
    final int beginfloor=1;//电梯初始楼层
    final int top_door=10;//电梯上限楼层

    public void elevators() {//定义构造函数，初始化
        doornow=false;
        floor=1;
        weight=0;
    }

    public void elevatornow() {//电梯当前状态
        System.out.println("门："+doornow+"楼层："+floor+"载重："+weight);
    }
    public void opendoor() {//开门方法
        doornow=true;
    }
    public void closedoor() {//关门条件
        if (weight>=maxweight) {
            System.out.println("电梯超重啦，无法运行");
            System.out.println("电梯目前的重量为"+weight);
        }else {
            doornow=false;
        }
    }

    public void upfloor() {
        if (doornow==false) {//等待电梯的过程
            if (floor<=top_door) {
                floor++;
                System.out.println("电梯来到了第"+floor+"楼");
            }else {
                System.out.println("电梯在顶楼了，无法再上升了");
            }
        }else {
            System.out.println("电梯门还没关，无法上楼");
        }
    }

    public void downfloor() {
        if (doornow==false) {//等待电梯下楼的过程
            if (floor>=beginfloor) {
                floor--;
                System.out.println("电梯来到了第"+floor+"楼");
            }else {
                System.out.println("电梯在底楼了，无法再下降了");
            }
        }else {
            System.out.println("电梯门还没关，无法下楼");
        }
    }

    public void setFloor(int want) {//修改目标楼层参数
        if (want>=beginfloor&&want<=top_door) {
            while (floor!=want) {//使用while循环来判断目标楼层上楼还是下楼
                if (floor<top_door) {
                    upfloor();
                }else {
                    downfloor();
                }
            }System.out.println("电梯按要求停留在"+floor+"楼");
        }else {
            System.out.println("输入楼层有误");
        }
    }

    public int getFloor(){
        return floor;
    }
    public boolean open() {
        return doornow;
    }
}

