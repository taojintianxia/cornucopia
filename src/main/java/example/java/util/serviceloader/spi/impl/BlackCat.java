package example.java.util.serviceloader.spi.impl;

import example.java.util.serviceloader.spi.Cat;

public class BlackCat implements Cat {

    @Override
    public void miaow() {
        System.out.println("Black Cat is miaow");
    }
}
