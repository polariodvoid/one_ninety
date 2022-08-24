//package com.polariodvoid.one_eighty.shoppingcart;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import java.util.List;
//
//import com.polariodvoid.one_eighty.CartItemRepository;
//import com.polariodvoid.one_eighty.Model.CartItem;
//import com.polariodvoid.one_eighty.Model.User;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Rollback;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.List;
//import javax.transaction.Transactional;
//import com.polariodvoid.one_eighty.Model.CartItem;
//import com.polariodvoid.one_eighty.Model.User;
//import com.polariodvoid.one_eighty.Model.Product;
//
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.polariodvoid.one_eighty.OneEightyApplication;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(false)
////@ExtendWith(SpringExtension.class)
////@Transactional
////@SpringBootTest(classes = OneEightyApplication.class)
//public class CartItemRepositoryTests {
//    @Autowired
//    private CartItemRepository cartItemRepository;
//    @Autowired private TestEntityManager entityManager;
//
//
//    @Test
//    public void testSaveItem() {
//        Integer userId = 1;
//        Integer productId = 1;
//
//        User user = entityManager.find(User.class, userId);
//        Product product = entityManager.find(Product.class, productId);
//
//        CartItem newItem = new CartItem();
//        newItem.setUser(user);
//        newItem.setProduct(product);
//        newItem.setQuantity(1);
//
//        CartItem savedItem = cartItemRepository.save(newItem);
//
//        assertThat(savedItem.getId()).isGreaterThan(0);
//    }
//    @Test
//    public void testFindByUser() {
//        System.out.println("Running testFindByUser...");
//        Integer userid = 2;
//        List<CartItem> result = cartItemRepository.findByUser(new User(userid));
//        result.forEach(System.out::println);
//        assertThat(result.size()).isEqualTo(2);
//    }
//
//        //assertEquals(givenUser , getUser())
//        //assertThat(result.size()).isEqualTo(2);
//
//
//        //cartItemRepository.save(user);
//        //User result = UserRepository.findByUser(user.getId());
//        //List<CartItem> result =  listCartItems(user);
//        //assertEquals(user.getId(), result.getId());
//
//        // }
//
//
////CartItem findByUserAndProduct(User user, Product product);
//
//
//        //}
////@DataJpaTest
////@AutoConfigureTestDatabase (replace = AutoConfigureTestDatabase.Replace.NONE)
////@Rollback(true)
////
////public class CartItemRepositoryTests {
////@Autowired private CartItemRepository repo;
////@Autowired private TestEntityManager entityManager;
//
////@Test
////    public void testSaveItem() {
////        CartItem item = new CartItem();
////        item.setQuantity(1);
////        item.setProduct(new Product());
////        item.setCart(new Cart());
////        entityManager.persist(item);
////        entityManager.flush();
////        repo.save(item);
//        //   }
//    }
//
