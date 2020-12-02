package lesson4;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ChatController implements Initializable {

    private ChatController controller;
    public VBox Box;
    @FXML
    private TextFlow emojiList;

    public TextField textMsg;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FileHistoryService.getInstance().load().forEach(historyLine -> {
            textMsg.appendText(historyLine + "\n");
        });
    }

    public void send(ActionEvent actionEvent) {
        if(textMsg.getText().trim().equals(""))return;

        Text text=new Text(textMsg.getText().trim());

        text.setFill(Color.WHITE);
        text.getStyleClass().add("message");
        TextFlow tempFlow=new TextFlow();

        tempFlow.getChildren().add(text);
        tempFlow.setMaxWidth(280);

        TextFlow flow=new TextFlow(tempFlow);

        HBox hbox=new HBox(14);

//        tempFlow.getStyleClass().add("tempFlowFlipped");
//        flow.getStyleClass().add("textFlowFlipped");
//        Box.setAlignment(Pos.TOP_LEFT);
//        hbox.setAlignment(Pos.CENTER_LEFT);
//        hbox.getChildren().add(flow);

        text.setFill(Color.WHITE);
        tempFlow.getStyleClass().add("tempFlow");
        flow.getStyleClass().add("textFlow");
        Box.setAlignment(Pos.TOP_RIGHT);
        //hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        hbox.getChildren().add(flow);

        hbox.getStyleClass().add("hbox");
        Platform.runLater(() -> Box.getChildren().addAll(hbox));

        textMsg.setText("");
        textMsg.requestFocus();

    }

    public void quit(ActionEvent actionEvent) throws IOException {
        Parent auth = FXMLLoader.load(getClass().getResource("authorization.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Авторизация");
        stage.setScene(new Scene(auth));
        stage.setResizable(false);
        stage.show();
        textMsg.getScene().getWindow().hide();
        FileHistoryService.getInstance().save(
                Arrays.asList(textMsg.getText().split("\n").clone()));
    }

//    public void update(String message) throws RemoteException {
//
//        Text text=new Text(message);
//        text.setFill(Color.WHITE);
//        text.getStyleClass().add("message");
//        TextFlow tempFlow=new TextFlow();
//
//        tempFlow.getChildren().add(text);
//        tempFlow.setMaxWidth(200);
//
//        TextFlow flow=new TextFlow(tempFlow);
//
//        HBox hbox=new HBox(12);
//
//            tempFlow.getStyleClass().add("tempFlowFlipped");
//            flow.getStyleClass().add("textFlowFlipped");
//            Box.setAlignment(Pos.TOP_LEFT);
//            hbox.setAlignment(Pos.CENTER_LEFT);
//            hbox.getChildren().add(flow);
//
//            text.setFill(Color.WHITE);
//            tempFlow.getStyleClass().add("tempFlow");
//            flow.getStyleClass().add("textFlow");
//            hbox.setAlignment(Pos.BOTTOM_RIGHT);
//            hbox.getChildren().add(flow);
//
//        hbox.getStyleClass().add("hbox");
//        Platform.runLater(() -> Box.getChildren().addAll(hbox));
//
//
//    }
}

//    public void emojiAction(ActionEvent actionEvent) {
//        if(emojiList.isVisible()){
//
//            emojiList.setVisible(false);
//        }else {
//            emojiList.setVisible(true);
//        }
//    }

