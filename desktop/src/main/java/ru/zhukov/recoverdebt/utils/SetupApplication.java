package ru.zhukov.recoverdebt.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.zhukov.recoverdebt.exception.BaseException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

public class SetupApplication {
    private static  volatile  SetupApplication instance;
    private Properties properties;
    private static Path setupPath = Paths.get(".").toAbsolutePath().resolve("setup/setup.json").normalize();
    private static SetupDTO setupDTO;
    private static Gson gson;
    private SetupApplication(){
        properties = new Properties();
        gson = new GsonBuilder().disableHtmlEscaping()
                                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                                .setPrettyPrinting()
                                .serializeNulls()
                                .create();
    }
    public static SetupApplication getInstance(){
        if(instance == null){
            synchronized (SetupApplication.class){
                if(instance == null){
                    instance = new SetupApplication();
                    try {
                        instance.createSetupPropertyFile();
                        loadFile();


                    } catch (BaseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return instance;
    }


    private    void createSetupPropertyFile() throws BaseException {
        try {
            if (!Files.exists(setupPath)) {

                if(!Files.exists(setupPath.getParent())) {
                    Files.createDirectory(setupPath.getParent());
                }

                Files.createFile(setupPath);
                setupDTO = new SetupDTO();
                setupDTO.setPathToDb("//localhost:8080/");

                try(BufferedWriter output = Files.newBufferedWriter(setupPath)){
                    output.write(gson.toJson(setupDTO));
                }


            }


        }catch (IOException ex){
            throw new BaseException("Файла настроек не существует",ex);
        }


    }


    public String readPathDB() {
        loadFile();
        return setupDTO.getPathToDb();
    }

    private static   void loadFile(){
        try(BufferedReader output = Files.newBufferedReader(setupPath)){
            setupDTO =  gson.fromJson(output,SetupDTO.class);
        }catch (IOException ex){

        }

    }

    public void savePathDB(String value) throws BaseException {
        try(BufferedWriter output = Files.newBufferedWriter(setupPath)){
            setupDTO.setPathToDb(value);
          gson.toJson(setupDTO,output);

        }catch(IOException ex){
            throw new BaseException("Настройки сохранить не удалось");
        }
    }
}
