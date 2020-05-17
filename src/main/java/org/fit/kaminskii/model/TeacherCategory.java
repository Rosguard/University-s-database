package org.fit.kaminskii.model;

public enum  TeacherCategory {
    Postgraduate("Аспирант"),
    Candidate("Кандидат"),
    Doctoral("Доктор");

    private final String category;

    TeacherCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public static TeacherCategory findByCategory(String category){
        for(TeacherCategory one: values()){
            if(one.category.equals(category))
                return one;
        }
        throw new IllegalArgumentException(String.format("Error teacher category %s", category));
    }

    @Override
    public String toString() {
        return category;
    }
}