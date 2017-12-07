package com.ma.util;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by Administrator on 2017/11/30 0030.
 */
public class RequestHandler {

    private String nodeName;
    private String type;
    private Object value;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }


    public static List<RequestHandler> URIHandler(HttpServletRequest request){

        List<RequestHandler> requestHandlerList = new ArrayList<>();
        Enumeration<String> enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()){

            String key = enumeration.nextElement();
            String value = request.getParameter(key);
            //value = new String(value.getBytes("ISO8859-1"),"UTF-8");
            try {
                value = new String(value.getBytes("ISO8859-1"),"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            if(key.startsWith("q_") && !"".equals(key) && value != null && !"".equals(value)) {
                //q_nodeName_like_s/i
                String[] params = key.split("_");

                if(params.length != 4) {
                    throw new IllegalArgumentException("查询条件异常");
                }

                RequestHandler requestHandler = new RequestHandler();
                requestHandler.setNodeName(params[1]);
                requestHandler.setType(params[2]);

                requestHandler.setValue(valueHandler(params[3],value));

                requestHandlerList.add(requestHandler);
            }
        }
        return requestHandlerList;
    }

    private static Object valueHandler(String type,String value) {

        if("s".equals(type)) {
            return value;
        }else if("i".equals(type)) {
            return Integer.parseInt(value);
        }else if("bd".equalsIgnoreCase(type)) {
            return new BigDecimal(value);
        }

        return null;
    }

}
