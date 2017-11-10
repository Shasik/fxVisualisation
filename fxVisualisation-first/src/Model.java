import javafx.application.Platform;
import javafx.concurrent.Task;

import javax.sound.sampled.*;

public class Model extends Task<Void> {
    private Controller controller;
    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    protected Void call() throws Exception {
        AudioFormat FORMAT = new AudioFormat(44100, 16, 1, true, true);
        long timeBefore = System.currentTimeMillis();
        long timeAfter = timeBefore + 4000;
        int totalCount = 0;
        long total = 0;
        int visibleTotal = 0;
        DataLine.Info lineInfo = new DataLine.Info(TargetDataLine.class, FORMAT);
        Mixer mixerS = AudioSystem.getMixer(AudioSystem.getMixerInfo()[3]);
        TargetDataLine microphoneLine = (TargetDataLine) mixerS.getLine(lineInfo);
        microphoneLine.open(FORMAT);
        microphoneLine.start();
        byte[] buffer = new byte[8192];
        while (timeAfter - System.currentTimeMillis() >= 0) {
            int count = microphoneLine.read(buffer, 0, buffer.length);
            if (count > 0) {
                for (int i = 0; i < count; i += 2) {
                    int firstSample = (buffer[i + 1]) << 8 | (buffer[i]);
                    total += Math.abs(firstSample);
                    totalCount++;
                    visibleTotal = (int) (total / totalCount);
                    int finalVisibleTotal = visibleTotal;
                    Platform.runLater(() -> {
                        switch (this.count) {
                            case 1:
                                controller.set1Player("" + finalVisibleTotal);
                                break;
                            case 2:
                                controller.set2Player("" + finalVisibleTotal);
                                break;
                            case 3:
                                controller.set3Player("" + finalVisibleTotal);
                                break;
                            case 4:
                                controller.set4Player("" + finalVisibleTotal);
                                break;
                            case 5:
                                controller.set5Player("" + finalVisibleTotal);
                                break;
                            case 6:
                                controller.set6Player("" + finalVisibleTotal);
                                break;
                            case 7:
                                controller.set7Player("" + finalVisibleTotal);
                                break;
                            case 8:
                                controller.set8Player("" + finalVisibleTotal);
                                break;
                            case 9:
                                controller.set9Player("" + finalVisibleTotal);
                                break;
                            case 10:
                                controller.set0Player("" + finalVisibleTotal);
                        }

                    });
                }
            }
        }
        System.out.println(visibleTotal);
        microphoneLine.close();
        microphoneLine.stop();
        if (count <= 5) {
            Platform.runLater(() -> {
                controller.setTotalFirstTeam("" + (controller.getTotalPlayer1()));
            });
        } else {
            Platform.runLater(() -> {
                controller.setTotalSecondTeam("" + (controller.getTotalPlayer2()));
            });
        }
        return null;
    }
}