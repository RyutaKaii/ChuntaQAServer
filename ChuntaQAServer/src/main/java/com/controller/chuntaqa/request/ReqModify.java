package com.controller.chuntaqa.request;

import java.util.List;

/**
 * リクエスト更新用Beanクラス.<br>
 * insert、update時に使用される。
 */
public class ReqModify {
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
	 * record.<br>
	 * リクエストレコードを表す。
	 */
	private List<ReqRecord> record;

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
	public List<ReqRecord> getRecord() {
		return record;
	}
	public void setRecord(List<ReqRecord> record) {
		this.record = record;
	}

}
