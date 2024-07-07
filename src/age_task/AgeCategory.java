package age_task;

public class AgeCategory {
    public String getCategory(int age) {
        if (age < 0)
            throw new IllegalArgumentException(" Возраст не может быть отррицательным");
        else if (age <= 12) {
            return "Ребенок";
        } else if (age <= 17) {
            return "Подросток";
        } else if (age <= 64) {
            return "Взрослый";
        } else {
            return "Пенсионер";
        }
    }
}