package com.controller.chuntaqa;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.controller.chuntaqa.request.ReqDelete;
import com.controller.chuntaqa.request.ReqModify;
import com.controller.chuntaqa.request.ReqRecord;
import com.controller.chuntaqa.request.ReqSelect;
import com.controller.chuntaqa.response.ResRecord;

/**
 * Modelクラス.<br>
 * 永続化オブジェクトに対する操作を実行する。<br>
 * 全ての操作でオートコミットモードを用いる。<br>
 * openSession(true)とする。
 */
public class Model {
	/** resource. */
	private static String resource = "mybatis-config.xml";

	/**
	 * select.<br>
	 * 現時点では受け取ったtitleの値でselectする。
	 * @throws IOException
	 */
	public List<ResRecord> select(ReqSelect reqSelect) throws IOException {
		try (Reader in = Resources.getResourceAsReader(resource)) {
			return new SqlSessionFactoryBuilder().build(in).openSession(true).selectList("qa.mybatis.selectList", reqSelect.getTitle());
        } catch (IOException e) {
        	throw e;
        }
	}

	/**
	 * insert.<br>
	 * ユーザから受け取るnoは使用しない。<br>
	 * database側のautoincrement機能を使用する。
	 * @throws IOException
	 */
	public void insert(ReqModify reqModify) throws IOException {
		try (Reader in = Resources.getResourceAsReader(resource)) {
			Map<String, String> param = new HashMap<>();
			SqlSession session = new SqlSessionFactoryBuilder().build(in).openSession(true);

			for (ReqRecord reqRecord : reqModify.getRecord()) {
				param.put("title", reqModify.getTitle());
				param.put("question", reqRecord.getQuestion());
				param.put("answer", reqRecord.getAnswer());
				session.insert("qa.mybatis.insertOne", param);

				param.clear();
			}
        } catch (IOException e) {
        	throw e;
        }
	}

	/**
	 * update.
	 * @throws IOException
	 */
	public void update(ReqModify reqModify) throws IOException {
		try (Reader in = Resources.getResourceAsReader(resource)) {
			Map<String, String> param = new HashMap<>();
			SqlSession session = new SqlSessionFactoryBuilder().build(in).openSession(true);

			for (ReqRecord reqRecord : reqModify.getRecord()) {
				param.put("title", reqModify.getTitle());
				param.put("no", reqRecord.getNo());
				param.put("question", reqRecord.getQuestion());
				param.put("answer", reqRecord.getAnswer());
				session.update("qa.mybatis.updateOne", param);

				param.clear();
			}
        } catch (IOException e) {
        	throw e;
        }
	}

	/**
	 * delete.
	 * @throws IOException
	 */
	public void delete(ReqDelete reqDelete) throws IOException {
		try (Reader in = Resources.getResourceAsReader(resource)) {
			Map<String, String> param = new HashMap<>();
			param.put("title", reqDelete.getTitle());
			param.put("no", reqDelete.getNo());

			SqlSession session = new SqlSessionFactoryBuilder().build(in).openSession(true);
			session.delete("qa.mybatis.deleteOne", param);
        } catch (IOException e) {
        	throw e;
        }
	}
}
