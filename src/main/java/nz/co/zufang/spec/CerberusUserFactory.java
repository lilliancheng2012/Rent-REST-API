package nz.co.zufang.spec;

import org.springframework.security.core.authority.AuthorityUtils;

import nz.co.zufang.model.CerberusUser;
import nz.co.zufang.model.User;

public class CerberusUserFactory {

  public static CerberusUser create(User user) {
    return new CerberusUser(
      user.getUid(),
      user.getUsername(),
      user.getPassword(),
      user.getEmail(),
      user.getLastPasswordReset(),
      AuthorityUtils.commaSeparatedStringToAuthorityList(user.getAccountType().getValue())
    );
  }

}
