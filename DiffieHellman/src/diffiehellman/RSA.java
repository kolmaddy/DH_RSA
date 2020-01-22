
package diffiehellman;

import static diffiehellman.PrimeNumb.Eeee;
import static diffiehellman.PrimeNumb.RandPrime;
import java.math.BigInteger;


public class RSA {

    public static void RSA() throws Exception {
        long p = RandPrime();
        long q = RandPrime();
        System.out.println("Генерация простого p = " + p);
        System.out.println("Генерация простого q = " + q);
        
        BigInteger n = BigInteger.valueOf(p).multiply(BigInteger.valueOf(q));
        System.out.println("Произведение простых чисел n = " + n);
        BigInteger fn = BigInteger.valueOf(p-1).multiply(BigInteger.valueOf(q-1));
        System.out.println("Функция эейлера f(n) = " + fn);        
        int e = (int) Eeee(fn); //подбор такого е, чтобы оно не имело общих множителей с f(n) 
        System.out.println("Взаимно простой с f(n) открытый ключ e = " + e);
        
        //подбор такого d, чтобы остаток от деления e*d на f(n) был равен 1
        BigInteger d = BigInteger.valueOf(0);
        Boolean checker = true;
        int i = 2;
        //подбираем такое i, чтобы d = (i * f(n) + 1)/e было целым
        while (checker){
            d = BigInteger.valueOf(i).multiply(fn).add(BigInteger.valueOf(1));
            if (d.mod(BigInteger.valueOf(e)).longValue() == 0) {
                d = d.divide(BigInteger.valueOf(e));
                break;
            }
            i++;
        }        
        System.out.println("Закрытый ключ d = " + d);
        long bob = 1441621;
        System.out.println("\nБоб загадывает число "+bob+" и зашифровывает его x = "+bob+"^e mod n");
        BigInteger input = BigInteger.valueOf(bob);
        BigInteger x = input.pow(e).mod(n);
        System.out.println("x = " + x);
        System.out.println("\nАлиса расшифровывает с помощью ключа d");
        BigInteger out = x.modPow(d, n);
        System.out.println("out = " + out);
    }

}
