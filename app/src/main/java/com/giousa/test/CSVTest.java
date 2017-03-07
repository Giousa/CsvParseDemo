package com.giousa.test;

import java.io.File;
import java.util.List;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2017/3/7
 * Time:下午7:02
 */

public class CSVTest {

    public static void main(String[] args) {
        List<String> dataList=CSVUtils.importCsv(new File("/Users/zhangmengmeng/Downloads/values.csv"));
        if(dataList!=null && !dataList.isEmpty()){
            for(String data : dataList){
                System.out.println(data);



            }
        }
    }
}
