import java.math.BigDecimal;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class RegularDiscount implements Discount{
    private static NavigableMap<Integer,Double> regularDiscountRange=new TreeMap<>();

    static {
        regularDiscountRange.put(0,0.0);
        regularDiscountRange.put(5001,0.10);
        regularDiscountRange.put(10001,0.20);
    }

    public double applyDiscount(double billingAmountWithoutDiscount) {
        Map.Entry<Integer, Double> rangeFound=regularDiscountRange.floorEntry((int)billingAmountWithoutDiscount);
        if (rangeFound.getKey()==0)
            return rangeFound.getValue();
        else if (rangeFound.getKey() == 5001)
            return billingAmountWithoutDiscount* rangeFound.getValue();
        else
            return  (5000 * 0.10)+ (billingAmountWithoutDiscount-10000)*( rangeFound.getValue());

    }
}
