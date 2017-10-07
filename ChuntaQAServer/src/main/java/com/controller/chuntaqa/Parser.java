package com.controller.chuntaqa;

import java.util.List;

import com.controller.chuntaqa.request.ReqDelete;
import com.controller.chuntaqa.request.ReqModify;
import com.controller.chuntaqa.request.ReqSelect;
import com.controller.chuntaqa.response.ResError;
import com.controller.chuntaqa.response.ResRecord;
import com.google.gson.Gson;

/**
 * Parserクラス.<br>
 * json文字列⇔オブジェクト変換を行う。
 */
public class Parser {
	/**
	 * json文字列 → ReqSelectオブジェクト.
	 */
	public static ReqSelect getReqSelectDto(String json) {
		return new Gson().fromJson(json, ReqSelect.class);
	}

	/**
	 * json文字列 → ReqModifyオブジェクト.
	 */
	public static ReqModify getReqModifyDto(String json) {
		return new Gson().fromJson(json, ReqModify.class);
	}

	/**
	 * json文字列 → ReqDeleteオブジェクト.
	 */
	public static ReqDelete getReqDeleteDto(String json) {
		return new Gson().fromJson(json, ReqDelete.class);
	}

	/**
	 * ResRecordリストオブジェクト → json文字列.
	 */
	public static String getJson(List<ResRecord> resRecordList) {
		return new Gson().toJson(resRecordList);
	}

	/**
	 * ResErrorオブジェクト → json文字列.
	 */
	public static String getJson(ResError resError) {
		return new Gson().toJson(resError);
	}
}
