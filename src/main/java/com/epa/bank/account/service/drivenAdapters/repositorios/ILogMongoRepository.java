package com.epa.bank.account.service.drivenAdapters.repositorios;


import com.epa.bank.account.service.models.mongo.LogMongo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ILogMongoRepository extends ReactiveMongoRepository<LogMongo, String>
{
}
