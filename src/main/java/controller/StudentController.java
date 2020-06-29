package controller;

import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.StudentService;
import service.impl.StudentServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student){
        String msg = "注册失败";
        ModelAndView mv = new ModelAndView();
        int nums = studentService.addStudent(student);
        if( nums > 0){
            msg = "学生【" + student.getName() + "】注册成功";
        }
        mv.addObject("msg" , msg);
        mv.setViewName("result");
        return mv;
    }

    //处理查询，响应ajax
    @RequestMapping("/queryStudent.do")
    @ResponseBody
    public List<Student> queryStudent(){
        //参数检查， 简单的数据处理
        List<Student> students = studentService.findStudents();
        return students;
    }
}
