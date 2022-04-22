package utility.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    public static void println(Level level, String desc) {
        LocalDateTime time = LocalDateTime.now();
        String timeStr = time.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        String levelStr = level.toString();

        String str = String.format("[%s] [%s] %s", timeStr, levelStr, desc);
        System.out.println(str);
    }
}
