package nz.co.zufang.model;

import java.io.Serializable;

public enum AccountType implements Serializable{

    /**
     * trial account
     */
    ADMIN("ADMIN"),

    /**
     * standrad account
     */
    STANDARD("STANDARD");

    private String value;

    AccountType(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }
    
    public static AccountType fromString(String value) {
        if (value != null) {
            for (AccountType types : AccountType.values()) {
                if (types.value.equalsIgnoreCase(value)) {
                    return types;
                }
            }
        }
        return null;
    }

}
