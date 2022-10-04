import java.util.*;
class highspeed implements Runnable{
    private static int tickets = 10000;
    int total;
    Thread t;
    public highspeed(String name){
        total=0;
        t = new Thread(this, name);
        t.start();
    }
    public void run(){
        int num;
        while(tickets!=0){
            num=Trandom();
            if(sells(num)){
                total=total+num;
                //System.out.println(t.getName()+"賣了"+num);          
            }
        }
        System.out.println(t.getName()+"賣了"+total+"張票");
    }
    private static int Trandom(){
        Random random=new Random();
        int num=0;
        do{
            num=random.nextInt(5);
        }while(num==0);
        return num;
    }
    private static synchronized boolean sells(int number){
        if(tickets>=number){
            tickets=tickets-number;
            return true;
        }
        else{
            return false;
        }
    }
}
public class week3_homework {
    public static void main(String[] agrs){
        highspeed hA=new highspeed("售票機A");
        highspeed hB=new highspeed("售票機B");
        highspeed hC=new highspeed("售票機C");
        highspeed hD=new highspeed("售票機D");
    }
}
