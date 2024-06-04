package utils.alerts;

import javafx.scene.control.Alert;

public class AlertMessage extends Alert {

    public AlertMessage(Exception exception, String exceptionMessage) {

        super(ExceptionAlertDecoder.decode(exception));

        AlertType alertType = ExceptionAlertDecoder.decode(exception);
        switch (alertType){
            case INFORMATION:
                super.setTitle("Info!");
                break;
            case WARNING:
                super.setTitle("WARNING!");
                break;
            case CONFIRMATION:
                super.setTitle("Confirm!");
                break;
            case ERROR:
                super.setTitle("ERROR!");
                break;
            default:
                super.setTitle("Alert!");
        }
        super.setHeaderText(exceptionMessage);
    }
}
