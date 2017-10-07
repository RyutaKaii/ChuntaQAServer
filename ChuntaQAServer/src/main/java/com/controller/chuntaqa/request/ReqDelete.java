package com.controller.chuntaqa.request;

/**
 * リクエスト削除用Beanクラス.<br>
 * delete時に使用される。
 */
public class ReqDelete {
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
	 * no.<br>
	 * リクエストnoを表す。
	 */
	private String no;

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
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
}
