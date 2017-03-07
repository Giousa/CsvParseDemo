package com.giousa.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2017/3/7
 * Time:下午7:12
 */

public class CsvParser {
    private BufferedReader bufferedreader = null;
    private List list = new ArrayList();

    public CsvParser() {
    }

    public CsvParser(InputStream inStream) throws IOException {
        InputStreamReader isr = new InputStreamReader(inStream, "UTF-8");
        bufferedreader = new BufferedReader(isr);
        String stemp;
        while ((stemp = bufferedreader.readLine()) != null) {
            list.add(stemp);
        }
    }

    public List getList() throws IOException {
        return list;
    }

    public List readCvs(String filename) throws IOException {
        CsvParser cu = new CsvParser(new FileInputStream(new File(filename)));
        List list = cu.getList();

        return list;
    }

    public static void main(String[] args) throws IOException {
        CsvParser test = new CsvParser();
        List dataList = test.readCvs("/Users/zhangmengmeng/Downloads/values.csv");

        String offsetnName = null;
        float offsetMax = 0;
        ArrayList<Share> shares = new ArrayList<>();

        HashMap<String,Float> minMap = new HashMap<>();
        HashMap<String,Float> maxMap = new HashMap<>();

        for (int i = 1; i < dataList.size(); i++) {
            String name = dataList.get(i).toString().split(",")[0];
            if (!"".equals(name)) {
                String valueString = dataList.get(i).toString().split(",")[3];
                if(isNumeric(valueString.substring(0,1))){
                    Float value = Float.parseFloat(valueString);
                    Share share = new Share(name, value);
                    shares.add(share);

                }
            }

        }

        for (int i = 0; i < shares.size(); i++) {
            Share share = shares.get(i);
            String name = share.getName();
            Float value = share.getValue();
            if(minMap.containsKey(name)){
                if(share.getMin() > value){
                    share.setMin(value);
                    minMap.put(name,value);
//                    System.out.println("min value = "+value);
                }
            }else{
                share.setMin(value);
                minMap.put(name,value);
            }

            if(maxMap.containsKey(name)){

                if(share.getMax() < value){
                    share.setMax(value);
                    maxMap.put(name,value);
//                    System.out.println("max value = "+value);
                }

            }else{
                share.setMax(value);
                maxMap.put(name,value);
            }

        }

        for (int i = 0; i < shares.size(); i++) {
            Share share = shares.get(i);
            float v = share.getMax() - share.getMin();
            System.out.println("v = "+v);
            if(v > offsetMax){
                offsetMax = v;
                offsetnName = share.getName();
            }
        }

        //涨幅最大的股票: ELM  涨幅增值: 999.92
        System.out.println("涨幅最大的股票: "+offsetnName+"  涨幅增值: "+offsetMax);

    }

    public static boolean isNumeric(String str){

        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if(isNum.matches() ){
            return true;
        }
        return false;
    }
}
