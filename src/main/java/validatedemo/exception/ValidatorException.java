
package validatedemo.exception;

import lombok.Getter;
import validatedemo.util.ValidationResponse;

/**
 * 类描述:验证异常.
 **/
public class ValidatorException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 3518217142639784679L;
    
    @Getter
    private ValidationResponse validationRes;
    
    public ValidatorException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }
    
    public ValidatorException(String message, ValidationResponse validationRes) {
        super(message);
        // TODO Auto-generated constructor stub
        this.validationRes =  validationRes;
    }

    

}
