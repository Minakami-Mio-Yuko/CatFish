public class player {//作为队列
    private int []card;//暂时未能指定大小
    private int head;//头节点
    private int tail;//尾节点

    public int getCard(int a) {
        return card[a];
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }

    public void setCard(int[] card) {
        this.card = card;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public player() {
        this.card = new int[1001];
        this.head=0;
        this.tail=0;
    }

    public void out(){
        head++;
    }

    public void in(int num){
        card[tail]=num;
        tail++;

    }

}
