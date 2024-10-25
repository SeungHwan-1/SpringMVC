package com.ohgiraffers.chap05interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//spring 의 빈 설정 클래스
@Configuration      //얘자체도 빈이지만 스프링에 사용할 빈을 설정
public class WebConfiguration implements WebMvcConfigurer {
                                            // spring mvc 설정 추가 용도
                                            // 이안에 인터셉트 추가하는 메소드있는데
                                            // 그거쓰려구
    @Autowired
    private StopWatchInterceptor stopWatchInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //인터셉터 등록
        registry.addInterceptor(stopWatchInterceptor)
                //stopwatch 경로에 등록한 인터셉터 적용
                .addPathPatterns("/stopwatch") //여기로 들어오면 실행될 경로
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/images/**");
    }
}
