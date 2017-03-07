package com.giousa.test;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.giousa.test", appContext.getPackageName());
    }

    @Test
    public void importCsv()  {
        List<String> dataList=CSVUtils.importCsv(new File("/Users/zhangmengmeng/Downloads/values.csv"));
        if(dataList!=null && !dataList.isEmpty()){
            for(String data : dataList){
                System.out.println("------"+data);
            }
        }
    }
}
