package testdom.com;

public class TextProcessing {
/*
* Implement method isPalindrom.
* */
    public static boolean isPalindrom(String word) {
        boolean isPalindrom = false;
        String revString = new StringBuilder(word).reverse().toString();
        if (revString.compareToIgnoreCase(word) == 0) isPalindrom = true;
        return isPalindrom;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrom("Deleveled"));
        String providedWord =
                "Tu gardes dans tes yeux la volupté des nuits,\n" +
                        "O Joie inespérée au fond des solitudes !\n" +
                        "Ton baiser est pareil à la saveur des fruits\n" +
                        "Et ta voix fait songer aux merveilleux préludes\n" +
                        "Murmurés par la mer à la beauté des nuits.\n" +
                        "\n" +
                        "Tu portes sur ton front la langueur et l’ivresse,\n" +
                        "Les serments éternels et les aveux d’amour,\n" +
                        "Tu sembles évoquer la craintive caresse\n" +
                        "Dont l’ardeur se dérobe à la clarté du jour\n" +
                        "Et qui te laisse au front la langueur et l’ivresse.";
        long debut = System.currentTimeMillis();
        System.out.println(new StringBuilder(providedWord).reverse());
        long second = System.currentTimeMillis()-debut;
        System.out.println(second+" millisecondes");
    }
}