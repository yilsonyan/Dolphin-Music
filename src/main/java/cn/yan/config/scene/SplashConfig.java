package cn.yan.config.scene;

import de.felixroske.jfxsupport.SplashScreen;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.Random;


/**
 * 启动动画，等待springboot启动完成
 */
public class SplashConfig extends SplashScreen {

    @Override
    public String getImagePath() {
    	//获取资源目录
	    String path = this.getClass().getClassLoader().getResource("static/splash").getPath();

	    //开场动画的文件下下有多少个文件
	    File splashFolder = new File(path);
	    File[] files = splashFolder.listFiles();
	    int length = files.length;

	    //随机取一个图片作为开场图
	    Random random = new Random();
	    int i = random.nextInt(length);
	    String name = files[i].getName();
	    String pic = "/static/splash/"+name;
	    return pic;
    }



    //透明不带进度条
    //@Override
    public Parent getParent() {
        Group gp = new Group();
	    Image image = new Image(this.getImagePath());
	    ImageView imageView = new ImageView(image);
	    gp.getChildren().add(imageView);
        return gp;
    }



	//默认的方法：带进度条
    //@Override
    public Parent getParent0() {
	    ImageView imageView = new ImageView(getImagePath());
	    ProgressBar splashProgressBar = new ProgressBar();
	    splashProgressBar.setPrefWidth(imageView.getImage().getWidth());
	    VBox vbox = new VBox();
	    vbox.getChildren().addAll(new Node[]{imageView, splashProgressBar});
	    return vbox;
    }



}