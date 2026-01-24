import java.time.*;

public class Main {
    public static void main(String[] args) throws Exception {
        LocalDate date = LocalDate.now(ZoneId.of("Asia/Seoul"));
        System.out.println(date);
    }
}

