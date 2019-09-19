package cn.yan.login.controller;

import de.felixroske.jfxsupport.SplashScreen;

import java.io.File;
import java.net.URL;
import java.util.Random;


/**
 * 启动动画，等待springboot启动完成
 */
public class Splash extends SplashScreen {

    @Override
    public String getImagePath() {
	    URL url = this.getClass().getClassLoader().getResource("static/splash");

	    String path = url.getPath();
	    File splashFolder = new File(path);
	    File[] files = splashFolder.listFiles();
	    //开场动画的文件下下有多少个文件
	    int length = files.length;
	    Random random = new Random();
	    //随机取一个图片作为开场图
	    int i = random.nextInt(length)+1;
	    String pic = "/static/splash/splash" + i + ".png";
	    return pic;
    }



    /*@Override
    public Parent getParent() {
        //透明不带进度条
        Group gp = new Group();
	    Image image = new Image(this.getImagePath());
	    ImageView imageView = new ImageView(image);
	    gp.getChildren().add(imageView);
        return gp;


        //默认的方法：带进度条
	    *//*ImageView imageView = new ImageView(getImagePath());
	    ProgressBar splashProgressBar = new ProgressBar();
	    splashProgressBar.setPrefWidth(imageView.getImage().getWidth());
	    VBox vbox = new VBox();
	    vbox.getChildren().addAll(new Node[]{imageView, splashProgressBar});
	    return vbox;*//*
    }*/

}