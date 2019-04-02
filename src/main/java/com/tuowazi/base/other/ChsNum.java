package com.tuowazi.base.other;

public class ChsNum {
    //转换为万千百表示等
    private static String coverToChsNum(String chsNum,int num,int lastBase){
        int[] base =  new int[]{10000_0000,10000,1000,100,10};
        //亿
        int yi = num/base[0];
        if(yi != 0){
            chsNum=coverToChsNum(chsNum,yi,-1)+"亿";
            return  coverToChsNum(chsNum,num%base[0],0);
        }
        //万
        int wan = num/base[1];
        if(wan != 0){
            chsNum=coverToChsNum(chsNum,wan,-1)+"万";
            return  coverToChsNum(chsNum,num%base[1],1);
        }
        //千
        int qian = num/base[2];
        if(qian!=0){
            chsNum=chsNum+qian+"千";
            return coverToChsNum(chsNum,num%base[2],2);
        }
        //百
        int bai = num/base[3];
        if(bai!=0){
            chsNum=chsNum+bai+"百";
            return coverToChsNum(chsNum,num%base[3],3);
        }
        //十
        int shi = num/base[4];
        if(shi!=0){
            if(shi == 1){
                chsNum=chsNum+"十";
            }else {
                chsNum=chsNum+shi+"十";
            }
            chsNum=chsNum+shi+"十";
            return coverToChsNum(chsNum,num%base[4],4);
        }else if(num!=0){
            chsNum=chsNum+num;
            return chsNum;
        }else {
            return chsNum;
        }
    }

}
