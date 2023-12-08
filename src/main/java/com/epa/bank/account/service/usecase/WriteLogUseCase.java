package com.epa.bank.account.service.usecase;


import com.epa.bank.account.service.drivenAdapters.repositorios.ILogMongoRepository;
import com.epa.bank.account.service.models.dto.EventDto;
import com.epa.bank.account.service.models.mongo.LogMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.function.Function;

@Service
public class WriteLogUseCase implements Function<EventDto, Mono<EventDto>> {
    private final ILogMongoRepository repository;

    @Autowired
    public WriteLogUseCase(ILogMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<EventDto> apply(EventDto data) {
        LogMongo log = new LogMongo( );
        log.setData(data.getData());
        log.setMessage(data.getMensaje());
        log.setCreated(new Date());
        return repository.save(log).map(
                response -> new EventDto(response.getMessage(), response.getData())
        );
    }
}
