package com.rms.redis.utils;


import com.alibaba.fastjson.JSONObject;
/**
 * json  工具类
 * @author yezhaoyi
 *
 */
public class JsonUtils {
	/**
	 * 对象转json
	 * @param object
	 * @return
	 */
	public static String object2Json(Object object) {
		if (null != object) {
			return JSONObject.toJSONString(object);
		}
		return null;
	}
	/**
	 * json  转对象
	 * @param strJson   
	 * @param objectClass
	 * @return
	 */
	public static <T> T json2Ojbect(String strJson, Class<T> objectClass) {
		if (!StringUtils.isEmpty(strJson)) {
			JSONObject parseObject = JSONObject.parseObject(strJson);
			return parseObject.toJavaObject(objectClass);
		}
		return null;
	}
}
