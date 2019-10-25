package model;

import java.io.Serializable;

public class Item implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int idItem;
private double iprice;
private String iname, idesc;
public int getIdItem() {
	return idItem;
}
public void setIdItem(int idItem) {
	this.idItem = idItem;
}
public double getIprice() {
	return iprice;
}
public void setIprice(double iprice) {
	this.iprice = iprice;
}
public String getIname() {
	return iname;
}
public void setIname(String iname) {
	this.iname = iname;
}
public String getIdesc() {
	return idesc;
}
public void setIdesc(String idesc) {
	this.idesc = idesc;
}

}
