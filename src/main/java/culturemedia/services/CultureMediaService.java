package culturemedia.services;

import culturemedia.exceptions.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.model.VideoReproduction;

import java.util.List;

public interface CultureMediaService {
    Video save (Video video);
    VideoReproduction save (VideoReproduction videoReproduction);
    List<Video> findAll() throws VideoNotFoundException;
    List <Video> findByTittle(String tittle) throws VideoNotFoundException;
    List <Video> findByDuration(Double fromDuration, Double toDuration) throws VideoNotFoundException;

}
