package com.epa.bank.account.service.usecase;


import com.epa.bank.account.service.drivenAdapters.repositorios.IErrorMongoRepository;
import com.epa.bank.account.service.drivenAdapters.repositorios.ILogMongoRepository;
import com.epa.bank.account.service.models.dto.EventDto;
import com.epa.bank.account.service.models.mongo.ErrorMongo;
import com.epa.bank.account.service.models.mongo.LogMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.function.Function;

@Service
public class WriteErrorUseCase implements Function<String, Mono<String>> {
    private final IErrorMongoRepository repository;

    @Autowired
    public WriteErrorUseCase(IErrorMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<String> apply(String message) {
        ErrorMongo error = new ErrorMongo( );
        error.setMessage(message);
        error.setCreated(new Date());
        return repository.save(error).map(ErrorMongo::getMessage);
    }
}
