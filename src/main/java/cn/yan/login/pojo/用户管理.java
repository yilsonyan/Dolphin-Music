package cn.yan.login.pojo;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class 用户管理 {

	private final static String USERNAME_PROP_NAME = "userName";
	private final ReadOnlyStringWrapper userName;


	private final static String PASSWORD_PROP_NAME = "password";
	private StringProperty password;


	public 用户管理() {
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
		用户管理 用户管理 = new 用户管理();
		用户管理.setPassword("123");

		用户管理.setPassword("456");

	}
}
