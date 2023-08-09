package calculadora;

import org.apache.struts.action.ActionForm;

public class MainForm extends ActionForm {
  private String formattedString;

  public String getMessage() {
    return formattedString;
  }

  public void setMessage(String message) {
    this.formattedString = message;
  }
}
