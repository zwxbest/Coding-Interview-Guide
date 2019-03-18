package cp01._04;

import base.BaseTest;
import org.junit.Test;

/**
 * @author zhangweixiao - 19-3-18
 */
public class CatDogQueueTest extends BaseTest {


    private CatDogQueue catDogQueue = new CatDogQueue();

    @Test
    public void test() {

        Dog dog1 = new Dog();
        catDogQueue.add(dog1);
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        catDogQueue.add(cat1);
        catDogQueue.add(cat2);
        Dog dog2 = new Dog();
        catDogQueue.add(dog2);

        assertEqual(catDogQueue.pollAll(), dog1);
        assertEqual(catDogQueue.pollDog(), dog2);
        assertEqual(catDogQueue.pollCat(), cat1);
        assertEqual(catDogQueue.pollCat(), cat2);
        assertEqual(catDogQueue.isEmpty(), true);
        assertEqual(catDogQueue.isDogEmpty(), true);
        assertEqual(catDogQueue.isCatEmpty(), true);

    }
}
