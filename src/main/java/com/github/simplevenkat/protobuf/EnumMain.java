package com.github.simplevenkat.protobuf;

import example.enumerations.EnumExample;
import example.enumerations.EnumExample.EnumMessage;

public class EnumMain {
    public static void main(String[] args) {
        System.out.println("EnumExample");
        EnumMessage.Builder builder = EnumMessage.newBuilder();
        builder.setId(365);
        builder.setDayOfTheWeek(EnumExample.DayOfTheWeek.FRIDAY);

        EnumMessage message = builder.build();
        System.out.println(message);
    }
}
