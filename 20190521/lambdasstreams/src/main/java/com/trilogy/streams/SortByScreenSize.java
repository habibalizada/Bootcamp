package com.trilogy.streams;

import java.util.Comparator;

public class SortByScreenSize implements Comparator<Television> {

    public int compare(Television t1, Television t2){
        if (t1.getScreenSize() < t2.getScreenSize()){
            return -1;
        }else if(t1.getScreenSize() == t2.getScreenSize()){
            return 0;
        }else return 1;

    }
}
