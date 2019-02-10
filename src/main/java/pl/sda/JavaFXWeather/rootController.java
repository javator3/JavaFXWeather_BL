package pl.sda.JavaFXWeather;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.sda.JavaFXWeather.service.WeatherService;

import java.net.URL;
import java.util.ResourceBundle;

public class rootController implements Initializable
{
    private WeatherService weatherService = new WeatherService(
            "http://api.apixu.com/v1/current.json",
            "23f7a82df6764a3986590706191002");
    private String finalURL;

    @FXML
    private Button buttonSearch;

    @FXML
    private TextField textfieldCity;

    @FXML
    private Label labelTemp_C;

    @FXML
    private Label labelTemp_feel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }


    public void setCity(ActionEvent actionEvent) {
        labelTemp_C.setText(Float.toString(
                weatherService.getRealTemp(
                        textfieldCity.getText())));

        labelTemp_feel.setText(Float.toString(
                weatherService.getFeelTemp(
                        textfieldCity.getText())));



    }
}
