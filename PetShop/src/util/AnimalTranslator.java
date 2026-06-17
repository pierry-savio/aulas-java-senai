package util;

public final class AnimalTranslator {
    public static String translate (String type, String language){
        if (language.equals("pt-br")) {
            if (type.equals("Dog")) {
                return "Cachorro";
            }
            if (type.equals("Cat")) {
                return "Gato";
            }
            if (type.equals("Duck")) {
                return "Pato";
            }
        }
        return type;
    }
}
