import java.util.Locale;

public class EnumConverter {

    public static String enumToString(ProductType productType){
        return firstCapitalLetter(productType.toString().toLowerCase());
    }

    private static String firstCapitalLetter(String word){
        return word.substring(0,1).toUpperCase() + word.substring(1);
    }
}
