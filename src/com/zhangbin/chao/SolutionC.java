package com.zhangbin.chao;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class SolutionC {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int totalSales = cin.nextInt();
        int supNum = cin.nextInt();

        Map<Integer, List<Integer>> relationList = new HashMap<>();
        for (int i = 0; i < supNum; i++) {
            int sup = cin.nextInt(); // 主管
            int subCnt = cin.nextInt();
            List<Integer> subIds = new ArrayList<>(subCnt);
            for (int j = 0; j < subCnt; j++) {
                subIds.add(cin.nextInt()); // 下属
            }
            relationList.put(sup, subIds);
        }

        int appointSale = cin.nextInt();
        cin.close();

        int[] results = pointSaleSurvey(totalSales, relationList, appointSale);
        String[] strResult = Arrays.stream(results).mapToObj(String::valueOf).toArray(String[]::new);
        System.out.print("[" + String.join(" ", strResult) + "]");
    }

    // 待实现函数，在此函数中填入答题代码
    private static int[] pointSaleSurvey(int totalSales, Map<Integer, List<Integer>> relationList, int appointSale) {
        //用来统计每一层的数目，然后在用每一层统计下一层的数目
        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();
        int j = 2;//用来区分不同的层
        int max = Integer.MIN_VALUE;
        int ceng = -1;
        //先把第一层遍历吊
        if (relationList.get(appointSale) !=null) {
            List<Integer> integers = relationList.get(appointSale);
            if (max < integers.size()) {
                max = integers.size();
                ceng = j;
            }
            j++;
            for (Integer tar : integers
            ) {
                if (relationList.get(tar) != null) {
                    temp1.addAll(relationList.get(tar));
                }
            }
            if (max < temp1.size()) {
                max = temp1.size();
                ceng = j;
            }
            j++;
        }
        //后面的遍历完了
        while (!temp1.isEmpty() || ! temp2.isEmpty()) {
            if (j % 2 == 0) {
                //这样先遍历一次
                for (Integer integer: temp1
                ) {
                    if (relationList.get(integer) != null) {
                        temp2.addAll(relationList.get(integer));
                    }
                }
                if (temp2.size()>max){
                    max = temp2.size();
                    ceng = j;
                }
                j++;
                temp1.clear();
            }else {
                //这样先遍历一次
                for (Integer integer: temp2
                ) {
                    if (relationList.get(integer) != null) {
                        temp1.addAll(relationList.get(integer));
                    }
                }
                if (temp1.size()>max){
                    max = temp1.size();
                    ceng = j;
                }
                j++;
                temp2.clear();
            }
        }
        if (max == 1 || max == Integer.MIN_VALUE){
            return new int[]{1,1};
        }else {
            return new int[]{ceng,max};
        }
    }
}
