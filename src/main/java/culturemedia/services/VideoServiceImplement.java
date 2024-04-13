package culturemedia.services;

import culturemedia.exceptions.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;
import java.util.List;

public class VideoServiceImplement {

    private VideoRepository videoRepository;

    public List<Video> findAll() throws VideoNotFoundException {
        var video = videoRepository.findAll();
        return video;
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
        if(video.isEmpty()){
            throw new VideoNotFoundException("Video not found");
        }
        return video;
    }

    public List <Video> findByDuration(Double fromDuration, Double toDuration)throws VideoNotFoundException{
        var video = videoRepository.findByDuration(fromDuration,toDuration);
        if(video.isEmpty()){
            throw new VideoNotFoundException("Video not found");
        }
        return video;
    }


}
