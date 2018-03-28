import java.util.Arrays;

public class Text{
    public String []lines = {"Это первая строка",
            "За ней идет вторая строка",
            "А за ней ещё пару",
            "И в итоге получаем",
            "Что наша программа выводит 5 строк"
    };

    @Override
    public String toString() {
        return "Text{" +
                "lines=" + Arrays.toString(lines) +
                '}';
    }
}
