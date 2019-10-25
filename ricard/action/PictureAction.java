package ricard.action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Item;
import model.ItemDAO;

@Action(value="/pictureAction", results = {@Result(name = "success", location = "/product.jsp")})
public class PictureAction extends ActionSupport implements ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ItemDAO obDAO = new ItemDAO();
	Item obItem;
	int id;
	int pid;
	ArrayList<Item> itemlist = null;
	
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
            .get(ServletActionContext.HTTP_REQUEST);


public String execute() {
	id = Integer.parseInt(request.getParameter("pid"));
	itemlist = obDAO.getInfoid(id);
	return SUCCESS;
}

public ArrayList<Item> getItemlist() {
	return itemlist;
}

public void setItemlist(ArrayList<Item> itemlist) {
	this.itemlist = itemlist;
}

public int getPid() {
	return pid;
}

public void setPid(int pid) {
	this.pid = pid;
}

@Override
public void setServletRequest(HttpServletRequest arg0) {
	// TODO Auto-generated method stub
	
}
}