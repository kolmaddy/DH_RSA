package diffiehellman;

import static diffiehellman.DiffieHellman.DiffieHellman;
import static diffiehellman.RSA.RSA;

/**
 *
 * @author kamod
 */
public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("----------------Диффи-Хеллман-------------------"); 
        DiffieHellman();
        
        System.out.println("\n---------------------RSA------------------------");         
        RSA();
    }
    
}
