package com.github.simplevenkat.protobuf;

import example.complex.Complex.*;

import java.util.Arrays;

public class ComplexMain {
    public static void main(String[] args) {

        System.out.println("ComplexExample");

        DummyMessage oneDummy = newDummyMessage(6,"one dummy message");


        ComplexMessage.Builder builder = ComplexMessage.newBuilder();

        builder.setOneDummy(oneDummy);

        builder.addMultipleDummy(newDummyMessage(66,"second dummy"));

        builder.addAllMultipleDummy(Arrays.asList(newDummyMessage(666,"third dummy"), newDummyMessage(6666,"fourth dummy")));
        System.out.println(builder.toString());

    }

    public static DummyMessage newDummyMessage(Integer id, String name)
    {
        DummyMessage.Builder dummyMessageBuilder = DummyMessage.newBuilder();
        DummyMessage message = dummyMessageBuilder.setName(name).setId(id).build();
        return message;

    }
}
