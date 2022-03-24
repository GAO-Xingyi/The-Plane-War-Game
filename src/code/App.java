package code;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * BufferedImage:是Java中表示图片的类
 * 处理图片的工具类
 * 工具类的写法：工具类中一般会将项目中需要重复使用的代码抽离出来，定义成工具方法
 */
public class App {
    //读取指定位置上的图片
    //加static的目的：
    //static特点：公用的，所有对象，可以直接通过类名调用（不需要再调用对象）
    public static BufferedImage getImg(String path) {
        //加载图片
        //Java中的IO流，输送数据的管道
        //输入输出流
        //这里利用反射，提前构造好框架
        //App.class 找到App类的路径
        //getResource()获取资源
        try {
            BufferedImage img = ImageIO.read(App.class.getResource(path));
            //如果找到图片，就将图片返回
            return img;
        } catch (IOException e) {
            //catch 如果找不到图片，就会捕获找不到图片的原因
            e.printStackTrace();
        }
        return null;
    }
}

