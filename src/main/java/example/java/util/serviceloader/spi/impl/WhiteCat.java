package example.java.util.serviceloader.spi.impl;

import example.java.util.serviceloader.spi.Cat;

public class WhiteCat implements Cat {

    @Override
    public void miaow() {
        System.out.println("White Cat is miaow");
    }

}
