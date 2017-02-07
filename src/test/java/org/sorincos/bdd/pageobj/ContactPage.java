package org.sorincos.bdd.pageobj;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "contactpage")
public class ContactPage extends AbstractPage {

  public ContactPage editContact(final String name) {
    editText("last_name", name);
    clickId("SAVE");
    return this;
  }

  public boolean hasContact(final String name) {
    return isThere(name);
  }

  public ContactPage deleteCurrent() {
    clickId("delete_button");
    acceptAlert();
    return this;
  }
}
