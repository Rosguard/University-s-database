package org.fit.kaminskii.model;

public enum Sex {
    MALE("мужской"),
    FEMALE("женский");

    private final String sex;

    Sex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public static Sex findBySex(String sex){
        for(Sex one: values()){
            if(one.sex.equals(sex))
                return one;
        }
        throw new IllegalArgumentException(String.format("Error sex for %s", sex));
    }

    @Override
    public String toString() {
        return sex;
    }
}