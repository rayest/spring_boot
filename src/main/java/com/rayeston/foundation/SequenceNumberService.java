package com.rayeston.foundation;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by lirui on 2017/11/12.
 */
public class SequenceNumberService {

    public static String generateUuid(){
        TimeBasedGenerator generator = Generators.timeBasedGenerator(EthernetAddress.fromInterface());
        UUID uuid = generator.generate();
        return uuid.toString();
    }
}
