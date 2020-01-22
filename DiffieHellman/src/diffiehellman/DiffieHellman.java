
package diffiehellman;

import static diffiehellman.PrimeNumb.RandPrime;
import static diffiehellman.Root.Root;
import java.math.BigInteger;
import java.util.Random;

public class DiffieHellman {
    public static void DiffieHellman() throws Exception {
                //------------------------- ДИФФИ ХЕЛЛМАН -----------------------------
        long prime = RandPrime();        
        Random rnd = new Random();
        //1.
        int aA = rnd.nextInt(10000);
        System.out.println("Алиса генерирует случайное аА = " + aA);
        int aB = rnd.nextInt(10000);
        System.out.println("Боб генерирует случайное aB = " + aB);
        
        //2.
        long p = prime;
        System.out.println("\nПростое число p = " + p);
        int g = Root(p);
        System.out.println("Его первообразный корень g = " + g);
        
        //3. Алиса вычисляет А=(g^aA)mod p и отправляет Бобу
        BigInteger A = BigInteger.valueOf(g).pow(aA).mod(BigInteger.valueOf(p));
        System.out.println("\nАлиса отправляет Бобу А=(g^aA)mod p = " + A);
        
        //4. Боб вычисляет B=(g^aB)mod p и отправляет Алисе
        BigInteger B = BigInteger.valueOf(g).pow(aB).mod(BigInteger.valueOf(p));
        System.out.println("Боб отправляет Алисе B=(g^aB)mod p = " + B);
        
        //5. Алиса вычисляет K=(B^aA)mod p
        BigInteger Ka = B.pow(aA).mod(BigInteger.valueOf(p));
        System.out.println("\nАлиса вычисляет ключ K=(B^aA)mod p = " + Ka);
        
        //6. Боб вычисляет K=(A^aB)mod p
        BigInteger Kb = A.pow(aB).mod(BigInteger.valueOf(p));
        System.out.println("Боб вычисляет ключ K=(A^aB)mod p = " + Kb);
        
    }
}
