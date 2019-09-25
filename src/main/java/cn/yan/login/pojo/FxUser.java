package cn.yan.login.pojo;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import lombok.Data;

import java.io.Serializable;

@Data
public class FxUser implements Serializable {

	/** use serialVersionUID from JDK 1.0.2 for interoperability */
	private static final long serialVersionUID = -6849794470754667110L;

	private final static String USERNAME_PROP_NAME = "userName";
	private final ReadOnlyStringWrapper userName;


	private final static String PASSWORD_PROP_NAME = "password";
	private StringProperty password;


	public FxUser() {
		userName = new ReadOnlyStringWrapper(this, USERNAME_PROP_NAME, "");
		password = new SimpleStringProperty(this, PASSWORD_PROP_NAME, "");

		// 属性更改事件 Adding a change listener with anonymous inner class
		password.addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println("old value:" + oldValue);
				System.out.println("new value:" + newValue);
			}
		});
	}



	public final String getUserName() {
		return userName.get();
	}

	public final void setUserName(String userName) {
		this.userName.set(userName);
	}

	public ReadOnlyStringProperty userNameProperty() {
		return userName.getReadOnlyProperty();
	}


	public final String getPassword() {
		return password.get();
	}

	public final void setPassword(String password) {
		this.password.set(password);
	}

	public StringProperty passwordProperty() {
		return password;
	}


	//测试属性更改事件
	public static void main(String[] args) {
		FxUser user = new FxUser();
		user.setPassword("123");
		user.setPassword("456");
	}



}
