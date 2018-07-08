import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;

/**
 * Created by axb4725 on 4/17/17.
 */
public class FindDupes {


        public static void main(String[] args) {
            try {
                List<String> lines1 = Files.readAllLines(Paths.get(args[0]));
                List<Data> dataList1 = new ArrayList<>();
                Set<String> emailIds = new HashSet<>();
                for(String line : lines1){
                    String[] inputToken = line.split(",");
                    Data data = new Data(inputToken[0].trim(),inputToken[1].trim(),inputToken[2].trim());
                    dataList1.add(data);
                    emailIds.add(data.emailId);
                }

                HashMap<String,ArrayList<Data>> hashMap = new HashMap<>();

                for(String emailId : emailIds){
                    ArrayList<Data> groupBydata = new ArrayList<>();
                    for(Data data : dataList1){
                        if(emailId.equals(data.emailId)){
                            groupBydata.add(data);
                        }
                    }
                    hashMap.put(emailId, groupBydata);
                }

                HashMap<String,ArrayList<Data>> hashMap1 = new HashMap<>();
                HashMap<String,ArrayList<Data>> hashMap2 = new HashMap<>();
                HashMap<String,ArrayList<Data>> hashMap3 = new HashMap<>();

                for (Map.Entry<String, ArrayList<Data>> entry : hashMap.entrySet()){
                    int count = 0;
                    for(Data data : entry.getValue()){
                        if(!("#N/A").equals(data.memberId)){
                            count++;

                        }

                    }
                    if(count == 1){
                        hashMap1.put(entry.getKey(), entry.getValue());
                    }
                    if(count==0){

                        hashMap2.put(entry.getKey(), entry.getValue());

                    }
                    if(count > 1){

                        hashMap3.put(entry.getKey(), entry.getValue());

                    }
                }



                System.out.println("***********************************************");

                System.out.println("One cross ref total size:" + hashMap1.size() );
                int onecrossToDelete = 0;
                int check =0;

                for(Map.Entry<String, ArrayList<Data>> entry : hashMap1.entrySet()){
                    for(Data data : entry.getValue()){
                        if(("#N/A").equals(data.memberId)){
                            System.out.println(data.svocId);
                            onecrossToDelete++;

                        }
                        else{
                            check++;
                        }
                    }
                }
                System.out.println("One cross ref with N/A, Size:"+ onecrossToDelete);
                System.out.println("***********************************************");


                System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

                System.out.println("No cross ref total size:" + hashMap2.size() );
                for(Map.Entry<String, ArrayList<Data>> entry : hashMap2.entrySet()){

                    for(int i=0; i<entry.getValue().size()-1;i++){
                        Data data = entry.getValue().get(i);
                        System.out.println(data.svocId);

                    }
                }
                System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");


                HashMap<String,ArrayList<Data>> multilpleToMutipleHashMap = new HashMap<>();
                HashMap<String,ArrayList<Data>> SameWCSIDHashMap = new HashMap<>();
                HashMap<String,ArrayList<Data>> hashMap6 = new HashMap<>();

                for(Map.Entry<String, ArrayList<Data>> entry : hashMap3.entrySet()){
                    Set<String> multipleWCS = new HashSet<>();
                    List <String> multipleToMultiple = new ArrayList<>();
                    List <String> sameWcsId = new ArrayList<>();


                    for(Data data : entry.getValue()){
                        if(!("#N/A").equals(data.memberId)) {
                            multipleWCS.add(data.memberId);
                        }


                    }
                    if(multipleWCS.size() > 1){
                        multilpleToMutipleHashMap.put(entry.getKey(), entry.getValue());

                    }
                    else if(multipleWCS.size() == 1){
                        SameWCSIDHashMap.put(entry.getKey(), entry.getValue());

                    }

                    else{
                        hashMap6.put(entry.getKey(), entry.getValue());

                    }


                }


                System.out.println("----------------------------------");
                System.out.println("Same WCS memberIds");
                for(Map.Entry<String, ArrayList<Data>> entry : SameWCSIDHashMap.entrySet()){
                /*for(Data data : entry.getValue()){
                    System.out.println(data.svocId);
                }*/
                    for(int i=0; i<entry.getValue().size()-1;i++){
                        Data data = entry.getValue().get(i);
                        System.out.println(data.svocId);

                    }

                }
                System.out.println("----------------------------------");


                Connection con = initiateDB();

                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                System.out.println("Multilple memberIds loosers:");



                for(Map.Entry<String, ArrayList<Data>> entry : multilpleToMutipleHashMap.entrySet()) {

                    List<Data> loosers = check_userreg(con, entry.getValue());
                    for (Data data: loosers){
                        System.out.println(data.svocId);
                    }
                }

                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");


            } catch(Exception e){

            }


        }

        public static Connection initiateDB(){
            String jdbcClassName="com.ibm.db2.jcc.DB2Driver";
            String url="jdbc:db2://rprsa070.homedepot.com:60160/RPR020SA";
            String user="tauser03";
            String pass="webster6";

            Connection connection = null;
            try {
                Class.forName(jdbcClassName);
                connection = (Connection) DriverManager.getConnection(url, user, pass);



            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return connection;
        }

        public  static List<Data> check_userreg(Connection connection, ArrayList<Data> memData) throws SQLException {
            List<Data > loser = new ArrayList<>();
            Statement stmt = connection.createStatement();
            for (Data memId: memData) {
                if(memId.memberId.equals("#N/A")){
                    loser.add(memId);
                }
                else {
                    ResultSet rs = stmt.executeQuery("select * from USERREG where USERS_ID=" + memId.memberId);
                    if (!rs.next()) {
                        loser.add(memId);
                    }

                    rs.close();
                }
            }
            stmt.close();
            if(loser.size()!=memData.size()-1){
                System.out.print("lol");
            }
            return loser;
        }






        public static  class Data {
            public String svocId;
            public String emailId;
            public String memberId;
            public Data(String emailId, String svocId, String memberId){
                this.emailId=emailId;
                this.svocId = svocId;
                this.memberId= memberId;
            }
        }
    }

















//System.out.println("list1 size:"+list3.size());

            /*Set<String> uniqueEmailIdsMaster = new HashSet<>();
            Set<String> uniqueEmailIdsDeleted = new HashSet<>();


            for (Data data : list3) {
                uniqueEmailIdsMaster.add(data.emailId.trim());
            }

            System.out.println("unique emails from master:"+uniqueEmailIdsMaster.size());
            System.out.println("-----------------------------------------");


            System.out.println("Emails to be deleted in IAM");

            for(String svocId : lines2) {

                for (Data data : list3) {
                    if(data.svocId.trim().equals(svocId.trim())){
                        //System.out.println(data.emailId);
                        uniqueEmailIdsDeleted.add(data.emailId);

                    }

                }
            }
            for(String deleted : uniqueEmailIdsDeleted){
                System.out.println(deleted);

            }



            System.out.println("-----------------------------------------");

            System.out.println("outstanding emails ");

            for(String email : uniqueEmailIdsMaster){
                boolean found = false;
                for(String deleted : uniqueEmailIdsDeleted){
                    if(deleted.trim().equals(email)){
                        found = true;
                        break;
                    }
                }
                if(!found){
                    System.out.println(email);
                }
            }*/

