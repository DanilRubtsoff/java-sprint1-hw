public class Converter {
    Integer step;
    Integer caloriesPerStep;

    Converter() {
        this.step = 75;
        this.caloriesPerStep = 50;
    }

    /*
        В этом классе осуществляется преобразование шагов в километры и калории.
        Для подсчёта дистанции можно считать, что один шаг равен 75 см.
        Для подсчёта количества сожжённых килокалорий можно считать, что 1 шаг = 50 калорий, 1 килокалория = 1 000 калорий.
            */
    public Integer getKmfromSteps(Integer sumSteps) {
        Integer distance;
        distance = sumSteps * step / 100000;
        return distance;
    }

    public Integer getCaloriesPerMotnth(Integer sumSteps) {
        Integer calories;
        calories = sumSteps * 50 / 1000;
        return calories;
    }


}
