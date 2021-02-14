package com.zj.baseservice.utils;

import com.zj.baseservice.common.OutdoorException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class JwtUtils {

    private JwtUtils(){
        throw new OutdoorException("请勿对工具类进行实例化", 20001);
    }

    public static final long EXPIRE = 1000 * 60 * 60 * 24;// token 时效
    public static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO";// 秘钥

    // 根据id nickname 生成token字符串的方法
    public static String getJwtToken(Long id, String nickname) {

        String jwtToken = Jwts.builder()
                // 第一部分：头部header，使用base64加密构成第一部分
                .setHeaderParam("typ", "JWT")// 声明类型
                .setHeaderParam("alg", "HS256")// 声明加密算法

                // 第二部分：载荷payload，存放信息，进行base64加密，构成第二部分
                .setSubject("outdoor-user")// jwt面向的用户
                .setIssuedAt(new Date())// jwt的签发时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))// jwt过期时间
                .claim("id", id)// 设置token主体部分,存储用户信息
                .claim("nickname", nickname)//可以设置多个

                // 第三部分：签名signature
                // 将用base64加密后的header和base64加密后的payload使用"."连接成字符串
                // 然后将组合字符串通过header中声明的加密算法并加盐值secret进行组合加密，构成jwt的第三部分，即签名
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();
        return  jwtToken;
    }

    /**
     * 判断token是否存在与有效
     *
     * @param jwtToken
     * @return
     */
    public static boolean checkToken(String jwtToken) {
        if (StringUtils.isEmpty(jwtToken)) return false;
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断token是否存在与有效
     *
     * @param request
     * @return
     */
    public static boolean checkToken(HttpServletRequest request) {
        try {
            String jwtToken = request.getHeader("token");
            if (StringUtils.isEmpty(jwtToken)) return false;
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 根据token获取会员id
     *直接返回用户id 解析后根据id查
     * @param
     * @return
     */
    public static Claims getMemberIdByJwtToken(HttpServletRequest request) {
        String token = request.getHeader("token");
       if (StringUtils.isEmpty(token)) return null;
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return claims;
    }
}

