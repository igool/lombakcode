package validatedemo.util;

import java.util.List;

/**
 * 验证返回信息集合
 * ***/
public class ValidationResponse {
	private String status;
	private List<ErrorMessage> errorMessageList;
	private Object object;
	
	public Object getObject()
	{
		return object;
	}
	public void setObject(Object object)
	{
		this.object = object;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<ErrorMessage> getErrorMessageList() {
		return this.errorMessageList;
	}
	public void setErrorMessageList(List<ErrorMessage> errorMessageList) {
		this.errorMessageList = errorMessageList;
	}
	
}
