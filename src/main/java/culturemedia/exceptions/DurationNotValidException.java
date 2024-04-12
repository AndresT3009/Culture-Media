package culturemedia.exceptions;

import org.apache.logging.log4j.message.Message;

import java.text.MessageFormat;

public class DurationNotValidException extends CulturemediaException{

    public DurationNotValidException (String tittle, Double duration){
        super(MessageFormat.format("Duration not valid for title: {0} duration {1} ",tittle,duration));
    };
}
