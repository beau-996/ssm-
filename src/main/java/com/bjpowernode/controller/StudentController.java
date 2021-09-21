package com.bjpowernode.controller;

import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService  service ;
    //完成注册学生
    @RequestMapping("/addStudent.do")
public ModelAndView addStudent(Student student){
        ModelAndView mv = new ModelAndView();
        String tips = "注册失败";
        //调用service处理student
        int count = service.addStudent(student);
        if (count > 0) {
            //注册成功
            tips = "学生" + student.getName() + "注册成功";

        }
        //添加数据u
        mv.addObject("tips", tips);
        //指定结果页面
        mv.setViewName("result");

        return mv;


    }
    //处理查询，响应Ajax请求
    @RequestMapping("/queryStudent.do")
    @ResponseBody
    public List<Student> queryStudent(){
        //参数检查，简单数据处理
        List<Student> students= service.findStudents();
        return students;

    }
}
