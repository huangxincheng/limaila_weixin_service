package com.limaila.limaila_weixin_service.helper.base;

import com.thoughtworks.xstream.XStream;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

public class XStreamHelper {

    private static final Logger logger = LoggerFactory.getLogger(XStreamHelper.class);

    public static <T> T toBean(Class<T> clazz, String xml) {
        try {
            XStream xstream = new XStream();
            xstream.processAnnotations(clazz);
            xstream.autodetectAnnotations(true);
            xstream.setClassLoader(clazz.getClassLoader());
            return (T) xstream.fromXML(xml);
        } catch (Exception e) {
            logger.error("[XStream]XML转对象出错:{}", e.getCause());
            throw new RuntimeException("[XStream]XML转对象出错");
        }
    }
}
