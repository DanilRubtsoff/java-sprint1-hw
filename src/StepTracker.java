
public class StepTracker {

    Integer aimStepNumber;//Целевое количество шагов
    Integer[][] userData;//для хранения числа шагов за год по месяцам и дням

    StepTracker() {
        aimStepNumber = 10000;
        Integer[][] userData = new Integer[13][31];
        for (int i = 0; i < userData.length; i++) {
            for (int j = 0; j < userData[i].length; j++) {
                userData[i][j] = 0;
            }
        }
        this.userData = userData;
    }

    void setAimStepNumber(Integer aimStepNumberByUser) {
        aimStepNumber = aimStepNumberByUser;
    }

    void inputUserdata(Integer month, Integer day, Integer steps) {
        userData[month][day] = steps;
        System.out.println("данные за " + month + " й месяц и " + day + " день -  успешно сохранены" + "\n");
    }

    public boolean checkUserMonth(Integer month) {
        if (month < 1 | month > 12) {
            System.out.println("месяц дожен быть в диапазоне 1-12: " + "\n");
            return false;
        } else {
            return true;
        }
    }

    public boolean checkUserDay(Integer day) {
        if (day < 0 | day > 30) {
            System.out.println("день дожен быть в диапазоне 1-30 " + "\n");
            return false;
        } else {
            return true;
        }
    }

    public boolean checkUserSteps(Integer steps) {
        if (steps < 0) {
            System.out.println("число шагов д.б неотрицательным числом " + "\n");
            return false;
        } else {
            return true;
        }
    }

    public void monthUserStatistic(Integer month) {
        getDailySteps(month);//Количество пройденных шагов по дням
        getSumMonthSteps(month, true);//Общее количество шагов за месяц
        getStepsMax(month);//Максимальное пройденное количество шагов в месяце
        getAverageSteps(month);//Среднее количество шагов
        getMonthDistance(month);//Пройденная дистанция (в км)
        getMonthCalories(month);//подсчёт количества сожжённых килокалорий
        getTheBestSeriesOfSteps(month);//Лучшая серия
    }

    //Количество пройденных шагов по дням
    public void getDailySteps(Integer month) {
        for (int j = 1; j < userData[month].length; j++) {
            System.out.print(j + " день: " + userData[month][j] + ", ");
        }
        System.out.println("\n");
    }

    //Общее количество шагов за месяц
    public Integer getSumMonthSteps(Integer month, boolean doPrint) {
        Integer sumSteps = 0;
        for (int j = 1; j < userData[month].length; j++) {
            sumSteps = sumSteps + userData[month][j];
        }
        if (doPrint) {
            System.out.println("Общее количество шагов за месяц: " + sumSteps + "\n");
        }
        return sumSteps;
    }

    //Максимальное пройденное количество шагов в месяце
    public void getStepsMax(Integer month) {
        Integer max = 0;

        for (int j = 1; j < userData[month].length; j++) {
            if (userData[month][j] > max) {
                max = userData[month][j];
            }
        }
        System.out.println("Максимальное пройденное количество шагов в месяце: " + month + " " + max + "\n");
    }

    //Среднее количество шагов
    public void getAverageSteps(Integer month) {
        Integer AverageSteps = getSumMonthSteps(month, false) / 30;
        System.out.println("Среднее количество шагов в месяце " + month + " : " + AverageSteps + "\n");
    }

    //Пройденная дистанция (в км)
    public void getMonthDistance(Integer month) {
        Integer distance;
        Converter myConverter = new Converter();
        distance = myConverter.getKmfromSteps(getSumMonthSteps(month, false));
        System.out.println("Пройденная дистанция (в км) в месяце " + month + ": " + distance + "\n");
    }

    //подсчёт количества сожжённых килокалорий
    public void getMonthCalories(Integer month) {
        Integer calories;
        Converter myConverter = new Converter();
        calories = myConverter.getCaloriesPerMotnth(getSumMonthSteps(month, false));
        System.out.println("Количество сожжённых килокалорий в месяце " + month + ": " + calories + "\n");
    }

    //Лучшая серия
    public void getTheBestSeriesOfSteps(Integer month) {

        Integer counter = 0;
        Integer counterMax = 0;

        for (int j = 1; j < userData[month].length; j++) {
            if (userData[month][j] >= this.aimStepNumber) {
                counter++;
            } else {
                if (counter > counterMax) {
                    counterMax = counter;
                }
                counter = 0;
            }
        }

        System.out.println("Лучшая серия в месяце " + month + ": " + counterMax + " дня" + "\n");
    }
}
