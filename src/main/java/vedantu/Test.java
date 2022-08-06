package vedantu;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {

        PKGConnector pkgConnector = PKGConnector.getInstance();
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/binoy.mandal/all/codebase/02-09-2020/DS/listout.csv"));
        //ExecutorService executorService= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        List<String> emails = Files.readAllLines(Paths.get("/Users/binoy.mandal/all/codebase/02-09-2020/DS/batch/list13")).stream().filter(Objects::nonNull).collect(Collectors.toList());
//        List<String> batch = new ArrayList<>();
//        int j=1;
//        for (String email: emails){
//            if(batch.size()==1000){
//                Files.write(Paths.get("/Users/binoy.mandal/all/codebase/02-09-2020/DS/batch/list"+j),batch);
//                j++;
//                batch = new ArrayList<>();
//            }else{
//                batch.add(email);
//            }
//        }


        AtomicInteger atomicInteger=new AtomicInteger(0);
        CountDownLatch latch = new CountDownLatch(emails.size());

        for (String email : emails) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    isIdValid(email, pkgConnector, bufferedWriter,atomicInteger,latch);
                }
            });
        }



        //System.out.println(getValidUser(1,pkgConnector,bufferedWriter));
        System.out.println("Waiting");
        latch.await();
        System.out.println("Waiting.......");
        bufferedWriter.close();
        executorService.shutdown();
        System.out.println("Processing done");

    }

    static boolean getValidUser(int page,PKGConnector pkgConnector, BufferedWriter bufferedWriter) {
        try {
                String orderJson = pkgConnector.getJson("https://tools.vedantu.com/tools#/order/list/ALL/BULK/"+page);
                JSONArray orderJsonArray = new JSONArray(orderJson);
                for (int i = 0; i < orderJsonArray.length(); i++) {
                    Long epoch = orderJsonArray.getJSONObject(i).getLong("creationTime");
                    LocalDate ld = Instant.ofEpochMilli(epoch).atZone(ZoneId.systemDefault()).toLocalDate();
                    if (ld.getMonth().getValue() == 5 && ld.getYear() == 2022) {
                        return true;
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    static boolean isIdValid(String email, PKGConnector pkgConnector, BufferedWriter bufferedWriter,AtomicInteger atomicInteger,CountDownLatch latch) {
        try {
            String userIdJson = pkgConnector.getJson("https://platform.vedantu.com/platform/getforwarder?forwardTo=/platform/user/getUsers&callingUserId=4102395418282523&query=" + email + "&size=20&start=0");
            JSONObject userIdJsonObject = new JSONObject(userIdJson);
            JSONArray userJsonArray = userIdJsonObject.getJSONArray("users");
            Long userId = null;
            if (userJsonArray.length() > 0) {
                userId = userJsonArray.getJSONObject(0).getLong("userId");
            }
            if (userId != null) {
                String orderJson = pkgConnector.getJson("https://platform.vedantu.com/platform/getforwarder?forwardTo=/platform/dinero/account/getOrders&callingUserId=4102395418282523&limit=10&start=0&userId="+userId);
                JSONArray orderJsonArray = new JSONArray(orderJson);
                for (int i = 0; i < orderJsonArray.length(); i++) {

                    JSONObject obj=orderJsonArray.getJSONObject(i);
                    Long epoch = obj.getLong("creationTime");
                    String PAID = obj.getString("paymentStatus");
                    LocalDate ld = Instant.ofEpochMilli(epoch).atZone(ZoneId.systemDefault()).toLocalDate();
                    //if (ld.getMonth().getValue() == 6 && ld.getYear() == 2022 && obj.getDouble("amount")>=400) {
                    if (ld.getMonth().getValue() == 6 && ld.getYear() == 2022 && obj.getDouble("amount")>=400 && "PAID".equalsIgnoreCase(PAID)) {
                        String line="YES" + "," + email;
                        bufferedWriter.write(line);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                        return true;
                    }
                }

            } else {
                String line = "NA" + "," + email;
                //bufferedWriter.write(line);
               // bufferedWriter.newLine();
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(atomicInteger.incrementAndGet()+"->" +"executed." );
        latch.countDown();
        return false;
    }


    public static ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }
}
