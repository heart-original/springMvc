package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

    @RequestMapping(value = "/returnVoid-ajax.do")
    public void doReturnVoidAjax(HttpServletResponse response, String name, Integer age) throws IOException {
        System.out.println("===doReturnVoidAjax====, name="+name+"   age="+age);
        //处理ajax， 使用json做数据的格式
        //service调用完成了， 使用Student表示处理结果
        Student student  = new Student();
        student.setName(name);
        student.setAge(age);

        String json = "";
        //把结果的对象转为json格式的数据
        if( student != null){
            ObjectMapper om  = new ObjectMapper();
            json  = om.writeValueAsString(student);
            System.out.println("student转换的json===="+json);
        }

        //输出数据，响应ajax的请求
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw  = response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();

    }

    @RequestMapping(value = "/returnStudentJson.do")
    @ResponseBody
    public Student doStudentJsonObject(String name, Integer age) {

        Student student = new Student();
        student.setName("李四同学");
        student.setAge(20);
        return student; // 会被框架转为json

    }

    @RequestMapping(value = "/returnStudentJsonArray.do")
    @ResponseBody
    public List<Student> doStudentJsonObjectArray(String name, Integer age) {

        List<Student> list = new ArrayList<>();

        Student student = new Student();
        student.setName("李四同学");
        student.setAge(20);
        list.add(student);

        student = new Student();
        student.setName("张三");
        student.setAge(28);
        list.add(student);


        return list;

    }

    @RequestMapping(value = "/returnStringData.do",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String doStringData(String name,Integer age){
        return "Hello SpringMVC 返回对象，表示数据";
    }

}
