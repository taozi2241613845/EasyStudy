package com.tzq.easystudy.util;

import java.util.HashMap;

public class QuestionTypeMap {
    private static String[] typeName = {"单选题","多选题","判断题","填空题","简答题"};
    private static Long[] type = {1L,2L,3L,4L,5L};
    private static HashMap<Long,String> questionTypeMap = new HashMap<>();
    static {
        int len = typeName.length;
        for (int i = 0; i < len; i++) {
            questionTypeMap.put(type[i],typeName[i]);
        }
    }
    public static String getTypeNameByType(Long type){
        return questionTypeMap.get(type);
    }

}
