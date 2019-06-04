package com.example.greendaogenerator;


import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class Generador {

    public static void main(String[]args){

        Schema schema = new Schema(1, "com.appsng.greendaoapp.db"); // Your app package name and the (.db) is the folder where the DAO files will be generated into.
        schema.enableKeepSectionsByDefault();

        addTables(schema);

        try {
            new DaoGenerator().generateAll(schema,"./app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        private static void addTables(final Schema schema) {
            addUserEntities(schema);
            // addPhonesEntities(schema);
        }

        // This is use to describe the colums of your table
        private static Entity addUserEntities(final Schema schema) {
            Entity user = schema.addEntity("User");
            user.addIdProperty().primaryKey().autoincrement();
            user.addIntProperty("user_id").notNull();
            user.addStringProperty("last_name");
            user.addStringProperty("first_name");
            user.addStringProperty("email");
            return user;
        }

        //    private static Entity addPhonesEntities(final Schema schema) {
        //        Entity phone = schema.addEntity("Phone");
        //        phone.addIdProperty().primaryKey().autoincrement();
        //        phone.addIntProperty("user_id").notNull();
        //        phone.addStringProperty("number");
        //        return phone;
        //    }
}

