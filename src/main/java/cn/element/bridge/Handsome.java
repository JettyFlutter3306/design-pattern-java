package cn.element.bridge;

public class Handsome {

    public void pursues(Beauty beauty) {

        Gift gift = new WarmGift(new Flower());

        give(beauty, gift);
    }

    public void give(Beauty beauty, Gift gift) {
        System.out.println("gave beauty: " + gift.gift);
    }

}
