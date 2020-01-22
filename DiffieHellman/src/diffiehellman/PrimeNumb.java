package diffiehellman;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author kamod
 */
public class PrimeNumb {
    public static long RandPrime () throws Exception {
        long output = 0;
        for (int i = 0; i < 10; i++) {
            //System.out.println("-----------------------------");
            //1.
            //2.
            long p = RandNumb();

            //3.
            while(IsDivide(p)){
                p = RandNumb();
            }
            //System.out.println("p = " + p);
            //4.1 b - наибольшее число делений
            int b = 0;
            long tempP = p - 1;
            while(tempP % 2 == 0){  //если делится на 2
                tempP = tempP / 2;  //делим на 2; также tempP на последнем делении будет m для 4.2
                b++;
            }
            //System.out.println("b = " + b);

            //4.2 p=1+(2^b)*m
            long m = tempP;
            //System.out.println("m = " + m);

            //4.3 случайное а, меньше p
            long a = RandNumbLess(p);
            //System.out.println("a = " + a);

            //4.4 j = 0; z = a^n mod p
            int j = 0;
            int n = nbit(p);
            //System.out.println("n = " + n);
            BigInteger zz = BigInteger.valueOf(a);
            zz = zz.pow(n);
            //System.out.println("a^n = " + zz);
            zz = zz.mod(BigInteger.valueOf(p));
            //System.out.println("z = " + zz);
            long z = zz.longValue();

            //4.5
            if ((z == 1) || (z == p - 1)) {
                return p;
            }
            //4.6
            boolean rofler = true;
            while (rofler) {
                if (j>0 && z==1) {
                    rofler = false;
                    break;                
                }
                j++; //4.7
                //4.8
                if ((j<b) && (z<(p-1))) {
                    zz = BigInteger.valueOf(z);
                    zz = zz.pow(2);
                    //System.out.println("z^2 = " + zz);
                    zz = zz.mod(BigInteger.valueOf(p));
                    //System.out.println("z = " + zz);
                    z = zz.longValue();
                }
                else {
                    rofler = false;
                }
            }
            //4.9

            if (z == (p-1)) {
                return p;
            }
            if ((j==b) && (z!=p-1)) {
            }            

        }
        
        Random rnd = new Random();
        BigInteger mem = BigInteger.probablePrime(rnd.nextInt(10) + 20, rnd);
        output = mem.longValue();
        return output;
    }
    
    public static long RandNumb () {
        // 1. Генерируем случайное число 
        Random random = new Random();
        long rand = 1; //старший бит устанавливаем в 1
        int digit = random.nextInt(10) + 20; //от 20 до 30 порядков;
        for (int i=0; i<digit; i++){
            int tempBit = random.nextInt(2);
            rand = (rand << 1) | tempBit;
            //System.out.println("\n" + rand + " - " + Long.toBinaryString(rand)); 
            
        }
        // 2. Старший и младший бит равны 1
        rand = rand | 1; //младший бит устанавливаем в 1
        //System.out.println("\n" + rand + " - " + Long.toBinaryString(rand)); 
        //System.out.println("nn = " + digit);
        return rand;
    }
    
