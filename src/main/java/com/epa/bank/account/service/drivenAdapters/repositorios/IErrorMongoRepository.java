package com.epa.bank.account.service.drivenAdapters.repositorios;


import com.epa.bank.account.service.models.mongo.ErrorMongo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IErrorMongoRepository extends ReactiveMongoRepository<ErrorMongo, String>
{
}
