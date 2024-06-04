package utils.alerts;

import javafx.scene.control.Alert;
import utils.exceptions.BlockErrorException;
import utils.exceptions.WrongCoordinatesException;

public class ExceptionAlertDecoder {

    public static Alert.AlertType decode(Exception e){
        if(e instanceof BlockErrorException){
            return Alert.AlertType.WARNING;
        }else if(e instanceof WrongCoordinatesException){
            return Alert.AlertType.ERROR;
        }
        return Alert.AlertType.NONE;
    }
}
