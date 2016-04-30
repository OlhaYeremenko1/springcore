package ua.epam.spring.hometask.yeremenko.jdbc;


import org.springframework.stereotype.Component;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static ua.epam.spring.hometask.yeremenko.jdbc.SQlQuery.SQlQueryConst.*;

/**
 * Created by Olha_Yeremenko on 4/29/2016.
 */
public class SQlQuery {

    private String query;

    private SQlQuery(String query) {
        this.query = query;
    }

    /**
     * Ui sql builder s ql query builder.
     *
     * @return the s ql query builder
     */
    public static SQlQueryBuilder uiSqlBuilder() {
        return new SQlQuery(EMPTY).new SQlQueryBuilder();
    }

    //CONST
    public static class SQlQueryConst {


        public static final String AUDITORIUMS_TABLE_NAME = "auditoriums";
        public static final String AUDITORIUMS_TABLE_PARAMS = "ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), NAME CHAR(20), SEATS INTEGER, VIPS VARCHAR(100), PRIMARY KEY(ID)";

        public static final String EVENTS_TABLE_NAME = "events";
        public static final String EVENTS_TABLE_PARAMS = "ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), NAME VARCHAR(50), TICKET_PRICE FLOAT, RATING VARCHAR(10), DATES VARCHAR(50), AUDITORIUM_TIME VARCHAR(100), PRIMARY KEY(ID)";

        public static final String USERS_TABLE_NAME = "users";
        public static final String USERS_TABLE_PARAMS = "ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), FIRST_NAME CHAR(20), LAST_NAME CHAR(20), BIRTH_DATE VARCHAR(10), EMAIL VARCHAR(30), BOOKED_TICKETS VARCHAR(100), IS_LUCKY BOOLEAN DEFAULT FALSE, PRIMARY KEY(ID)";

        public static final String TICKETS_TABLE_NAME = "tickets";
        public static final String TICKETS_TABLE_PARAMS = "ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), USER_EMAIL VARCHAR(20), EVENT VARCHAR(50), DATE VARCHAR(10), SEAT_NUM INTEGER, PRIMARY KEY(ID)";

        public SQlQueryConst() {
        }
    }

    //BUILDER
    public class SQlQueryBuilder {

        private SQlQueryBuilder() {
            // private constructor
        }

        public String build() {
            return SQlQuery.this.query;
        }

        public SQlQueryBuilder createTable(String tableName, String params) {
            SQlQuery.this.query += "CREATE TABLE ";
            SQlQuery.this.query += tableName;
            SQlQuery.this.query += "(" + params + ")";
            return this;
        }

        public SQlQueryBuilder updateTable(String tableName) {
            SQlQuery.this.query += "UPDATE ";
            SQlQuery.this.query += tableName;
            return this;
        }

        public SQlQueryBuilder set(String column) {
            SQlQuery.this.query += "SET ";
            SQlQuery.this.query += column + " ";
            return this;
        }

        public SQlQueryBuilder values(String values) {
            SQlQuery.this.query += "VALUES (";
            SQlQuery.this.query += values + ") ";
            return this;
        }

        public  SQlQueryBuilder insertIntoAuditoriums(){
            SQlQuery.this.query += "INSERT INTO ";
            SQlQuery.this.query += AUDITORIUMS_TABLE_NAME+ "(NAME,SEATS,VIPS) ";
            return this;
        }

        public  SQlQueryBuilder insertIntoEvents(){
            SQlQuery.this.query += "INSERT INTO ";
            SQlQuery.this.query += EVENTS_TABLE_NAME+ "(NAME,TICKET_PRICE,RATING,DATES,AUDITORIUM_TIME) ";
            return this;
        }
        public  SQlQueryBuilder insertIntoUsers(){
            SQlQuery.this.query += "INSERT INTO ";
            SQlQuery.this.query += USERS_TABLE_NAME+ "(FIRST_NAME,LAST_NAME,BIRTH_DATE,EMAIL,BOOKED_TICKETS,IS_LUCKY) ";
            return this;
        }

        public  SQlQueryBuilder insertIntoTickets(){
            SQlQuery.this.query += "INSERT INTO ";
            SQlQuery.this.query += TICKETS_TABLE_NAME+ "(USER_EMAIL,EVENT,DATE,SEAT_NUM) ";
            return this;
        }



        public  SQlQueryBuilder select(String fields){
            SQlQuery.this.query += "SELECT ";
            SQlQuery.this.query +=fields;
            return this;
        }

        public  SQlQueryBuilder from(String tableName){
            SQlQuery.this.query += " FROM ";
            SQlQuery.this.query +=tableName;
            return this;
        }

        public  SQlQueryBuilder where(String params){
            SQlQuery.this.query += " WHERE ";
            SQlQuery.this.query +=params+" ";
            return this;
        }

        public  SQlQueryBuilder deleteFrom(String tableName){
            SQlQuery.this.query += " DELETE FROM ";
            SQlQuery.this.query +=tableName+" ";
            return this;
        }

    }


}
