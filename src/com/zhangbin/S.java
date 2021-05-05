package com.zhangbin;

public class S {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        int sum = 0;//表示的个数
        boolean flag = false;
        int j = 0;
        int i =0;
        for(i = 101 ;i <= 200 ; i++){
            for(j = i - 1; j>1 ;j--){
                if(i%j == 0){
                    flag = true;
                    break;
                }
            }
            if(j==1 && flag == false){
                sum++;
                if(sum >20){
                    break;
                }
                if(sum >=11){
//                    System.out.println(i);
                }
            }
            flag = false;
        }

        Integer a = new Integer(10);
        Integer b = new Integer(10);
        System.out.println(a.equals(b));
    }
}
