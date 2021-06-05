package com.southwind.entity;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
public class Log {

    private long id;

    private long eId;

    private BigInteger acWater;

    private BigInteger acElc;

    private String startTime;

    private String endTime;

}
