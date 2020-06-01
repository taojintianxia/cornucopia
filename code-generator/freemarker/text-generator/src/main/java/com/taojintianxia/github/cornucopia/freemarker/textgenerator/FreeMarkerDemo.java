package com.taojintianxia.github.cornucopia.freemarker.textgenerator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Nianjun Sun
 * @date 2020/6/1 10:06
 */
public class FreeMarkerDemo {
    public static void main(String[] args) throws IOException, TemplateException {

        Configuration cfg = new Configuration(new Version("2.3.30"));

        cfg.setClassForTemplateLoading(FreeMarkerDemo.class, "/");
        cfg.setDefaultEncoding("UTF-8");

        Template template = cfg.getTemplate("test.ftl");

        Map<String, Object> templateData = new HashMap<>();
        templateData.put("msg", "Today is a beautiful day");

        try (StringWriter out = new StringWriter()) {

            template.process(templateData, out);
            System.out.println(out.getBuffer().toString());

            out.flush();
        }
    }
}
