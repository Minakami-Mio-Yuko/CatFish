public class desktop {//作为栈输出
    private int [] D_card;
    private int top;

    public int getD_card(int a) {
        return D_card[a];
    }

    public int getTop() {
        return top;
    }

    public void setD_card(int[] d_card) {
        this.D_card = d_card;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public desktop() {//构造函数
        this.D_card = new int[10];
        this.top = 0;
    }

    public void instack(int num){//进栈，指针一开始指向栈顶的空位
        D_card[top]=num;
        top++;
    }

    public int outstack(){//出栈，因为指针是指向栈顶的空位的，一开始要先top--
        top--;
        int t=D_card[top];
        D_card[top]=0;
        return  t;
    }
}
