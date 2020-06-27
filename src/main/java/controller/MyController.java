package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","springmvc:hello world");
        mv.addObject("fun","执行的是doSome（）方法");
        mv.setViewName("show");
        return mv;
    }

    @RequestMapping(value = "/other.do")
    public ModelAndView doOther(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","springmvc:hello world");
        mv.addObject("fun","执行的是doOther（）方法");
        mv.setViewName("other");
        return mv;
    }

}
