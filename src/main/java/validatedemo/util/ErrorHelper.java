package validatedemo.util;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

@Service()
public class ErrorHelper {

	@Autowired
	private MessageSourceHelper messageSource;
	/**
	 * 将binderror转换成ajax错误提示
	 * ***/
	public ValidationResponse converBindError2AjaxError(BindingResult result){
		ValidationResponse res = new ValidationResponse();
		try{
		res.setStatus(StatusConstants.FAIL);
//		List<FieldError> allErrors = result.getFieldErrors();
		List<ErrorMessage> errorMesages = new ArrayList<ErrorMessage>();
	/*	for (FieldError objectError : allErrors) {
			errorMesages.add(new ErrorMessage(objectError.getField(),MessageFormat.format( messageSource.getMessage(StringUtils.join(new Object[]{objectError.getCode(),objectError.getObjectName(),objectError.getField()}, ".")), objectError.getArguments())));
		}*/
		//设置自定义ERROR
		List<ObjectError> objectErrors = result.getAllErrors();
		for (ObjectError objError : objectErrors){
			if ( objError instanceof FieldError){
				FieldError objectError = (FieldError) objError;
				errorMesages.add(new ErrorMessage(objectError.getField(),MessageFormat.format( messageSource.getMessage(StringUtils.join(new Object[]{objectError.getCode(),objectError.getObjectName(),objectError.getField()}, ".")), objectError.getArguments())));
			}else{
				errorMesages.add(new ErrorMessage(objError.getCode(), objError.getDefaultMessage()));
			}
		}
		res.setErrorMessageList(errorMesages);
		}catch(Exception e){
			//ignor
		}
		return res;
	}
}
