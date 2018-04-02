package example.java.util.serviceloader.spi.impl;

import example.java.util.serviceloader.spi.Cat;

public class DefaultCat implements Cat {

    @Override
    public void miaow() {
        System.out.println("Default Cat is miaow");
    }

}