    public static boolean IsDivide (long input) throws Exception{
        boolean isDivide = false;
        ArrayList<String> primes2k = new ArrayList<>(); //подключаем список простых чисел до 2000
        primes2k.add("3");
        primes2k.add("5");
        primes2k.add("7");
        primes2k.add("11");
        primes2k.add("13");
        primes2k.add("17");
        primes2k.add("19");
        primes2k.add("23");
        primes2k.add("29");
        primes2k.add("31");
        primes2k.add("37");
        primes2k.add("41");
        primes2k.add("43");
        primes2k.add("47");
        primes2k.add("53");
        primes2k.add("59");
        primes2k.add("61");
        primes2k.add("67");
        primes2k.add("71");
        primes2k.add("73");
        primes2k.add("79");
        primes2k.add("83");
        primes2k.add("89");
        primes2k.add("97");
        primes2k.add("101");
        primes2k.add("103");
        primes2k.add("107");
        primes2k.add("109");
        primes2k.add("113");
        primes2k.add("127");
        primes2k.add("131");
        primes2k.add("137");
        primes2k.add("139");
        primes2k.add("149");
        primes2k.add("151");
        primes2k.add("157");
        primes2k.add("163");
        primes2k.add("167");
        primes2k.add("173");
        primes2k.add("179");
        primes2k.add("181");
        primes2k.add("191");
        primes2k.add("193");
        primes2k.add("197");
        primes2k.add("199");
        primes2k.add("211");
        primes2k.add("223");
        primes2k.add("227");
        primes2k.add("229");
        primes2k.add("233");
        primes2k.add("239");
        primes2k.add("241");
        primes2k.add("251");
        primes2k.add("257");
        primes2k.add("263");
        primes2k.add("269");
        primes2k.add("271");
        primes2k.add("277");
        primes2k.add("281");
        primes2k.add("283");
        primes2k.add("293");
        primes2k.add("307");
        primes2k.add("311");
        primes2k.add("313");
        primes2k.add("317");
        primes2k.add("331");
        primes2k.add("337");
        primes2k.add("347");
        primes2k.add("349");
        primes2k.add("353");
        primes2k.add("359");
        primes2k.add("367");
        primes2k.add("373");
        primes2k.add("379");
        primes2k.add("383");
        primes2k.add("389");
        primes2k.add("397");
        primes2k.add("401");
        primes2k.add("409");
        primes2k.add("419");
        primes2k.add("421");
        primes2k.add("431");
        primes2k.add("433");
        primes2k.add("439");
        primes2k.add("443");
        primes2k.add("449");
        primes2k.add("457");
        primes2k.add("461");
        primes2k.add("463");
        primes2k.add("467");
        primes2k.add("479");
        primes2k.add("487");
        primes2k.add("491");
        primes2k.add("499");
        primes2k.add("503");
        primes2k.add("509");
        primes2k.add("521");
        primes2k.add("523");
        primes2k.add("541");
        primes2k.add("547");
        primes2k.add("557");
        primes2k.add("563");
        primes2k.add("569");
        primes2k.add("571");
        primes2k.add("577");
        primes2k.add("587");
        primes2k.add("593");
        primes2k.add("599");
        primes2k.add("601");
        primes2k.add("607");
        primes2k.add("613");
        primes2k.add("617");
        primes2k.add("619");
        primes2k.add("631");
        primes2k.add("641");
        primes2k.add("643");
        primes2k.add("647");
        primes2k.add("653");
        primes2k.add("659");
        primes2k.add("661");
        primes2k.add("673");
        primes2k.add("677");
        primes2k.add("683");
        primes2k.add("691");
        primes2k.add("701");
        primes2k.add("709");
        primes2k.add("719");
        primes2k.add("727");
        primes2k.add("733");
        primes2k.add("739");
        primes2k.add("743");
        primes2k.add("751");
        primes2k.add("757");
        primes2k.add("761");
        primes2k.add("769");
        primes2k.add("773");
        primes2k.add("787");
        primes2k.add("797");
        primes2k.add("809");
        primes2k.add("811");
        primes2k.add("821");
        primes2k.add("823");
        primes2k.add("827");
        primes2k.add("829");
        primes2k.add("839");
        primes2k.add("853");
        primes2k.add("857");
        primes2k.add("859");
        primes2k.add("863");
        primes2k.add("877");
        primes2k.add("881");
        primes2k.add("883");
        primes2k.add("887");
        primes2k.add("907");
        primes2k.add("911");
        primes2k.add("919");
        primes2k.add("929");
        primes2k.add("937");
        primes2k.add("941");
        primes2k.add("947");
        primes2k.add("953");
        primes2k.add("967");
        primes2k.add("971");
        primes2k.add("977");
        primes2k.add("983");
        primes2k.add("991");
        primes2k.add("997");
        primes2k.add("1009");
        primes2k.add("1013");
        primes2k.add("1019");
        primes2k.add("1021");
        primes2k.add("1031");
        primes2k.add("1033");
        primes2k.add("1039");
        primes2k.add("1049");
        primes2k.add("1051");
        primes2k.add("1061");
        primes2k.add("1063");
        primes2k.add("1069");
        primes2k.add("1087");
        primes2k.add("1091");
        primes2k.add("1093");
        primes2k.add("1097");
        primes2k.add("1103");
        primes2k.add("1109");
        primes2k.add("1117");
        primes2k.add("1123");
        primes2k.add("1129");
        primes2k.add("1151");
        primes2k.add("1153");
        primes2k.add("1163");
        primes2k.add("1171");
        primes2k.add("1181");
        primes2k.add("1187");
        primes2k.add("1193");
        primes2k.add("1201");
        primes2k.add("1213");
        primes2k.add("1217");
        primes2k.add("1223");
        primes2k.add("1229");
        primes2k.add("1231");
        primes2k.add("1237");
        primes2k.add("1249");
        primes2k.add("1259");
        primes2k.add("1277");
        primes2k.add("1279");
        primes2k.add("1283");
        primes2k.add("1289");
        primes2k.add("1291");
        primes2k.add("1297");
        primes2k.add("1301");
        primes2k.add("1303");
        primes2k.add("1307");
        primes2k.add("1319");
        primes2k.add("1321");
        primes2k.add("1327");
        primes2k.add("1361");
        primes2k.add("1367");
        primes2k.add("1373");
        primes2k.add("1381");
        primes2k.add("1399");
        primes2k.add("1409");
        primes2k.add("1423");
        primes2k.add("1427");
        primes2k.add("1429");
        primes2k.add("1433");
        primes2k.add("1439");
        primes2k.add("1447");
        primes2k.add("1451");
        primes2k.add("1453");
        primes2k.add("1459");
        primes2k.add("1471");
        primes2k.add("1481");
        primes2k.add("1483");
        primes2k.add("1487");
        primes2k.add("1489");
        primes2k.add("1493");
        primes2k.add("1499");
        primes2k.add("1511");
        primes2k.add("1523");
        primes2k.add("1531");
        primes2k.add("1543");
        primes2k.add("1549");
        primes2k.add("1553");
        primes2k.add("1559");
        primes2k.add("1567");
        primes2k.add("1571");
        primes2k.add("1579");
        primes2k.add("1583");
        primes2k.add("1597");
        primes2k.add("1601");
        primes2k.add("1607");
        primes2k.add("1609");
        primes2k.add("1613");
        primes2k.add("1619");
        primes2k.add("1621");
        primes2k.add("1627");
        primes2k.add("1637");
        primes2k.add("1657");
        primes2k.add("1663");
        primes2k.add("1667");
        primes2k.add("1669");
        primes2k.add("1693");
        primes2k.add("1697");
        primes2k.add("1699");
        primes2k.add("1709");
        primes2k.add("1721");
        primes2k.add("1723");
        primes2k.add("1733");
        primes2k.add("1741");
        primes2k.add("1747");
        primes2k.add("1753");
        primes2k.add("1759");
        primes2k.add("1777");
        primes2k.add("1783");
        primes2k.add("1787");
        primes2k.add("1789");
        primes2k.add("1801");
        primes2k.add("1811");
        primes2k.add("1823");
        primes2k.add("1831");
        primes2k.add("1847");
        primes2k.add("1861");
        primes2k.add("1867");
        primes2k.add("1871");
        primes2k.add("1873");
        primes2k.add("1877");
        primes2k.add("1879");
        primes2k.add("1889");
        primes2k.add("1901");
        primes2k.add("1907");
        primes2k.add("1913");
        primes2k.add("1931");
        primes2k.add("1933");
        primes2k.add("1949");
        primes2k.add("1951");
        primes2k.add("1973");
        primes2k.add("1979");
        primes2k.add("1987");
        primes2k.add("1993");
        primes2k.add("1997");
        primes2k.add("1999");
        
        for (int i = 0; i < primes2k.size(); i++){
            if (input % Long.parseLong(primes2k.get(i))==0){
                //System.out.println(" делится на " + primes2k.get(i));
                isDivide = true;
                break;
            }
        }
        //if (!isDivide) {
            //System.out.println("Не делится на простые < 2000");
        //}
        return isDivide;
    }
    
