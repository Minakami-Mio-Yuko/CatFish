import java.util.Scanner;

public class play {
    desktop stack=new desktop();
    player queue1=new player();
    player queue2=new player();
    private player []list=new player[2];

    public String step1(){//给双方发牌
        list[0]=queue1;
        list[1]=queue2;
        for(int i=1;i<=2;i++){
            System.out.println("请输入queue"+i+"的初始手牌");
            Scanner sc=new Scanner(System.in);
            for(int j=0;j<=5;j++){
                list[i-1].in(sc.nextInt());//发牌完毕2
            }
        }
        list=null;
        return "发牌完毕";
    }


    public String step2(){//游戏阶段
        int []book={0,0,0,0,0,0,0,0,0,0};//定义记录数组
        int t;
        while(queue1.getHead()!=queue1.getTail()&&queue2.getHead()!=queue2.getTail()){
            t=queue1.getCard(queue1.getHead());//获取第一个队列头节点的值（先进先出）
            if(book[t]!=1){
                queue1.out();
                stack.instack(t);//不存在即进栈
                book[t]=1;
            } else {
                queue1.out();//存在就赢牌操作
                queue1.in(t);
                while(stack.getD_card(stack.getTop()-1)!=t){
                    int num=stack.outstack();
                    queue1.in(num);
                    book[num]=0;
                }
                book[t]=0;
                queue1.in(stack.outstack());
            }

            if(queue1.getHead()==queue1.getTail()){
                break;
            }
            t=queue2.getCard(queue2.getHead());//获取第二个队列头节点的值
            if(book[t]!=1){
                queue2.out();
                stack.instack(t);
                book[t]=1;
            }else{
                queue2.out();
                queue2.in(t);
                while(stack.getD_card(stack.getTop()-1)!=t){//赢牌阶段
                    int num =stack.outstack();
                    queue2.in(num);
                    book[num]=0;
                }
                book[t]=0;
                queue2.in(stack.outstack());
            }

        }
        System.out.println("queue1:");
        for(int i=queue1.getHead();i<queue1.getTail();i++){
            System.out.print(queue1.getCard(i));
        }
        System.out.println("queue2:");
        for(int i=queue2.getHead();i<queue2.getTail();i++){
            System.out.println(queue2.getCard(i));
        }
        System.out.println("desktop:");
        for(int i=stack.getTop()-1;i>=0;i--){
            System.out.print(stack.getD_card(i));
        }

        return "游戏结束";
    }


    public static void main(String[] args) {
        play game=new play();

        System.out.println(game.step1());
        System.out.print(game.step2());

    }
}
