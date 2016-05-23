package com.jwt.test;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.time.Instant;
import com.auth0.jwt.JWTVerifyException;
import com.jwt.util.JWTUtils;

public class Test {
	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, IllegalStateException, SignatureException, IOException, JWTVerifyException {
	//通过userId获取token
		String token=JWTUtils.getInstance().getToken(123L);
		System.out.println(token);
	//获取生成token的过期时间
		int EndTime = JWTUtils.getInstance().GetTime(token);
		if (EndTime<Instant.now().getEpochSecond()) {
			System.out.println("token已过期");
		}
	//通过token获取userId
		else{
			System.out.println("过期时间为:"+EndTime);
			String userId = JWTUtils.getInstance().GetUserId(token);
			System.out.println("userId为："+userId);
		}
		
}
}
