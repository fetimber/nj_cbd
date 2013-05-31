package com.fe.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.stringtree.json.ExceptionErrorListener;
import org.stringtree.json.JSONReader;
import org.stringtree.json.JSONValidatingReader;
import org.stringtree.json.JSONValidatingWriter;
import org.stringtree.json.JSONWriter;

@Component("jsonUtil")
@Scope("singleton")
public class JsonUtil {

    /**
     * 转化为JSON对象格式写入响应流
     *
     * @param response
     * @param map
     */
    @SuppressWarnings("unchecked")
    public void writeByJSONLib(HttpServletResponse response, Object obj) {
        JSONObject jsonObj = JSONObject.fromObject(obj);
        doResponse(response, jsonObj.toString());
    }

    private JSONWriter writer = new JSONValidatingWriter(
            new ExceptionErrorListener(), false);

    public void writeByStringtree(HttpServletResponse response, Object obj) {
        doResponse(response, writer.write(obj));
    }

    public String formatBeanByStringtree(Object obj) {
        return writer.write(obj);
    }

    public Object parseBeanByStringtree(String jsonStr) {
        return reader.read(jsonStr);
    }

    /**
     * 转化为JSON对象格式写入响应流
     *
     * @param response
     * @param obj      collection
     */
    @SuppressWarnings("unchecked")
    public void writeByJSONLib(HttpServletResponse response, Collection obj) {
        JSONArray arr = JSONArray.fromObject(obj);
        doResponse(response, arr.toString());

    }

    @SuppressWarnings("unchecked")
    public void writeByStringtree(HttpServletResponse response, Collection obj) {
        doResponse(response, writer.write(obj));
    }

    /**
     * 转化为JSON对象格式写入响应流
     *
     * @param response
     * @param obj      collection
     */
    @SuppressWarnings("unchecked")
    public void writeByJSONLib(HttpServletResponse response, Object[] obj) {
        JSONArray arr = JSONArray.fromObject(obj);
        doResponse(response, arr.toString());
    }

    public void writeByStringtree(HttpServletResponse response, Object[] obj) {
        doResponse(response, writer.write(obj));
    }

    public Object toBeanByJSONLib(String content) {
        JSONObject jsonObject = JSONObject.fromObject(content);
        Object bean = JSONObject.toBean(jsonObject);
        //System.out.println(bean);
        //List<Map> scrips = (List)PropertyUtils.getProperty(bean, "scrips");
        return bean;
    }

    private JSONReader reader = new JSONValidatingReader(
            new ExceptionErrorListener());

    public Object toBeanByStringtree(String content) {
        return reader.read(content);
    }

 
    /**
     * 将JSON格式的字符串写入响应流
     *
     * @param response
     * @param jsonStr
     * @throws IOException
     */
    private void doResponse(HttpServletResponse response, String jsonStr) {
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            if (writer != null) {
                writer.print(jsonStr);
                writer.flush();
            }
        } catch (Exception e) {
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

}
