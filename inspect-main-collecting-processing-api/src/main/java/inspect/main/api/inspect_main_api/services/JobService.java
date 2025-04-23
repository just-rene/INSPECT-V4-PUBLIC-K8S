package inspect.main.api.inspect_main_api.services;


import inspect.main.api.inspect_main_api.entities.general.Job;
import inspect.main.api.inspect_main_api.entities.nlp.computed.NamedEntityRecognitionDayAccumulated;
import inspect.main.api.inspect_main_api.nlp.NlpTask;
import inspect.main.api.inspect_main_api.repos.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public Flux<Job> list() {
        return jobRepository.findAll();
    }

    public Mono<Job> getByUrl(String url){
        return jobRepository.findByUrl(url);
    }

    public Mono<Job> doesSuccessfulJobExists(String url){
        return  jobRepository.doesSuccessfulJobExists(url);
    }

    public Mono<Job> doesFailedJobExists(String url){
        return  jobRepository.doesFailedJobExists(url);
    }

    public void save(Job job){
        jobRepository.save(job).subscribe();
    }

    public Mono<List<Job>> getJobsForTimeBefore(LocalDateTime localDateTime){
        return jobRepository.getJobsForTimeBefore(localDateTime);
    }

    public Flux<Job> getJobsBetween(LocalDateTime timestampStart,LocalDateTime timestampEnd){
        return jobRepository.getJobsBetween(timestampStart,timestampEnd);
    }

    public Flux<Job> getJobsWithoutNlpAnalysis(String nlpTask){
        if(NlpTask.EMOTION_MULTILABEL.equals(nlpTask)){
            return jobRepository.getJobsWhereEmotionMultilabel(false);
        }
        if(NlpTask.SENTIMENT.equals(nlpTask)){
           return jobRepository.getJobsWhereSentiment(false);
        }
        if(NlpTask.NAMED_ENTITY_RECOGNITION.equals(nlpTask)){
            return jobRepository.getJobsWhereNamedEntityRecognition(false);
        }

        System.err.println("getJobsWithOrWithoutNlpAnalysis: unknown type!");
        return Flux.empty();

    }

    public Flux<NamedEntityRecognitionDayAccumulated> triggerNamedEntityRecognitionDayAccumulator(LocalDateTime s, LocalDateTime e){
        return jobRepository.triggerNamedEntityRecognitionDayAccumulator(s,e);
    }

}
