package pl.sda.JavaFXWeather;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private Label labelTempC;

    @FXML
    private Label labelTempFeel;

    @FXML
    private ImageView weatherIcon;


    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }

    public String getCity(){
        return textfieldCity.getText().replace(" ", "+");
    }

    public void setCity(ActionEvent actionEvent) {
        labelTempC.setText(Float.toString(
                weatherService.getRealTemp(
                       getCity())));

        labelTempFeel.setText(Float.toString(
                weatherService.getFeelTemp(
                       getCity())));

        Image image = new Image(weatherService.getWeatherIconURL(getCity()));
        weatherIcon.setImage(image);



    }
}
