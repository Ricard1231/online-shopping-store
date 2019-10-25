package ricard.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;

import model.User;
import model.UserDAO;

@Results({ @Result(name = "success", location = "/login.jsp"),
	@Result(name = "error", location = "/jsp/forgotpasserror.jsp"), @Result(name = "input", location = "/forgotPass.jsp") })
public class ForgotPassAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username, pin, password, cpw;
	User obUser;
	UserDAO obDAO = new UserDAO();
	
	@Action(value="/forgotpass")
	public String execute() {
		if(obDAO.checkPin(username, pin)){
			obDAO.changePass(username, password);
			return SUCCESS;
		}
		else return ERROR;
	}

	public String getUsername() {
		return username;
	}

	@RequiredFieldValidator(message = "*Username is required")
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPin() {
		return pin;
	}

	@RequiredFieldValidator(message = "*PIN is required")
	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getPassword() {
		return password;
	}

	@RequiredFieldValidator(message = "*New password is required")
	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpw() {
		return cpw;
	}

	@RequiredFieldValidator(message = "*Confirm new password is required")
	public void setCpw(String cpw) {
		this.cpw = cpw;
	}
	
}
