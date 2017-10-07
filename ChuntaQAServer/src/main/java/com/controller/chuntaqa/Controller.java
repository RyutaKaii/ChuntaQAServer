package com.controller.chuntaqa;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controller.chuntaqa.request.ReqDelete;
import com.controller.chuntaqa.request.ReqModify;
import com.controller.chuntaqa.request.ReqSelect;
import com.controller.chuntaqa.response.ResError;
import com.controller.chuntaqa.response.ResRecord;

/**
 * RestController.<br>
 * リクエストURLに応じて処理を振り分けて実行し結果を返却する。
 */
@RestController
public class Controller {

	/**
	 * select.<br>
	 * 処理成功時は結果を返却する。
	 */
	@RequestMapping(value = "/select")
	public String select(@RequestBody String body) {
		try {
			ReqSelect reqSelect = Parser.getReqSelectDto(body);

			Model model = new Model();
			List<ResRecord> resRecordList = model.select(reqSelect);

			return Parser.getJson(resRecordList);
		} catch (Exception e) {
			e.printStackTrace();
			return Parser.getJson(new ResError(e.getMessage()));
		}
	}

	/**
	 * insert.<br>
	 * 処理成功時はリクエストボディをそのまま返却する。
	 */
	@RequestMapping(value = "/insert")
	public String insert(@RequestBody String body) {
		try {
			ReqModify reqModify = Parser.getReqModifyDto(body);

			Model model = new Model();
			model.insert(reqModify);

			return body;
		} catch (Exception e) {
			e.printStackTrace();
			return Parser.getJson(new ResError(e.getMessage()));
		}
	}

	/**
	 * update.<br>
	 * 処理成功時はリクエストボディをそのまま返却する。
	 */
	@RequestMapping(value = "/update")
	public String update(@RequestBody String body) {
		try {
			ReqModify reqModify = Parser.getReqModifyDto(body);

			Model model = new Model();
			model.update(reqModify);

			return body;
		} catch (Exception e) {
			e.printStackTrace();
			return Parser.getJson(new ResError(e.getMessage()));
		}
	}

	/**
	 * delete.<br>
	 * 処理成功時はリクエストボディをそのまま返却する。
	 */
	@RequestMapping(value = "/delete")
	public String delete(@RequestBody String body) {
		try {
			ReqDelete reqDelete = Parser.getReqDeleteDto(body);

			Model model = new Model();
			model.delete(reqDelete);

			return body;
		} catch (Exception e) {
			e.printStackTrace();
			return Parser.getJson(new ResError(e.getMessage()));
		}
	}
}
