package controller;

import domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @RequestMapping(value = "/receiveproperty.do")
    public ModelAndView doSome(String name , Integer age){
        System.out.println("doSome, name="+name+"   age="+age);
        ModelAndView mv=new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        mv.setViewName("show");
        return mv;
    }

    @RequestMapping(value = "/receiveparam.do")
    public ModelAndView receiveParam(@RequestParam(value = "rname" , required = false) String name ,
                                     @RequestParam(value = "rage" , required = false) Integer age){
        System.out.println("doSome, name="+name+"   age="+age);
        ModelAndView mv=new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        mv.setViewName("show");
        return mv;
    }

    @RequestMapping(value = "receiveobject.do")
    public ModelAndView receiveParam( Student myStudent){
        System.out.println("receiveParam, name="+myStudent.getName()+"   age="+myStudent.getAge());
        ModelAndView mv=new ModelAndView();
        mv.addObject("myname",myStudent.getName());
        mv.addObject("myage",myStudent.getAge());
        mv.addObject("mystudent",myStudent);
        mv.setViewName("show");
        return mv;
    }
}
