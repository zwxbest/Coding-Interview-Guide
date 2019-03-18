package cp01._04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhangweixiao - 19-3-18
 */
public class CatDogQueue {

    private Queue<PetCount> catQueue = new LinkedList<>();

    private Queue<PetCount> dogQueue = new LinkedList<>();

    private int count = 0;

    public void add(Pet pet) {
        if (pet.getType().equals("dog")) {
            dogQueue.add(new PetCount(pet, count));
        } else if (pet.getType().equals("cat")) {
            catQueue.add(new PetCount(pet, count));
        } else {
            throw new RuntimeException("我只要猫或狗");
        }
    }

    public Pet pollAll() {
        PetCount catPeek = catQueue.peek();
        PetCount dogPeek = dogQueue.peek();

        if (catPeek.getCount() < dogPeek.getCount()) {
            catQueue.poll();
            return catPeek.getPet();
        } else {
            dogQueue.poll();
            return dogPeek.getPet();
        }
    }

    public Pet pollDog() {
        return dogQueue.poll().getPet();
    }

    public Pet pollCat() {
        return catQueue.poll().getPet();
    }

    public boolean isEmpty() {
        return catQueue.isEmpty() && dogQueue.isEmpty();
    }

    public boolean isDogEmpty() {
        return dogQueue.isEmpty();
    }

    public boolean isCatEmpty() {
        return catQueue.isEmpty();
    }


}
