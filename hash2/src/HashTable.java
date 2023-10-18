import java.util.Arrays;

public class HashTable<T> {
    int idInt;
    String idString;
    int asciiCodeSum;
    Object[] mixedArray = new Object[999];

    public Object busca(String key) {
        hash(key);
        checkColisao(key, false);
        if (mixedArray[asciiCodeSum] != null){
            Object[] pair = (Object[]) mixedArray[asciiCodeSum];
            System.out.println("Buscando valor da chave " + key + ". retorno: " + pair[1]);
            return pair[1];
        } else {
            System.out.println("chave "+ key +" nao encontrada. retorno: null");
            return null;
        }
    }
    public Object busca(int key) {
        hash(key);
        checkColisao(Integer.toString(key), false);
        if (mixedArray[asciiCodeSum] != null){
            Object[] pair = (Object[]) mixedArray[asciiCodeSum];
            System.out.println("Buscando valor da chave " + key + ". retorno: " + pair[1]);
            return pair[1];
        } else {
            System.out.println("chave "+ key +" nao encontrada. retorno: null");
            return null;
        }
    }

    public Object remover(String key) {
        hash(key);
        checkColisao(key, false);
        if (mixedArray[asciiCodeSum] == null) {
            System.out.println("chave " + key +" nao encontrada. retorno: null");
            return null;
        }
        Object[] pop = (Object[]) mixedArray[asciiCodeSum];
        mixedArray[asciiCodeSum] = -1;
        System.out.println("chave e volor removidos na chave " + key + ". retorno: " + pop[1]);
        return pop[1];
    }
    public Object remover(int key) {
        hash(key);
        checkColisao(Integer.toString(key), false);
        if (mixedArray[asciiCodeSum] == null) {
            System.out.println("chave " + key +" nao encontrada. retorno: null");
            return null;
        }
        Object[] pop = (Object[]) mixedArray[asciiCodeSum];
        mixedArray[asciiCodeSum] = -1;
        System.out.println("chave e volor removidos na chave " + key + ". retorno: " + pop[1]);
        return pop[1];
    }

    public void insercao(int key, T value) {
        this.idInt = key;
        hash(key);
        checkColisao(Integer.toString(key), true);
        addToArray(key, value);
    }

    public void insercao(String key, T value) {
        this.idString = key;
        hash(key);
        checkColisao(key, true);
        addToArray(key, value);
    }

    public void checkColisao(String key, boolean insercao){
        if (mixedArray[asciiCodeSum] != null) {
            if (mixedArray[asciiCodeSum].equals(-1) && insercao == true) {
                return;
            }
            if (mixedArray[asciiCodeSum].equals(-1) && insercao == false) {
                asciiCodeSum++;
                checkColisao(key, insercao);
                return;
            }
            Object[] pair = (Object[]) mixedArray[asciiCodeSum];
            if (!pair[0].toString().equals(key)) {
                asciiCodeSum++;
                checkColisao(key, insercao);
            }
        }
    }
    public void hash(Object key) {
        asciiCodeSum = 0;
        String objString = key.toString();
        for (int i = 0; i < objString.length(); i++) {
            char character = objString.charAt(i);
            asciiCodeSum += (int) character;
        }
    }

    public void addToArray(Object key, T value){
        Object[] pair = new Object[]{key, value};
        mixedArray[asciiCodeSum] = pair;
        System.out.println("Valor " + value + " incluido na chave " + key);
    }

    public int getIdInt() {
        System.out.println(idInt);
        return this.idInt;
    }

    public void setIdInt(int idInt) {
        this.idInt = idInt;
    }

    public String getIdString() {
        System.out.println(idString);
        return this.idString;
    }

    public void setIdString(String idString) {
        this.idString = idString;
    }

}
