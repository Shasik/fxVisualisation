import javafx.concurrent.Task;

public class Count extends Task<Void> {
    @Override
    protected Void call() throws Exception {
        long time = System.currentTimeMillis();
//        long timeAfter = time + 4000;
//        while (timeAfter - System.currentTimeMillis() >= 0) {
//            updateMessage("" + ((timeAfter - System.currentTimeMillis()) / 1000));
//        }
        updateMessage("КРИЧИИИ!");
        Thread.sleep(1000);
        return null;
    }
}
