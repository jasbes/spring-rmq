package com.rmq.api.model;

import java.io.Serializable;
import java.math.BigDecimal;

public record TransactionEvent(String name, BigDecimal amount) implements Serializable {
}
