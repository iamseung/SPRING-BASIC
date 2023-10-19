package com.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
    private String url;
    
    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }

    // 초기화 콜백 : 빈이 생성되고, 빈의 의존관계 주입이 완료된 후 호출
    @PostConstruct
    public void init() {
        connect();
        call("초기화 연결 메세지");
    }

    // 소멸전 콜백 : 빈이 소멸되기 직전에 호출
    @PreDestroy
    public void close() {
        disconnect();
    }
}
