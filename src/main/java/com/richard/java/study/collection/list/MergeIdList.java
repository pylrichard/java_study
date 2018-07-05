package com.richard.java.study.collection.list;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

public class MergeIdList {
    public static void main(String[] args) {
        List<Long> userIdList = Lists.newArrayList();
        List<Long> mergeUserIdList = Lists.newArrayList();
        List<Integer> indexList = Lists.newArrayList();
        userIdList.add(7L);
        userIdList.add(1L);
        userIdList.add(3L);
        userIdList.add(2L);
        userIdList.add(5L);
        mergeUserIdList.add(8L);
        mergeUserIdList.add(1L);
        mergeUserIdList.add(4L);
        Collections.sort(userIdList);
        Integer i = 0;
        for (Long mergeUserId : mergeUserIdList) {
            int ret = Collections.binarySearch(userIdList, mergeUserId);
            if (ret < 0) {
                indexList.add(i);
            }
            i++;
        }
        for (Integer index : indexList) {
            userIdList.add(mergeUserIdList.get(index));
        }
        for (Long mid : userIdList) {
            System.out.println(mid);
        }
    }
}
