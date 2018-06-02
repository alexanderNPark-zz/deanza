package network;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

/**
 * Created by AlexP on 11/15/2017.
 */
public class PracticeProbs {

    public static void main(String[] args){
        System.out.println(threeSUM_distinct(new int[]{12,3,0,2,4,5,-10,-1}));
    }

    public static boolean threeSUM(int[] nums){
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                for(int k=0;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean threeSUM_distinct(int[] nums){
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i==j)continue;
                for(int k=0;k<nums.length;k++){
                    if(i==k || j==k)continue;
                    if(nums[i]+nums[j]+nums[k]==0){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
