package handler;

import exception.AgeException;
import exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = NameException.class)
    public ModelAndView doNameException(Exception exception){
        //处理NameException的异常。
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","姓名必须是张三，其它用户不能访问");
        mv.addObject("ex",exception);
        mv.setViewName("nameError");
        return mv;
    }


    @ExceptionHandler(value = AgeException.class)
    public ModelAndView doAgeException(Exception exception){
        //处理AgeException的异常。
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","你的年龄不能大于80");
        mv.addObject("ex",exception);
        mv.setViewName("ageError");
        return mv;
    }

    @ExceptionHandler
    public ModelAndView doOtherException(Exception exception){
        //处理其它异常
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","你的年龄不能大于80");
        mv.addObject("ex",exception);
        mv.setViewName("defaultError");
        return mv;
    }
}
