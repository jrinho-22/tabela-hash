public class Main {
    public static void main(String[] args) throws Exception {
        HashTable<String> ht = new HashTable<>();

        ht.insercao("23", "4");
        ht.insercao("32","6");
        ht.insercao("1", "8");
        ht.busca("23");
        ht.remover("32");
        ht.remover("23");
        ht.insercao("23", "4");
        ht.busca("23");
        ht.busca("32");
        ht.busca("1");
    }
}
