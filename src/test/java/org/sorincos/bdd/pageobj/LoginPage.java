package org.sorincos.bdd.pageobj;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "loginpage")
public class LoginPage extends AbstractPage {

  public void doLogin(final String testUser, final String testPass) {
    editText("user_name", testUser);
    editText("user_password", testPass);
    clickId("bigbutton");
    assertThat(hasErrors(), is(false));
  }
}
