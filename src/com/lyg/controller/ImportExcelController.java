package com.lyg.controller;

import com.flatform.frame.core.utils.StringUtil;
import com.lyg.entitys.Person;
import com.lyg.excel.ImportExcelUtil;
import com.lyg.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("excel")
public class ImportExcelController {

    @Autowired
    private IPersonService personService;

    /**
     * 往person表中导入数据， id自增， name，age，sex 从excel中取值
     * CREATE TABLE `person` (
     *    `id` int(10) NOT NULL auto_increment,
     *    `name` varchar(50) default NULL,
     *    `age` varchar(50) default NULL,
     *    `sex` varchar(50) default NULL,
     *    PRIMARY KEY  (`id`)
     *  ) ENGINE=InnoDB DEFAULT CHARSET=utf8
     *
     */
    //ModelAndView
    @RequestMapping("importEcxel.do")
    public ModelAndView importExcel(HttpServletRequest request, HttpServletResponse response, HttpSession session,
                                    MultipartFile file,ModelAndView mode) throws Exception {

        if (null == file || file.isEmpty()) {
            request.setAttribute("code","4000");
            request.setAttribute("msg","文件不能为空");
            return new ModelAndView("page/importExcel");
        }
        // List<List<String>> excelTitle = ImportExcelUtil.getExcelTitle(file);
        //System.out.println("表头："+excelTitle);
        List<List<Map<String ,Object>>> listData = null;
        listData = ImportExcelUtil.getListFromExcelSheet1(file); //这个时候将获得的excel文件进行处理；
        System.out.println("数据："+listData);
        //从1开始，0是表头
        for (int i = 1; i < listData.size(); i++) {
            List<Map<String, Object>> maps = listData.get(i);
            System.out.println(maps);
            Person person = new Person();
            for (Map<String, Object> dataMap : maps){
                //表头和自段名一样
                if(dataMap.containsKey("name")){
                    person.setName(String.valueOf(dataMap.get("name")));
                }
                if(dataMap.containsKey("age")){
                    person.setAge(String.valueOf(dataMap.get("age")));
                }
                if(dataMap.containsKey("sex")){
                    person.setSex(String.valueOf(dataMap.get("sex")));
                }
            }
            personService.insertPerson(person);
            person = null;
        }
        request.setAttribute("code","0000");
        request.setAttribute("msg","上传成功");
        return new ModelAndView("page/importExcel");

    }

}
