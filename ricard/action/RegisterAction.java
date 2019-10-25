package ricard.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;

import model.User;
import model.UserDAO;

@Action(value="/register")
@Results({ @Result(name = "success", location = "/login.jsp"),
	@Result(name = "error", location = "/jsp/registererror.jsp"),
	@Result(name = "input", location = "/register.jsp") })
public class RegisterAction extends ActionSupport implements ModelDriven<User> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserDAO obDAO = new UserDAO();
	User obUser;
	private String username, password, cpw, email, gender, city, address, cardnum, cardpw, pin, interest;

	public String execute() {
		obDAO.saveInfo(obUser);
		System.out.println("Inserted");
		return SUCCESS;
	}

	public void validate() {
		if (username.trim().equals("")) {
			super.addFieldError("username", "*Username field must not be empty!");
		}
		if (username.length() < 5 || username.length() > 15) {
			super.addFieldError("username", "*Username length must be between 5-15 characters!");
		}
		if (!password.equals(cpw)) {
			super.addFieldError("password", "*Password field doesn't match confirm password field!");
		}
		if (password.equals("")) {
			super.addFieldError("password", "*Password field must not be empty!");
		}
		if (cpw.equals("")) {
			super.addFieldError("cpw", "*Please confirm your password!");
		}
		if (password.length() < 3 || password.length() > 15) {
			super.addFieldError("password", "*Password length must be between 3-15 characters!");
		}

		String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z] {2,}$";
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(email);
		boolean isMatched = matcher.matches();
		if (email.equals(""))
			super.addFieldError("email", "*Email field must not be empty!");
		else if (isMatched == false) {
			super.addFieldError("email", "*Email address is invalid");
		}
		if (address.trim().equals("")) {
			super.addFieldError("address", "*Address field must not be empty!");
		}
		if (cardnum.trim().equals("")) {
			super.addFieldError("cardnum", "*Card number field must not be empty!");
		}
		if (cardpw.trim().equals("")) {
			super.addFieldError("cardpw", "*Card password field must not be empty!");
		}
		if (pin.trim().equals("")) {
			super.addFieldError("pin", "*PIN field must not be empty!");
		}
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpw() {
		return cpw;
	}

	public void setCpw(String cpw) {
		this.cpw = cpw;
	}

	public String getEmail() {
		return email;
	}

	@RequiredFieldValidator(message = "*Email is required")
	@EmailValidator(message="*Email format is invalid")
	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	@RequiredFieldValidator(message = "*City is required")
	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	@RequiredFieldValidator(message = "*Address is required")
	public void setAddress(String address) {
		this.address = address;
	}

	public String getCardnum() {
		return cardnum;
	}

	@RequiredFieldValidator(message = "*Card number is required")
	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}

	public String getCardpw() {
		return cardpw;
	}

	@RequiredFieldValidator(message = "*Card password is required")
	public void setCardpw(String cardpw) {
		this.cardpw = cardpw;
	}

	public String getPin() {
		return pin;
	}

	@RequiredFieldValidator(message = "*PIN is required")
	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		obUser = new User();
		return obUser;
	}

}