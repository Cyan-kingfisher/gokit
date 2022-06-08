package org.example.reip.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.example.reip.constant.error.HttpCodeEnum;
import org.example.reip.exception.GraduException;

import java.util.Map;

public class JwtUtil {

    private static final String TOKEN_SECRET = "future";

    private static final String DATA_LOGIN = "userInfo";

    public static Map<String, Object> parseTokenToUser(String token) {
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);
        try {
            return jwt.getClaims().get(DATA_LOGIN).asMap();
        } catch (NullPointerException exception) {
            throw new GraduException("20703|UserInfo is null");
        }
    }

    /**
     * CurrentUser
     *
     * @param token jwt token
     * @return
     */
    public static String getCurrentUser(String token) {
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);
        Map<String, Object> parseRes = null;
        try {
            parseRes = jwt.getClaims().get(DATA_LOGIN).asMap();
        } catch (NullPointerException exception) {
            throw new GraduException("20703|UserInfo is null");
        }
        String phone = (String) parseRes.get("phone");
        AssertUtil.isTure(phone!=null&&phone.length()>10, HttpCodeEnum.PHONE_VALIDATOR);
        return phone;
    }

}
