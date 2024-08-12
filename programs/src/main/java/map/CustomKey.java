package map;

import java.util.Objects;

public class CustomKey {
    private String keyPart1;
    private int keyPart2;

    public CustomKey(String keyPart1, int keyPart2) {
        this.keyPart1 = keyPart1;
        this.keyPart2 = keyPart2;
    }

    public String getKeyPart1() {
        return keyPart1;
    }

    public void setKeyPart1(String keyPart1) {
        this.keyPart1 = keyPart1;
    }

    public int getKeyPart2() {
        return keyPart2;
    }

    public void setKeyPart2(int keyPart2) {
        this.keyPart2 = keyPart2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomKey customKey = (CustomKey) o;
        return keyPart2 == customKey.keyPart2 && Objects.equals(keyPart1, customKey.keyPart1);
    }

    @Override
    public int hashCode() {
        //return Objects.hash(keyPart1, keyPart2);
        return 20;
    }

    @Override
    public String toString() {
        return "CustomKey{" +
                "keyPart1='" + keyPart1 + '\'' +
                ", keyPart2=" + keyPart2 +
                '}';
    }
}

