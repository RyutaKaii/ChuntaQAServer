package com.controller.chuntaqa.response;

/**
 * レスポンスエラー用Beanクラス.<br>
 * エラー発生時に使用される。
 */
public class ResError {
	/**
	 * code.<br>
	 * リクエスト種別を表す。
	 */
	private String code;

	/**
	 * message.<br>
	 * エラー内容を表す。
	 */
	private String message;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * コンストラクタ.<br>
	 * エラーメッセージを設定する.<br>
	 * codeは固定で"-1"を設定する。
	 */
	public ResError(String message) {
		this.code = "-1";
		this.message = message;
	}
}
