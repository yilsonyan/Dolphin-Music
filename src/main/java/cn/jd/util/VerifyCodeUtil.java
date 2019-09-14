package cn.jd.util;

import javafx.scene.image.Image;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class VerifyCodeUtil {

	private static int w = 70;
	private static int h = 35;
 	private static Random r = new Random();
 	// {"宋体", "华文楷体", "黑体", "华文新魏", "华文隶书", "微软雅黑", "楷体_GB2312"}
	private static String[] fontNames  = {"宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312"};
	// 可选字符
	private static String codes  = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";
	// 背景色
	private static Color bgColor  = new Color(255, 255, 255);
	// 验证码上的文本
	private static String text ;
	
	// 生成随机的颜色
	private static Color randomColor () {
		int red = r.nextInt(150);
		int green = r.nextInt(150);
		int blue = r.nextInt(150);
		return new Color(red, green, blue);
	}
	
	// 生成随机的字体
	private static Font randomFont () {
		int index = r.nextInt(fontNames.length);
		String fontName = fontNames[index];//生成随机的字体名称
		int style = r.nextInt(4);//生成随机的样式, 0(无样式), 1(粗体), 2(斜体), 3(粗体+斜体)
		int size = r.nextInt(5) + 24; //生成随机字号, 24 ~ 28
		return new Font(fontName, style, size);
	}
	
	// 画干扰线
	private static void drawLine (BufferedImage image) {
		int num  = 3;//一共画3条
		Graphics2D g2 = (Graphics2D)image.getGraphics();
		for(int i = 0; i < num; i++) {//生成两个点的坐标，即4个值
			int x1 = r.nextInt(w);
			int y1 = r.nextInt(h);
			int x2 = r.nextInt(w);
			int y2 = r.nextInt(h); 
			g2.setStroke(new BasicStroke(1.5F)); 
			g2.setColor(Color.BLUE); //干扰线是蓝色
			g2.drawLine(x1, y1, x2, y2);//画线
		}
	}
	
	// 随机生成一个字符
	private static char randomChar () {
		int index = r.nextInt(codes.length());
		return codes.charAt(index);
	}
	
	// 创建BufferedImage
	private static BufferedImage createImage () {
		BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB); 
		Graphics2D g2 = (Graphics2D)image.getGraphics(); 
		//g2.setColor(this.bgColor);
		g2.setColor(bgColor);
		g2.fillRect(0, 0, w, h);
 		return image;
	}

	
	// 调用这个方法得到验证码
	private static BufferedImage getImage () {
		BufferedImage image = createImage();//创建图片缓冲区 
		Graphics2D g2 = (Graphics2D)image.getGraphics();//得到绘制环境
		StringBuilder sb = new StringBuilder();//用来装载生成的验证码文本
		// 向图片中画4个字符
		for(int i = 0; i < 4; i++)  {//循环四次，每次生成一个字符
			String s = randomChar() + "";//随机生成一个字母 
			sb.append(s); //把字母添加到sb中
			float x = i * 1.0F * w / 4; //设置当前字符的x轴坐标
			g2.setFont(randomFont()); //设置随机字体
			g2.setColor(randomColor()); //设置随机颜色
			g2.drawString(s, x, h-5); //画图
		}
		//this.text = sb.toString(); //把生成的字符串赋给了this.text
		text = sb.toString(); //把生成的字符串赋给了this.text
		drawLine(image); //添加干扰线
		return image;		
	}
	
	// 返回验证码图片上的文本
	public static String getText () {
		return text;
	}
	
	// 保存图片到指定的输出流
	public static Image generateImageCode () {
		Image image = null;
		FileOutputStream fileOutputStream = null;
		try {
			BufferedImage bufferedImage = VerifyCodeUtil.getImage();
			String classpath = VerifyCodeUtil.class.getClassLoader().getResource("").getPath();

			File dir = new File(classpath + "verifycode");
			if (!dir.exists()){
				dir.mkdirs();
			}
			File file = new File(dir,"code.jpeg");
			if (!file.exists()){

				file.createNewFile();
			}
			fileOutputStream = new FileOutputStream(file);

			ImageIO.write(bufferedImage, "JPEG", fileOutputStream);

			//返回FX视图
			image = new Image(new FileInputStream(file.getPath()));
			//imageView.setImage(image);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return image;
	}





	@Test
	public void testVerifyCode() throws Exception {
		generateImageCode();
	}
}