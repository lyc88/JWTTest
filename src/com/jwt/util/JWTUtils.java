package com.jwt.util;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import com.google.common.collect.Maps;

/**
 * JWTUtils工具token生成器 
 * @Description: TODO
 * @author taohanlin
 * @date 2016年5月18日 下午3:07:33
 */
public class JWTUtils {
	//加密字段
	public static final String SECRET = "project";
	//签名
	private JWTSigner signer = null;
	//验证
	private JWTVerifier verifier = null;

	private JWTUtils() {
		signer = new JWTSigner(SECRET);
		verifier = new JWTVerifier(SECRET);
	}

	public static JWTUtils getInstance() {
		return JWTUtilsHolder.instance;
	}

	private static class JWTUtilsHolder {
		private static final JWTUtils instance = new JWTUtils();
	}

	// 通过userId获取token
	public String getToken(Long userId) {
		HashMap<String, Object> claims =Maps.newHashMap();
		claims.put("userId", userId);
		claims.put("time", Instant.now().getEpochSecond() + 86400);
		String token = signer.sign(claims);
		return token;
	}

	public String getCode(Map<String, Object> map) {
		return signer.sign(map);
	}

	// 通过token获取map对象
	public Map<String, Object> verify(String token) throws InvalidKeyException, NoSuchAlgorithmException,
			IllegalStateException, SignatureException, IOException, JWTVerifyException {
		Map<String, Object> verify = verifier.verify(token);
		return verify;
	}

	// 通过map对象获取userId
	public String GetUserId(String token) throws InvalidKeyException, NoSuchAlgorithmException, IllegalStateException,
			SignatureException, IOException, JWTVerifyException {
		Map<String, Object> map = new HashMap<String, Object>();
		map = JWTUtils.getInstance().verify(token);
		String userId = map.get("userId").toString();
		return userId;
	}

	// 通过map对象获取time
	public int GetTime(String token) throws InvalidKeyException, NoSuchAlgorithmException, IllegalStateException,
			SignatureException, IOException, JWTVerifyException {
		Map<String, Object> map = new HashMap<String, Object>();
		map = JWTUtils.getInstance().verify(token);
		Integer time = (Integer) map.get("time");
		return time;

	}
}
