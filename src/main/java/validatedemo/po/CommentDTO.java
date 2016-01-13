package validatedemo.po;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;


//@Sign(md5Fields={"ip","text","key","sign"},keyName="key",keyRef="md5Bean")
@Component("commentDto")
public class CommentDTO {

    @NotEmpty
    @Length(min=5,max = 140)
    private String text;
    
    private String ip;
    
    private String sign;
 
    //必需有的字段，在判断的时候，会通过对象自动设置
    String key;
        
    public CommentDTO() {

    }
    
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        
        this.sign = sign;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
}
