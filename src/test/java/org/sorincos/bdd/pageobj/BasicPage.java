package org.sorincos.bdd.pageobj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "basicpage")
public class BasicPage extends AbstractPage {

  @Autowired
  private ContactPage contactPage;

  public ContactPage createContact() {
    clickId("quickcreatetop");
    clickXpathJs("Create Contact");
    return contactPage;
  }

  public void logout() {
    clickId("usermenucollapsed");
    clickXpathJs("Log Out");
  }
}
