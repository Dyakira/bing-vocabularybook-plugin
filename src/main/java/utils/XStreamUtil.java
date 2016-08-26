package utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.File;

/**
 * Created by Dyakira on 2016/8/26.
 */
public class XStreamUtil
{
    public static <T> T toBean(String xmlPath, Class<T> cls)
    {
        File FileIn = new File(xmlPath);
        if (!FileIn.exists()) return null;

        XStream xstream = new XStream(new DomDriver());
        xstream.ignoreUnknownElements();
        xstream.processAnnotations(cls);
        @SuppressWarnings("unchecked")
        T t = (T) xstream.fromXML(FileIn);
        return t;
    }
}
