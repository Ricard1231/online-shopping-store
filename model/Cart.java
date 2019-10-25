package model;

import java.io.Serializable;

public class Cart implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String idcart, unamecart, itemname;

public String getIdcart() {
	return idcart;
}

public void setIdcart(String idcart) {
	this.idcart = idcart;
}

public String getUnamecart() {
	return unamecart;
}

public void setUnamecart(String unamecart) {
	this.unamecart = unamecart;
}

public String getItemname() {
	return itemname;
}

public void setItemname(String itemname) {
	this.itemname = itemname;
}

}
