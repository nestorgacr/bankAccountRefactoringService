package com.epa.bank.account.service.handlers.bus;


import com.epa.bank.account.service.RabbitConfig;
import com.epa.bank.account.service.models.dto.EventDto;
import com.epa.bank.account.service.usecase.WriteErrorUseCase;
import com.epa.bank.account.service.usecase.WriteLogUseCase;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.rabbitmq.Receiver;


@Component
public class RabbitMqMessageConsumer implements CommandLineRunner {

    @Autowired
    private Receiver receiver;

    @Autowired
    private Gson gson;
    
    private final WriteErrorUseCase writeErrorUseCase;

    private final WriteLogUseCase writeLogUseCase;

    @Autowired
    public RabbitMqMessageConsumer(WriteErrorUseCase writeErrorUseCase, WriteLogUseCase writeLogUseCase) {
        this.writeErrorUseCase = writeErrorUseCase;
        this.writeLogUseCase = writeLogUseCase;
    }

    @Override
    public void run(String... args) throws Exception {


        receiver.consumeAutoAck(RabbitConfig.QUEUE_CLOUD_WATCH_NAME)
                .map(message -> {
                    EventDto mensaje = gson.fromJson(new String(message.getBody()), EventDto.class);
                    writeLogUseCase.apply(mensaje).subscribe();
                    System.out.println("CloudWatch:" + mensaje.toString());
                    return mensaje;
                })
                .subscribe();

        receiver.consumeAutoAck(RabbitConfig.QUEUE_NAME)
                .map(message -> {
                    String mensaje = new String(message.getBody());

                    writeErrorUseCase.apply(mensaje).subscribe();

                    System.out.println("Error:" + mensaje);
                    return mensaje;
                })
                .subscribe();

   }
}
