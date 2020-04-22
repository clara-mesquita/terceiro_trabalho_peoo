import java.util.Comparator;

public class SortByNumber implements Comparator<Canal> { 
    public int compare(Canal a, Canal b) 
    { 
        return a.getNumero() - b.getNumero(); 
    } 
} 