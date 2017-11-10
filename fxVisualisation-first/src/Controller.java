import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Controller {
    public Button results;
    public Label winTitle;
    public Label winTeamName;
    @FXML
    private Button buttonForStartGame1;
    @FXML
    private Button buttonForStartGame2;
    @FXML
    private Label player1FirstTeam;
    @FXML
    private Label player2FirstTeam;
    @FXML
    private Label player3FirstTeam;
    @FXML
    private Label player4FirstTeam;
    @FXML
    private Label player5FirstTeam;
    @FXML
    private Label player1SecondTeam;
    @FXML
    private Label player2SecondTeam;
    @FXML
    private Label player3SecondTeam;
    @FXML
    private Label player4SecondTeam;
    @FXML
    private Label player5SecondTeam;
    @FXML
    private Label labelNotification1;
    @FXML
    private Label labelNotification2;
    @FXML
    private Label labelNotification3;
    @FXML
    private Label labelNotification4;
    @FXML
    private Label labelNotification5;
    @FXML
    private Label labelNotification6;
    @FXML
    private Label labelNotification7;
    @FXML
    private Label labelNotification8;
    @FXML
    private Label labelNotification9;
    @FXML
    private Label labelNotification0;
    @FXML
    private Button buttonForStart;
    @FXML
    private Label teamNameFirst;
    @FXML
    private Label teamNameSecond;
    @FXML
    private Label totalFirstTeam;
    @FXML
    private Label totalSecondTeam;

    private ArrayList<Label> labelsNotify = new ArrayList<>();
    private ArrayList<Model> models = new ArrayList<>();
    private ArrayList<Count> counts = new ArrayList<>();
    {
        models.add(new Model());
        models.add(new Model());
        models.add(new Model());
        models.add(new Model());
        models.add(new Model());
        counts.add(new Count());
        counts.add(new Count());
        counts.add(new Count());
        counts.add(new Count());
        counts.add(new Count());
        models.add(new Model());
        models.add(new Model());
        models.add(new Model());
        models.add(new Model());
        models.add(new Model());
        counts.add(new Count());
        counts.add(new Count());
        counts.add(new Count());
        counts.add(new Count());
        counts.add(new Count());
    }
    ExecutorService service = Executors.newFixedThreadPool(1);
    public void setTotalFirstTeam(String totalFirstTeam) {
        this.totalFirstTeam.setText(totalFirstTeam);
    }
    public void setTotalSecondTeam(String totalFirstTeam) {
        this.totalSecondTeam.setText(totalFirstTeam);
    }

    public int getTotalPlayer1() {
        int _1 = 0;
        int _2 = 0;
        int _3 = 0;
        int _4 = 0;
        int _5 = 0;

        try {
            _1 = Integer.parseInt(this.player1FirstTeam.getText());
            _2 = Integer.parseInt(this.player2FirstTeam.getText());
            _3 = Integer.parseInt(this.player3FirstTeam.getText());
            _4 = Integer.parseInt(this.player4FirstTeam.getText());
            _5 = Integer.parseInt(this.player5FirstTeam.getText());
            return  _1 + _2 + _3 + _4 + _5;
        } catch (Exception e) {
            return  _1 + _2 + _3 + _4 + _5;
        }
    }

    public int getTotalPlayer2() {
        int _6 = 0;
        int _7 = 0;
        int _8 = 0;
        int _9 = 0;
        int _0 = 0;

        try {
            _6 = Integer.parseInt(this.player1SecondTeam.getText());
            _7 = Integer.parseInt(this.player2SecondTeam.getText());
            _8 = Integer.parseInt(this.player3SecondTeam.getText());
            _9 = Integer.parseInt(this.player4SecondTeam.getText());
            _0 = Integer.parseInt(this.player5SecondTeam.getText());
            return  _6 + _7 + _8 + _9 + _0;
        } catch (Exception e) {
            return  _6 + _7 + _8 + _9 + _0;
        }
    }

    public void set1Player(String nowPlayer) {
        this.player1FirstTeam.setText(nowPlayer);
    }
    public void set2Player(String nowPlayer) {
        this.player2FirstTeam.setText(nowPlayer);
    }
    public void set3Player(String nowPlayer) {
        this.player3FirstTeam.setText(nowPlayer);
    }
    public void set4Player(String nowPlayer) {
        this.player4FirstTeam.setText(nowPlayer);
    }
    public void set5Player(String nowPlayer) {
        this.player5FirstTeam.setText(nowPlayer);
    }
    public void set6Player(String nowPlayer) {
        this.player1SecondTeam.setText(nowPlayer);
    }
    public void set7Player(String nowPlayer) {
        this.player2SecondTeam.setText(nowPlayer);
    }
    public void set8Player(String nowPlayer) {
        this.player3SecondTeam.setText(nowPlayer);
    }
    public void set9Player(String nowPlayer) {
        this.player4SecondTeam.setText(nowPlayer);
    }
    public void set0Player(String nowPlayer) {
        this.player5SecondTeam.setText(nowPlayer);
    }

    @FXML
    public void initialize() {
        buttonForStart.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            setTextAndVisibleTrueForStart();
            labelsNotify.add(labelNotification1);
            labelsNotify.add(labelNotification2);
            labelsNotify.add(labelNotification3);
            labelsNotify.add(labelNotification4);
            labelsNotify.add(labelNotification5);
            labelsNotify.add(labelNotification6);
            labelsNotify.add(labelNotification7);
            labelsNotify.add(labelNotification8);
            labelsNotify.add(labelNotification9);
            labelsNotify.add(labelNotification0);
        });
    }
    public void startGame1(ActionEvent actionEvent) throws InterruptedException, ExecutionException {
        justMethod1();

    }

    public void startGame2(ActionEvent actionEvent) throws InterruptedException, ExecutionException {
        justMethod2();
    }

    public void results(ActionEvent actionEvent) throws InterruptedException, ExecutionException {
        showResults();
    }

    public void setTextAndVisibleTrueForStart() {
        buttonForStart.setVisible(false);
        teamNameFirst.setText("Невесточки!");
        teamNameSecond.setText("Женишочки!");
        totalFirstTeam.setText("0");
        totalSecondTeam.setText("0");
        player1FirstTeam.setVisible(true);
        player2FirstTeam.setVisible(true);
        player3FirstTeam.setVisible(true);
        player4FirstTeam.setVisible(true);
        player5FirstTeam.setVisible(true);
        player1SecondTeam.setVisible(true);
        player2SecondTeam.setVisible(true);
        player3SecondTeam.setVisible(true);
        player4SecondTeam.setVisible(true);
        player5SecondTeam.setVisible(true);
        teamNameFirst.setVisible(true);
        teamNameSecond.setVisible(true);
        totalFirstTeam.setVisible(true);
        totalSecondTeam.setVisible(true);
        buttonForStartGame1.setVisible(true);
    }

    public void showResults() {
        winTitle.setVisible(true);
        winTeamName.setVisible(true);
        winTeamName.setText(Integer.parseInt(totalFirstTeam.getText()) > Integer.parseInt(totalSecondTeam.getText()) ? teamNameFirst.getText() : teamNameSecond.getText());
        service.shutdown();
        results.setVisible(false);
    }

    public void justMethod1() {
        for (int i = 0; i < 5; i++) {
            launchThreads(i);
        }
        buttonForStartGame1.setVisible(false);
        buttonForStartGame2.setVisible(true);
    }

    public void justMethod2() {
        for (int i = 5; i < 10; i++) {
                launchThreads(i);
        }
        buttonForStartGame2.setVisible(false);
        results.setVisible(true);
    }

    public void launchThreads(int i) {
        Label nowLabelNotify = labelsNotify.get(i);
        Thread th1 = new Thread(counts.get(i));
        nowLabelNotify.textProperty().bind(counts.get(i).messageProperty());
        nowLabelNotify.visibleProperty().bind(counts.get(i).runningProperty());
        service.submit(th1);

        models.get(i).setController(this);
        models.get(i).setCount(i + 1);
        Thread th = new Thread(models.get(i));
        service.submit(th);
    }
}
