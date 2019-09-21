package cn.yan.validator;

import com.jfoenix.validation.RequiredFieldValidator;
import javafx.scene.control.TextInputControl;

public class LoginValidator extends RequiredFieldValidator {


	//重写验证规则
	public void eval() {
		if (this.srcControl.get() instanceof TextInputControl) {

			TextInputControl textField = (TextInputControl)this.srcControl.get();
			String fieldText = textField.getText();

			if (fieldText != null && !fieldText.isEmpty()) {
				this.hasErrors.set(false);
			} else {
				this.hasErrors.set(true);
			}
		}
	}


}