    public static long RandNumbLess (long input) {
        long output = input;
        
        Random random = new Random();
        //System.out.println(output + " - " + Long.toBinaryString(output));
        int digit = 0;
        while (output>0){
            digit++;
            output = output >> 1;
            //System.out.println(output + " - " + Long.toBinaryString(output));
        }
        //System.out.println("В числе " + input + " находится " + digit + " разрядов");
        
        output = 0;
        //int newDigit = random.nextInt(digit);
        for (int i=0; i<digit-1; i++){
            int tempBit = random.nextInt(2);
            output = (output << 1) | tempBit;            
        }
        
        return output;
    }
    
    public static int nbit (long input) {
        int digit = 0;
        while (input>0){
            digit++;
            input = input >> 1;
        }        
        //System.out.println("nnn = " + digit);
        return digit;
    }
    
    public static long Eeee (BigInteger in) throws Exception{
        long input = in.longValue();
        long output = 0;
        ArrayList<String> primes2k = new ArrayList<>(); //подключаем список простых чисел до 2000
        primes2k.add("3");
        primes2k.add("5");
        primes2k.add("7");
        primes2k.add("11");
        primes2k.add("13");
        primes2k.add("17");
        primes2k.add("19");
        primes2k.add("23");
        primes2k.add("29");
        primes2k.add("31");
        primes2k.add("37");
        primes2k.add("41");
        primes2k.add("43");
        primes2k.add("47");
        primes2k.add("53");
        primes2k.add("59");
        primes2k.add("61");
        primes2k.add("67");
        primes2k.add("71");
        primes2k.add("73");
        primes2k.add("79");
        primes2k.add("83");
        primes2k.add("89");
        primes2k.add("97");
        primes2k.add("101");
        primes2k.add("103");
        primes2k.add("107");
        primes2k.add("109");
        primes2k.add("113");
        primes2k.add("127");
        primes2k.add("131");
        primes2k.add("137");
        primes2k.add("139");
        primes2k.add("149");
        primes2k.add("151");
        primes2k.add("157");
        primes2k.add("163");
        primes2k.add("167");
        primes2k.add("173");
        primes2k.add("179");
        primes2k.add("181");
        primes2k.add("191");
        primes2k.add("193");
        primes2k.add("197");
        primes2k.add("199");
        primes2k.add("211");
        primes2k.add("223");
        primes2k.add("227");
        primes2k.add("229");
        primes2k.add("233");
        primes2k.add("239");
        primes2k.add("241");
        primes2k.add("251");
        primes2k.add("257");
        primes2k.add("263");
        primes2k.add("269");
        primes2k.add("271");
        primes2k.add("277");
        primes2k.add("281");
        primes2k.add("283");
        primes2k.add("293");
        primes2k.add("307");
        primes2k.add("311");
        primes2k.add("313");
        primes2k.add("317");
        primes2k.add("331");
        primes2k.add("337");
        primes2k.add("347");
        primes2k.add("349");
        primes2k.add("353");
        primes2k.add("359");
        primes2k.add("367");
        primes2k.add("373");
        primes2k.add("379");
        primes2k.add("383");
        primes2k.add("389");
        primes2k.add("397");
        primes2k.add("401");
        primes2k.add("409");
        primes2k.add("419");
        primes2k.add("421");
        primes2k.add("431");
        primes2k.add("433");
        primes2k.add("439");
        primes2k.add("443");
        primes2k.add("449");
        primes2k.add("457");
        primes2k.add("461");
        primes2k.add("463");
        primes2k.add("467");
        primes2k.add("479");
        primes2k.add("487");
        primes2k.add("491");
        primes2k.add("499");
        primes2k.add("503");
        primes2k.add("509");
        primes2k.add("521");
        primes2k.add("523");
        primes2k.add("541");
        primes2k.add("547");
        primes2k.add("557");
        primes2k.add("563");
        primes2k.add("569");
        primes2k.add("571");
        primes2k.add("577");
        primes2k.add("587");
        primes2k.add("593");
        primes2k.add("599");
        primes2k.add("601");
        primes2k.add("607");
        primes2k.add("613");
        primes2k.add("617");
        primes2k.add("619");
        primes2k.add("631");
        primes2k.add("641");
        primes2k.add("643");
        primes2k.add("647");
        primes2k.add("653");
        primes2k.add("659");
        primes2k.add("661");
        primes2k.add("673");
        primes2k.add("677");
        primes2k.add("683");
        primes2k.add("691");
        primes2k.add("701");
        primes2k.add("709");
        primes2k.add("719");
        primes2k.add("727");
        primes2k.add("733");
        primes2k.add("739");
        primes2k.add("743");
        primes2k.add("751");
        primes2k.add("757");
        primes2k.add("761");
        primes2k.add("769");
        primes2k.add("773");
        primes2k.add("787");
        primes2k.add("797");
        primes2k.add("809");
        primes2k.add("811");
        primes2k.add("821");
        primes2k.add("823");
        primes2k.add("827");
        primes2k.add("829");
        primes2k.add("839");
        primes2k.add("853");
        primes2k.add("857");
        primes2k.add("859");
        primes2k.add("863");
        primes2k.add("877");
        primes2k.add("881");
        primes2k.add("883");
        primes2k.add("887");
        primes2k.add("907");
        primes2k.add("911");
        primes2k.add("919");
        primes2k.add("929");
        primes2k.add("937");
        primes2k.add("941");
        primes2k.add("947");
        primes2k.add("953");
        primes2k.add("967");
        primes2k.add("971");
        primes2k.add("977");
        primes2k.add("983");
        primes2k.add("991");
        primes2k.add("997");
        primes2k.add("1009");
        primes2k.add("1013");
        primes2k.add("1019");
        primes2k.add("1021");
        primes2k.add("1031");
        primes2k.add("1033");
        primes2k.add("1039");
        primes2k.add("1049");
        primes2k.add("1051");
        primes2k.add("1061");
        primes2k.add("1063");
        primes2k.add("1069");
        primes2k.add("1087");
        primes2k.add("1091");
        primes2k.add("1093");
        primes2k.add("1097");
        primes2k.add("1103");
        primes2k.add("1109");
        primes2k.add("1117");
        primes2k.add("1123");
        primes2k.add("1129");
        primes2k.add("1151");
        primes2k.add("1153");
        primes2k.add("1163");
        primes2k.add("1171");
        primes2k.add("1181");
        primes2k.add("1187");
        primes2k.add("1193");
        primes2k.add("1201");
        primes2k.add("1213");
        primes2k.add("1217");
        primes2k.add("1223");
        primes2k.add("1229");
        primes2k.add("1231");
        primes2k.add("1237");
        primes2k.add("1249");
        primes2k.add("1259");
        primes2k.add("1277");
        primes2k.add("1279");
        primes2k.add("1283");
        primes2k.add("1289");
        primes2k.add("1291");
        primes2k.add("1297");
        primes2k.add("1301");
        primes2k.add("1303");
        primes2k.add("1307");
        primes2k.add("1319");
        primes2k.add("1321");
        primes2k.add("1327");
        primes2k.add("1361");
        primes2k.add("1367");
        primes2k.add("1373");
        primes2k.add("1381");
        primes2k.add("1399");
        primes2k.add("1409");
        primes2k.add("1423");
        primes2k.add("1427");
        primes2k.add("1429");
        primes2k.add("1433");
        primes2k.add("1439");
        primes2k.add("1447");
        primes2k.add("1451");
        primes2k.add("1453");
        primes2k.add("1459");
        primes2k.add("1471");
        primes2k.add("1481");
        primes2k.add("1483");
        primes2k.add("1487");
        primes2k.add("1489");
        primes2k.add("1493");
        primes2k.add("1499");
        primes2k.add("1511");
        primes2k.add("1523");
        primes2k.add("1531");
        primes2k.add("1543");
        primes2k.add("1549");
        primes2k.add("1553");
        primes2k.add("1559");
        primes2k.add("1567");
        primes2k.add("1571");
        primes2k.add("1579");
        primes2k.add("1583");
        primes2k.add("1597");
        primes2k.add("1601");
        primes2k.add("1607");
        primes2k.add("1609");
        primes2k.add("1613");
        primes2k.add("1619");
        primes2k.add("1621");
        primes2k.add("1627");
        primes2k.add("1637");
        primes2k.add("1657");
        primes2k.add("1663");
        primes2k.add("1667");
        primes2k.add("1669");
        primes2k.add("1693");
        primes2k.add("1697");
        primes2k.add("1699");
        primes2k.add("1709");
        primes2k.add("1721");
        primes2k.add("1723");
        primes2k.add("1733");
        primes2k.add("1741");
        primes2k.add("1747");
        primes2k.add("1753");
        primes2k.add("1759");
        primes2k.add("1777");
        primes2k.add("1783");
        primes2k.add("1787");
        primes2k.add("1789");
        primes2k.add("1801");
        primes2k.add("1811");
        primes2k.add("1823");
        primes2k.add("1831");
        primes2k.add("1847");
        primes2k.add("1861");
        primes2k.add("1867");
        primes2k.add("1871");
        primes2k.add("1873");
        primes2k.add("1877");
        primes2k.add("1879");
        primes2k.add("1889");
        primes2k.add("1901");
        primes2k.add("1907");
        primes2k.add("1913");
        primes2k.add("1931");
        primes2k.add("1933");
        primes2k.add("1949");
        primes2k.add("1951");
        primes2k.add("1973");
        primes2k.add("1979");
        primes2k.add("1987");
        primes2k.add("1993");
        primes2k.add("1997");
        primes2k.add("1999");
        
        for (int i = 0; i < primes2k.size(); i++){
            if (input % Long.parseLong(primes2k.get(i))!=0){
                output = Long.parseLong(primes2k.get(i));
                break;
            }
        }
        //if (!isDivide) {
            //System.out.println("Не делится на простые < 2000");
        //}
        return output;
    }
}
