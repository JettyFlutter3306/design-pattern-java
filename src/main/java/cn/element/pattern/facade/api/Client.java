package cn.element.pattern.facade.api;

public class Client {

    public static void main(String[] args) {
        GiftInfo giftInfo = new GiftInfo("《Spring5核心原理》");
        GiftFacadeService facadeService = new GiftFacadeService();
        facadeService.exchange(giftInfo);
    }

}
