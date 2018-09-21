package main.com.lwq.demo;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Lwq
 * @Date: 2018/9/21 12:43
 * @Version 1.0
 * @Describe
 */
/*
一个会议室竟可能多的安排会议，一个会议由开始时间和结束时间
 */
public class BestArrange {
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static class ProgramComparator implements Comparator<Program>{

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end-o2.end;
        }
    }

    public static int beatArray(Program[] programs,int start){
        Arrays.sort(programs,new ProgramComparator());
        int res = 0;
        for(int i = 0; i < programs.length ; i++){
            if(start<=programs[i].start){
                res++;
                start = programs[i].end;
            }
        }
        return res;
    }
}
