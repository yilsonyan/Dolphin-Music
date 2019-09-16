package cn.jd.login.controller;

import de.felixroske.jfxsupport.SplashScreen;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * 启动动画，等待springboot启动完成再加载视图
 */
public class Splash extends SplashScreen {

    @Override
    public String getImagePath() {
        return "/static/splash.png";
    }

    @Override
    public Parent getParent() {
        Group gp = new Group();

	    /*String path = this.getClass().getClassLoader().getResource(this.getImagePath()).getPath();
	    ImageView imageView = new ImageView(path);*/

	    Image image = new Image(this.getImagePath());
	    ImageView imageView = new ImageView(image);

	    gp.getChildren().add(imageView);
        return gp;
    }

	/**
	 * Customize if the splash screen should be visible at all
	 *
	 * @return true by default
	 */
	@Override
	public boolean visible() {
		return super.visible();
	}
}