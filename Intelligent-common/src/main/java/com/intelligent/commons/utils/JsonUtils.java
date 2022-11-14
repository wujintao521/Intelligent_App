package com.intelligent.commons.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.ResourceUtils;

import java.io.*;

public class JsonUtils {

    /**
     * 解析json内容
     */
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = ResourceUtils.getFile(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 拼接json数组
     */
    public static JSONArray joinJSONArray(JSONArray array1, JSONArray array2) {
        StringBuffer sbf = new StringBuffer();
        JSONArray jSONArray = new JSONArray();
        try {
            int len = array1.size();
            for (int i = 0; i < len; i++) {
                JSONObject obj1 = (JSONObject) array1.get(i);
                if (i == len - 1)
                    sbf.append(obj1.toString());
                else
                    sbf.append(obj1.toString()).append(",");
            }
            len = array2.size();
            if (len > 0)
                sbf.append(",");
            for (int i = 0; i < len; i++) {
                JSONObject obj2 = (JSONObject) array2.get(i);
                if (i == len - 1)
                    sbf.append(obj2.toString());
                else
                    sbf.append(obj2.toString()).append(",");
            }
            sbf.insert(0, "[").append("]");
            jSONArray = jSONArray.parseArray(sbf.toString());
            return jSONArray;
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        String caseJsonString = readJsonFile("文件存放路径");
    }
}
