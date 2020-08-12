// package com.alex.shoppingcart;

// import com.alex.shoppingcart.model.ItemModel;
// import com.mongodb.BasicDBObject;

// import org.junit.After;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.mongodb.core.MongoTemplate;
// import org.springframework.test.context.ContextConfiguration;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
// import org.springframework.test.context.support.AnnotationConfigContextLoader;

// import java.util.List;

// import static org.junit.Assert.assertEquals;

// @RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(classes = MongoJavaConfig.class, loader = AnnotationConfigContextLoader.class)

// public class MongoTest {

//     @Autowired
//     private MongoTemplate mongoTemplate;

//     @Test
//     public void canInsertSuccessfully() {
//         ItemModel item;
        
//         item = new ItemModel("Bread", 2.99);
//         mongoTemplate.insert(item);
//         item = new ItemModel("Nutella", 7.99);
//         mongoTemplate.insert(item);

//         List<ItemModel> items = mongoTemplate.findAll(ItemModel.class);
//         items.forEach(i -> System.out.println(i.getId() + ":" + i.getDescription() + " will cost you " + i.getPrice()));
//         assertEquals(2,items.size());

//     }
//     @After
//     public void cleanUp() {
//         for (String collectionName : mongoTemplate.getCollectionNames()) {
//             if (!collectionName.startsWith("system.")) {
//                 mongoTemplate.getCollection(collectionName).remove(new BasicDBObject());
//             }
//         }
//     }
// }

