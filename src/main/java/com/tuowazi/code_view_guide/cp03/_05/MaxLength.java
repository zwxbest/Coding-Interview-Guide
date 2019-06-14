package com.tuowazi.code_view_guide.cp03._05;

import com.google.common.collect.Maps;
import java.util.Map;
import node.BiNode;
import node.Node;

/**
 * @author zhangweixiao - 2019/6/14
 */
public class MaxLength {



    public int getMaxLength(BiNode head,int sum){
        Map<Integer,Integer> sumMap= Maps.newHashMap();
        sumMap.put(0,0);
        return preOrder(head,sum,0,1,0,sumMap);
    }

    public int preOrder(BiNode head,int sum,int preSum,int level,int maxLen,Map<Integer,Integer> sumMap){
        if(head == null){
            return maxLen;
        }
        int curSum = preSum+head.value;
        if (!sumMap.containsKey(curSum)) {
            sumMap.put(curSum, level);
        }
        if(sumMap.containsKey(curSum-sum)){
            maxLen = Math.max(level-sumMap.get(curSum-sum),maxLen);
        }
        maxLen = preOrder(head.left,sum,curSum,level+1,maxLen,sumMap);
        maxLen = preOrder(head.right,sum,curSum,level+1,maxLen,sumMap);
        if(level == sumMap.get(curSum)){
            sumMap.remove(curSum);
        }
        return maxLen;
    }
}
