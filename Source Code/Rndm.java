import static java.lang.System.*;
/**
 * This class contains helper methods for easily getting random numbers.
 */
public class Rndm
{
    private Rndm() { }; //private constructor to avoid instantiaion

    /**
     * Returns a random double between the lower bound and upper bound, not inclusive. 
     */
    public static double decimal(double lowerBound, double upperBound)
    {
        double randomDouble=Math.random()*(upperBound-lowerBound)+lowerBound;
        return randomDouble;
    }
    
    /**
     * Returns a random integer between the lower and upper bound, inclusive. 
     */
    public static int integer(int lowerBound, int upperBound)
    {
        double randomInteger=Math.random()*(upperBound-lowerBound+1)+lowerBound;
        return (int)randomInteger;
    }
}
