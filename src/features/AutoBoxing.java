/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package features;

/**
 *
 * @author Kane
 */
public class AutoBoxing {

    public static void main(String... args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 312;
        Integer f = 312;
        Long g = 3L;
        
        System.out.println(c == d);
        //the cache of integer from -128 to 127
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
    }
}
