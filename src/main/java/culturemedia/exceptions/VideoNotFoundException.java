package culturemedia.exceptions;

import java.text.MessageFormat;

public class VideoNotFoundException extends CulturemediaException{

    public VideoNotFoundException (String tittle){
        super(MessageFormat.format("Video not found for the tittle {0}",tittle));
    }

    public VideoNotFoundException (){
        super("Video not found");
    };


}
