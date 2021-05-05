package com.zhangbin.chao;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Scanner;

public class SloutionA {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        DhcpServer dhcpServer = new DhcpServer();
        int operationCnt = cin.nextInt();
        for (int i = 0; i < operationCnt; i++) {
            String[] operation = cin.next().split("=");
            if ("REQUEST".equals(operation[0])) {
                System.out.println(dhcpServer.request(operation[1]));
            } else {
                dhcpServer.release(operation[1]);
            }
        }
        cin.close();
    }

    static class DhcpServer {
        int index = 0;//表示当前遍历到哪里了
        boolean[] vis = new boolean[256];
        HashMap<String,String> res = new HashMap<>();
        DhcpServer() {
            // 在此补充你的代码
        }

        String request(String mac) {
            String orDefault = res.getOrDefault(mac, "NO");
            if (orDefault.equals("NO")){//表示需要分配
                String result = getRes(mac);
                if (result == null){
                    return "NA";
                }else {
                    return result;
                }
            }else {
                String s = res.get(mac);
                String num  = s.substring(10);
                if (vis[Integer.valueOf(num)] == true){ //找到了并且没有释放
                    return orDefault;
                }else{
                   if (vis[Integer.valueOf(num)] == false){//如果没有使用过后
                       vis[Integer.valueOf(num)] = true;
                       return orDefault;
                   }else{//如果已经被占用了，则按照新分配的代码进行分配吧 题目其实没咋说清楚
                       String result = getRes(mac);
                       if (result == null){
                           return "NA";
                       }else {
                           return result;
                       }
                   }
                }

            }
        }
        String getRes(String mac){
            //没有分配过的情况下
            boolean isGet = false;
            for (int i = index; i < 256; i++) {
                if (vis[i] == false){
                    res.put(mac,"192.168.0."+i);
                    vis[i] = true;
                    isGet = true;
                    break;
                }
            }
            if (!isGet){
                for (int i = 0; i < index ; i++) {
                    if (vis[i] == false){
                        res.put(mac,"192.168.0."+i);
                        vis[i] = true;
                        isGet = true;
                        break;
                    }
                }
            }
            index++;
            index %=256;
            return res.get(mac);
        }

        void release(String mac) {
            // 在此补充你的代码
            String s = res.get(mac);
            String num  = s.substring(10);

            vis[Integer.valueOf(num)] = false;
        }
    }
}
