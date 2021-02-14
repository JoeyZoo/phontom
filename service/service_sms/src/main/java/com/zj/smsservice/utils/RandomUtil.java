package com.zj.smsservice.utils;

import java.util.Random;

/**
 * 获取随机数作为验证码
 */
public class RandomUtil {
	public static String getSix() {
		Random r = new Random();
		return String.valueOf(r.nextInt(900000)+100000) ;
	}
}
