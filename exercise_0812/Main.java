package exercise.exercise_0812;

import java.util.*;

/**
 * @Description:
 * @Author:Anan
 * @Date:2019/8/12
 */

/*
某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数； 有m批客人，每批客人有两个参数:b人数，c预计消费金额。
在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大

输入描述:
输入包括m+2行。 第一行两个整数n(1 <= n <= 50000),m(1 <= m <= 50000) 第二行为n个参数a,即每个桌子可容纳的最大人数,
以空格分隔,范围均在32位int范围内。 接下来m行，每行两个参数b,c。分别表示第i批客人的人数和预计消费金额,
以空格分隔,范围均在32位int范围内。

输出描述:
输出一个整数,表示最大的总预计消费金额
示例1
输入
3 5 2 4 2 1 3 3 5 3 7 5 9 1 10
输出
20
 */

class Customer implements Comparable<Customer> {
    public int num;
    public int fee;

    public Customer(int num, int fee) {
        this.num = num;
        this.fee = fee;
    }

    @Override
    public int compareTo(Customer o) {
        if(o.fee>this.fee){
            return 1;
        }else if(o.fee <this.fee){
            return -1;
        }
        return 0;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];//桌子
            for(int i=0; i<a.length; i++){
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);//桌子由小到大排序
            PriorityQueue<Customer> queue = new PriorityQueue<>();
            for(int i=0; i<m; i++){
                int b =  sc.nextInt();
                int c = sc.nextInt();
                if(b <= a[n-1]){
                    queue.add(new Customer(b,c));
                }
            }
            long sum = 0;//金额
            int count = 0;//桌子被使用的个数
            boolean[] flag = new boolean[n];//记录桌子是否已经有人坐了
            while (!queue.isEmpty()){
                Customer customer = queue.poll();
                for(int j=0; j<n; j++){
                    if(a[j]>=customer.num && !flag[j]){
                        sum += customer.fee;
                        count++;
                        flag[j] = true;
                        break;
                    }
                }
                if(count == n){
                    break;
                }
            }
            System.out.println(sum);
        }
    }
}
