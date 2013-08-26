/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package features;

/**
 *
 * @author Kane
 */
public class InitialOrderTest {

    static String staticField = "test static field";
    String field = "test normal field";

    static {
        System.out.println("the staticField is : " + staticField);
        System.out.println("it's in the static clause");
    }

    {
        System.out.println("the normal field is : " + field);
        System.out.println("it's in the normal clause");
    }
    
    public InitialOrderTest(){
        System.out.println("it's in the constructor ");
    }

    public static void main(String... args) {
        InitialOrderTest initialOrderTest = new InitialOrderTest();
    }
}
