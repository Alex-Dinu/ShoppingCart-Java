// package com.alex.shoppingcart;

//  import com.mongodb.Mongo;
//  import com.mongodb.MongoClient;

// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
// //import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
// //import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
// //import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

// @Configuration                                                  //Q1
// @ComponentScan// if nothing isd specified, Java will look in the local package.
// public class MongoJavaConfig  extends AbstractMongoClientConfiguration{

//     @Override
//     protected String getDatabaseName() {
//         return "shoppingcart";
//     }

//     @Override
//     public Mongo mongo() throws Exception {
//         return new MongoClient("127.0.0.1", 27017);

//     }  
// }

