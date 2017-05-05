package com.gdt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Singleton class, this will log any messages that are passed in.
 * Will log to <Date>.log, if no .log file exists, then it will create one.
 */
public final class MyLogger {

    private static final MyLogger INSTANCE = new MyLogger();

    private MyLogger(){
    }

    public synchronized static MyLogger getInstance(){
        return INSTANCE;
    }

    public synchronized  void info(String template, Object... values){
        this.info(templateBuilder(template, values));
    }

    public synchronized void info(String information){
        this.log(information, LOG_TYPE.INFO);
    }

    public synchronized  void warn(String template, Object... values){
        this.warn(templateBuilder(template, values));
    }

    public synchronized void warn(String warning){
        this.log(warning, LOG_TYPE.WARN);
    }

    public synchronized  void error(String template, Object... values){
        this.error(templateBuilder(template, values));
    }

    public synchronized void error(String error){
        this.log(error, LOG_TYPE.ERROR);
    }

    private String templateBuilder(String template, Object... values){
        String s = "\\{}";
        for(Object value : values){
            template = template.replaceFirst(s, value.toString());
        }
        return template;
    }

    private synchronized void log(String message, LOG_TYPE type){
        // OPEN/CREATE file, then append to eof
        File file = new File(getDate().concat("-Test.log"));
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            boolean create = file.createNewFile();
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            if(create){
                String stars = String.format("%63s", "").replace(' ', '*');
                String created = "************ File Created: ".concat(getDateTime()).concat(" ************");
                bw.write(stars);
                bw.newLine();
                bw.write(created);
                bw.newLine();
                bw.write(stars);
            }
            bw.newLine();

            //CREATE MESSAGE
            String logMessage = getDateTime() + " ";
            logMessage = logMessage.concat(String.format("%-6s", type.toString()));
            Throwable throwable = new Throwable();
            StackTraceElement[] elements = throwable.getStackTrace();
            for(StackTraceElement element : elements){
                String caller = element.toString();
                caller = caller.substring(caller.indexOf("(")+1, caller.indexOf(")"));
                if(!caller.contains("MyLogger.")){
                    int index = caller.indexOf(":")+1;
                    String lineNumber = caller.substring(index);
                    caller = caller.substring(0, index);
                    logMessage = logMessage.concat(caller)
                            .concat(String.format("%-4s", lineNumber))
                            .concat(" - ");
                    break;
                }
            }
            logMessage = logMessage.concat(message);
            //END OF CREATING MESSAGE

            bw.write(logMessage);
//            System.out.println(logMessage);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bw != null){
                    bw.close();
                }
                if(fw != null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getDateTime(){
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return format.format(date);
    }

    private String getDate(){
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(date);
    }
}
