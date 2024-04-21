package culturemedia.exceptions;

import java.text.MessageFormat;

public class DurationNotValidException extends CulturemediaException{

    public DurationNotValidException (String tittle, Double duration){
        super(MessageFormat.format("Duration {0} not valid for title {1} ",tittle,duration));
    };
}
