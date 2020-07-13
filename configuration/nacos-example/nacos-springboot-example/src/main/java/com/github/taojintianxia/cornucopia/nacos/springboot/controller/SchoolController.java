package com.github.taojintianxia.cornucopia.nacos.springboot.controller;

import com.github.taojintianxia.cornucopia.nacos.springboot.config.ClassRoomConfig;
import com.github.taojintianxia.cornucopia.nacos.springboot.config.DynamicSchoolConfig;
import com.github.taojintianxia.cornucopia.nacos.springboot.config.SchoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Nianjun Sun
 * @date 2019-08-20 18:53
 */
@Controller
@RequestMapping("school")
public class SchoolController {

    @Autowired
    private ClassRoomConfig classRoomConfig;

    @Autowired
    private SchoolConfig schoolConfig;

    @Autowired
    private DynamicSchoolConfig dynamicSchoolConfig;

    @ResponseBody
    @RequestMapping(value = "/getSchool", method = GET)
    public String getSchool() {
        return "学校面积 : " + schoolConfig.getArea() + "\n学校等级 : " + schoolConfig.getLevel();
    }

    @ResponseBody
    @RequestMapping(value = "/getClassroom", method = GET)
    public String getClassroom() {
        return "教室面积 : " + classRoomConfig.getArea() + "\n教室座椅数量 : " + classRoomConfig.getChairNumber() + "\n是否是老教室 : "
                + classRoomConfig.isLegacy();
    }

    @ResponseBody
    @RequestMapping(value = "/getDynamicSchool", method = GET)
    public String getDynamicSchool() {
        return "学校校长 : " + dynamicSchoolConfig.getPrincipal() + " \n 学校地址 : " + dynamicSchoolConfig.getLocation();
    }
}
