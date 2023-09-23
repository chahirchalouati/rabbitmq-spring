package com.crcl.rabbitexchange;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "queues")
public class QueueProperties {

    private List<String> names;
}

