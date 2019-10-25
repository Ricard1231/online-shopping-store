package ricard.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import model.Item;
import model.ItemDAO;

@Action(value="/searchbar", results = {@Result(name = "success", location = "/product.jsp")})
public class SearchAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String search;
	Item obItem;
	ItemDAO obDAO = new ItemDAO();
ArrayList<Item> itemlist = null;

public String execute() {
	itemlist = obDAO.getInfo(search);
	return SUCCESS;
}

public String getSearch() {
	return search;
}

public void setSearch(String search) {
	this.search = search;
}

public ArrayList<Item> getItemlist() {
	return itemlist;
}

public void setItemlist(ArrayList<Item> itemlist) {
	this.itemlist = itemlist;
}



}
