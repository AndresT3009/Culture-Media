package culturemedia.services.implement;

import culturemedia.exceptions.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.model.VideoReproduction;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.VideoReproductionRepository;
import culturemedia.services.CultureMediaService;
import java.text.MessageFormat;
import java.util.List;

public class CultureMediaServiceImpl implements CultureMediaService {

    private final VideoReproductionRepository videoReproductionRepository;
    private final VideoRepository videoRepository;

    public  CultureMediaServiceImpl(VideoRepository videoRepository, VideoReproductionRepository videoReproductionRepository){
        this.videoRepository = videoRepository;
        this.videoReproductionRepository = videoReproductionRepository;
    }

    public List <Video> find(String tittle) throws VideoNotFoundException{
        var video =videoRepository.find(tittle);
        try {
            if (video.isEmpty()) {
                throw new VideoNotFoundException();
            }
            return video;
        }catch(Exception e){
            throw new VideoNotFoundException(MessageFormat.format("Error: {1} " + tittle,e));
        }
    }

    public List <Video> find(Double fromDuration, Double toDuration)throws VideoNotFoundException {
        var video = videoRepository.find(fromDuration, toDuration);
        try {
            if (video.isEmpty()) {
                throw new VideoNotFoundException();
            }
            return video;
        }catch(Exception e){
            throw new VideoNotFoundException();
        }
    }

    public List<Video> findAll() throws VideoNotFoundException {
        var video = videoRepository.findAll();
            if (video.isEmpty()) {
                throw new VideoNotFoundException();
            }
            return video;
    }

    public Video save (Video video) throws RuntimeException{
        try {
            Video savedVideo = videoRepository.save(video);
            if (savedVideo == null){
                throw new VideoNotFoundException("Error saving Video:saved video is Null");
            }
            return savedVideo;
        } catch (Exception e) {
            throw new RuntimeException("Error saving Video" + e.getMessage(),e);
        }
    }

    public VideoReproduction save (VideoReproduction videoReproduction) throws RuntimeException{
        try {
            VideoReproduction savedReproduction = videoReproductionRepository.save(videoReproduction);
            if (savedReproduction == null){
                throw new VideoNotFoundException("Error saving Video");
            }
            return savedReproduction;
        } catch (Exception e) {
            throw new RuntimeException("Error saving Video" + e);
        }
    }
}
