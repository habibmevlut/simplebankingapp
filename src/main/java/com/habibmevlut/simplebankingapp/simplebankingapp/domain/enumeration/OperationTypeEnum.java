package com.habibmevlut.simplebankingapp.simplebankingapp.domain.enumeration;

public enum OperationTypeEnum {
    WITHDRAW((Integer) 0),
    DEPOSIT((Integer) 1),
    PAYMENT((Integer) 2);

    private Integer value;

    private OperationTypeEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public static OperationTypeEnum fromId(int id) {
        for (OperationTypeEnum type : values()) {
            if (type.getValue() == id) {
                return type;
            }
        }
        return null;
    }

}
