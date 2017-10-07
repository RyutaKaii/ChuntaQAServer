package com.controller.chuntaqa.request;

import java.util.List;

/**
 * リクエストselect用Beanクラス.<br>
 * select時に使用される。
 */
public class ReqSelect {
	/**
	 * code.<br>
	 * リクエスト種別を表す。
	 */
	private String code;

	/**
	 * title.<br>
	 * titleを表す。
	 */
	private String title;

	/**
	 * query.<br>
	 * リクエストクエリを表す。
	 */
	private List<ReqQuery> query;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<ReqQuery> getQuery() {
		return query;
	}
	public void setQuery(List<ReqQuery> query) {
		this.query = query;
	}
}
