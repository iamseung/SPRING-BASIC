package com.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonService {
    // 싱글톤은 자기 자신을 내부의 private 으로 가지고 있음
    private static final SingletonService instance = new SingletonService();

   public static SingletonService getInstance() {
       return instance;
   }

   private SingletonService() {
   }

   public void logic() {
       System.out.println("싱글톤 객체 로직 호출");
   }
}