package nz.co.zufang.spec;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.mobile.device.Device;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import nz.co.zufang.model.CerberusUser;

public class TokenUtils {

  private final Logger logger = Logger.getLogger(this.getClass());

  public static final String AUDIENCE_UNKNOWN   = "unknown";
  public static final String AUDIENCE_WEB       = "web";
  public static final String AUDIENCE_MOBILE    = "mobile";
  public static final String AUDIENCE_TABLET    = "tablet";

  public static String secret = "sssshhhh!";

//  public static Long expiration = 604800l;
  public static Long expiration = 300l;

  public static String getUsernameFromToken(String token) {
    String username;
    try {
      final Claims claims = getClaimsFromToken(token);
      username = claims.getSubject();
    } catch (Exception e) {
      username = null;
    }
    return username;
  }

  public static Date getCreatedDateFromToken(String token) {
    Date created;
    try {
      final Claims claims = getClaimsFromToken(token);
      created = new Date((Long) claims.get("created"));
    } catch (Exception e) {
      created = null;
    }
    return created;
  }

  public static Date getExpirationDateFromToken(String token) {
    Date expiration;
    try {
      final Claims claims = getClaimsFromToken(token);
      expiration = claims.getExpiration();
    } catch (Exception e) {
      expiration = null;
    }
    return expiration;
  }

  public static String getAudienceFromToken(String token) {
    String audience;
    try {
      final Claims claims = getClaimsFromToken(token);
      audience = (String) claims.get("audience");
    } catch (Exception e) {
      audience = null;
    }
    return audience;
  }

  public static Claims getClaimsFromToken(String token) {
    Claims claims;
    try {
      claims = Jwts.parser()
        .setSigningKey(secret)
        .parseClaimsJws(token)
        .getBody();
    } catch (Exception e) {
      claims = null;
    }
    return claims;
  }

  public static Date generateCurrentDate() {
    return new Date(System.currentTimeMillis());
  }

  public static Date generateExpirationDate() {
    return new Date(System.currentTimeMillis() + expiration * 1000);
  }

  public static Boolean isTokenExpired(String token) {
    final Date expiration = getExpirationDateFromToken(token);
    return expiration.before(generateCurrentDate());
  }

  public static Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
    return (lastPasswordReset != null && created.before(lastPasswordReset));
  }

  public static String generateAudience(Device device) {
    String audience = AUDIENCE_UNKNOWN;
    if (device.isNormal()) {
      audience = AUDIENCE_WEB;
    } else if (device.isTablet()) {
      audience = AUDIENCE_TABLET;
    } else if (device.isMobile()) {
      audience = AUDIENCE_MOBILE;
    }
    return audience;
  }

  public static Boolean ignoreTokenExpiration(String token) {
    String audience = getAudienceFromToken(token);
    return (AUDIENCE_TABLET.equals(audience) || AUDIENCE_MOBILE.equals(audience));
  }

  public static String generateToken(UserDetails userDetails, Device device) {
    Map<String, Object> claims = new HashMap<String, Object>();
    claims.put("sub", userDetails.getUsername());
    claims.put("audience", generateAudience(device));
    claims.put("created", generateCurrentDate());
    return generateToken(claims);
  }

  public static String generateToken(Map<String, Object> claims) {
    return Jwts.builder()
      .setClaims(claims)
      .setExpiration(generateExpirationDate())
      .signWith(SignatureAlgorithm.HS512, secret)
      .compact();
  }

  public static Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
    final Date created = getCreatedDateFromToken(token);
    return (!(isCreatedBeforeLastPasswordReset(created, lastPasswordReset)) && (!(isTokenExpired(token)) || ignoreTokenExpiration(token)));
  }

  public static String refreshToken(String token) {
    String refreshedToken;
    try {
      final Claims claims = getClaimsFromToken(token);
      claims.put("created", generateCurrentDate());
      refreshedToken = generateToken(claims);
    } catch (Exception e) {
      refreshedToken = null;
    }
    return refreshedToken;
  }

  public static Boolean validateToken(String token, UserDetails userDetails) {
    CerberusUser user = (CerberusUser) userDetails;
    final String username = getUsernameFromToken(token);
    final Date created = getCreatedDateFromToken(token);
    final Date expiration = getExpirationDateFromToken(token);
    return (username.equals(user.getUsername()) && !(isTokenExpired(token)) && !(isCreatedBeforeLastPasswordReset(created, user.getLastPasswordReset())));
  }

}
