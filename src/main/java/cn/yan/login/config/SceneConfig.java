package cn.yan.login.config;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

import java.awt.*;

/**
 * 登录和注册舞台配置类
 */
public class SceneConfig {

	//获取屏幕宽度、高度
	Screen screen = Screen.getPrimary();
	Rectangle2D bounds = screen.getBounds();
	double width1 = bounds.getWidth();
	double height1 = bounds.getHeight();

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
