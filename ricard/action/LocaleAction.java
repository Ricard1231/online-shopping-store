package ricard.action;

import org.apache.struts2.convention.annotation.Action;

import com.opensymphony.xwork2.ActionSupport;

public class LocaleAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Action(value="/Locale")
	public String execute() {
		return SUCCESS;
	}
}
