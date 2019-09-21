package cn.yan.login.config;

import java.awt.*;

/**
 * 登录和注册舞台配置类
 */
public class SceneConfig {

	//获取屏幕
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	//屏幕宽度
	public final double screenWidth = screenSize.getWidth();

	//屏幕高度
	public final double screenHeight = screenSize.getHeight();


	//默认宽度
	public final static double width = 500;

	//默认高度
	public final static double height = 600;


}
