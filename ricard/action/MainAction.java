package ricard.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import model.Item;
import model.ItemDAO;

public class MainAction extends ActionSupport implements ServletResponseAware, ServletRequestAware{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private ArrayList<String> listOfProducts = new ArrayList<String>();
private String id;

protected HttpServletResponse servletResponse;
@Override
public void setServletResponse(HttpServletResponse servletResponse) {
  this.servletResponse = servletResponse;
}

protected HttpServletRequest servletRequest;
@Override
public void setServletRequest(HttpServletRequest servletRequest) {
  this.servletRequest = servletRequest;
}

@Action(value="/main", results = {@Result(name = "success", location = "/main.jsp")})
public String execute() {
	Cookie picture = new Cookie("id", id);
	  picture.setMaxAge(60*60*24);
	  servletResponse.addCookie(picture);
	populateListOfProducts();
	return SUCCESS;
}

public void populateListOfProducts() {
	listOfProducts.add("A");
	listOfProducts.add("B");
	listOfProducts.add("C");
	listOfProducts.add("Kodomo");
}

public ArrayList<String> getListOfProducts() {
	return listOfProducts;
}

public void setListOfProducts(ArrayList<String> listOfProducts) {
	this.listOfProducts = listOfProducts;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

}
