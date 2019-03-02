package com.github.simplevenkat.protobuf;

import example.simple.Simple.SimpleMessage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;


public class SimpleMain {
    public static void main(String[] args) {
        System.out.println("Hello World");
        SimpleMessage.Builder  builder = SimpleMessage.newBuilder();
        builder.setId(42).setIsSimple(true).setName("My simple message");
        builder.addAllSampleList(Arrays.asList(4,5,6));

        System.out.println(builder.toString());

        SimpleMessage message = builder.build();
        message.getId();
        message.getName();

        try {
            FileOutputStream outputStream = new FileOutputStream("simple_message.bin");
            message.writeTo(outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Reading from file..");
            FileInputStream inputStream= new FileInputStream("simple_message.bin");
            SimpleMessage messageFromFile = SimpleMessage.parseFrom(inputStream);
            System.out.println(messageFromFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
