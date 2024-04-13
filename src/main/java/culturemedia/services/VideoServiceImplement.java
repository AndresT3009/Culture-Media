package culturemedia.services;

import culturemedia.exceptions.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;
import java.text.MessageFormat;
import java.util.List;

public class VideoServiceImplement {

    private VideoRepository videoRepository;

    public List<Video> findAll() throws VideoNotFoundException {
        var video = videoRepository.findAll();
        try {
            if (video.isEmpty()) {
                throw new VideoNotFoundException();
            }
            return video;
        }catch(Exception e){
            throw new VideoNotFoundException("Video not found" + e);
        }
    }

    public Video save (Video video) throws VideoNotFoundException{
        try {
            Video savedVideo = videoRepository.save(video);
            if (savedVideo == null){
                throw new VideoNotFoundException("Error saving Video");
            }
            return savedVideo;
        } catch (Exception e) {
            throw new VideoNotFoundException("Error saving Video" + e);
        }
    }

    public List <Video> findByTittle(String tittle) throws VideoNotFoundException{
        var video =videoRepository.findByTittle(tittle);
        try {
            if (video.isEmpty()) {
                throw new VideoNotFoundException();
            }
            return video;
        }catch(Exception e){
            throw new VideoNotFoundException(MessageFormat.format("video not found with the tittle: {0}, Error: {1} " + tittle,e));
        }
    }

    public List <Video> findByDuration(Double fromDuration, Double toDuration)throws VideoNotFoundException {
        var video = videoRepository.findByDuration(fromDuration, toDuration);
        try {
            if (video.isEmpty()) {
                throw new VideoNotFoundException();
            }
            return video;
        }catch(Exception e){
            throw new VideoNotFoundException(MessageFormat.format("video not found with the parameter from duration: {0} to duration: {1}. Error: {2} " + fromDuration,toDuration,e));
        }
    }


}
