package example.java.util.serviceloader.spi;


import org.junit.Test;

import java.util.ServiceLoader;

public class CatTest {
    /*
     *  1.创建Cat接口, 定义方法miaow
     *  2.实现Cat接口, 有具体的实现类,BlackCat/WhiteCat/DefaultCat
     *  3.在resources目录下创建META-INF/service目录
     *  4.在META-INF/service目录下创建配置文件, 规则为Cat的全路径+接口名,此处为example.java.util.serviceloader.spi.Cat
     *  5.example.java.util.serviceloader.spi.Cat中将需要实现的类添加进去,具体看文件example.java.util.serviceloader.spi.Cat
     */
    @Test
    public void testMiaow(){
        ServiceLoader<Cat> serviceLoader = ServiceLoader.load(Cat.class);
        for(Cat cat : serviceLoader){
            cat.miaow();
        }
    }

}
