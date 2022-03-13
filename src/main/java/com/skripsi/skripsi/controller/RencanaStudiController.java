package com.skripsi.skripsi.controller;

import com.skripsi.skripsi.model.MatkulModel;
import com.skripsi.skripsi.pubsub.RencanaStudi;
import com.skripsi.skripsi.repository.MatkulDb;
import com.skripsi.skripsi.rest.request.RencanaStudiReq;
import com.skripsi.skripsi.rest.response.MatkulRes;
import com.skripsi.skripsi.rest.response.RencanaStudiRes;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@RestController
public class RencanaStudiController {
    @Autowired
    private KafkaTemplate<String, RencanaStudi> kafkaTemplate;

    @Autowired
    private MatkulDb matkulDb;

    @PostMapping(value = "/rencana-studi")
    public RencanaStudi daftarRencanaStudi(
            @RequestBody RencanaStudiReq rencanaStudiReq
            ){

        RencanaStudi rencanaStudi = new RencanaStudi(rencanaStudiReq.getNamaMahasiswa(), rencanaStudiReq.getDaftarMatkul().toString());
        Message<RencanaStudi> message = MessageBuilder.withPayload(rencanaStudi).setHeader(KafkaHeaders.TOPIC, "coba2").build();
        kafkaTemplate.send( message );

        return rencanaStudi;
    }

    @GetMapping(value = "/daftar-matkul")
    public List<MatkulRes> daftarMatkul() {
        List<MatkulModel> daftarMatkul = matkulDb.findAll();
        List<MatkulRes> daftarMatkulRes = new ArrayList<>();
        for (MatkulModel matkul: daftarMatkul) {
            MatkulRes matkulRes = new MatkulRes(matkul.getId(), matkul.getNama(), matkul.getKapasitas());
            daftarMatkulRes.add(matkulRes);
        }

        return daftarMatkulRes;
    }
}
