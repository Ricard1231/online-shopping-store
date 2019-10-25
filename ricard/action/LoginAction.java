package ricard.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;

import model.UserDAO;

@Results({ @Result(name = "success", location = "/jsp/loginOk.jsp"),
		@Result(name = "error", location = "/jsp/loginerror.jsp"), @Result(name = "input", location = "/login.jsp") })
public class LoginAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	protected HttpServletResponse response;
	protected HttpServletRequest request;
	private String username, password;
	UserDAO obDAO = new UserDAO();

	@Action(value = "/login")
	public String execute() {
		if (obDAO.checkLogin(username, password)) {
			Cookie c = new Cookie("username", username);
			c.setMaxAge(24 * 60 * 60);
			response.addCookie(c);
			HttpSession session = request.getSession();
			session.setAttribute("user", username);
			return SUCCESS;
		}else
			return ERROR;
	}

	public String getUsername() {
		return username;
	}

	@RequiredFieldValidator(message = "*Username required")
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	@RequiredFieldValidator(message = "*Password required")
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

}
