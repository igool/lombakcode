
package validatedemo.exception;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import validatedemo.util.MessageSourceHelper;

/**
 * 类描述:系统全局异常处理器.
 **/
@Controller
public class GlobleExceptionResolver implements  HandlerExceptionResolver {

    @Autowired
    private MessageSourceHelper sourceHelper;
    /**
     * 进行全局异常的过滤和处理
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex) {
        //handler为当前处理器适配器执行的对象
        ModelAndView modelAndView = new ModelAndView();
        String message = null;
        //判断是否为系统自定义异常。
        if(ex instanceof ValidatorException) {
            message = ((ValidatorException) ex).getMessage();
            modelAndView.addObject("validatorError", ((ValidatorException) ex).getValidationRes());
            modelAndView.setViewName("validatorerror");
        }else if (ex instanceof SQLException) {
            message = sourceHelper.getMessage("db.error");//"数据库执行出错";
            modelAndView.addObject("error", message);
            modelAndView.setViewName("database_error");
        } else {
            message = sourceHelper.getMessage("sys.error");//"系统出错啦，稍后再试试！";
          //跳转到相应的处理页面
            modelAndView.addObject("error", StringUtils.isNotEmpty(ex.getMessage()) ? ex.getMessage(): message);
            modelAndView.setViewName("error");
        }

        
        
        return modelAndView;
    }
}
