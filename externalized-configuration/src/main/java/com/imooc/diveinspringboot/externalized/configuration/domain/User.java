package com.imooc.diveinspringboot.externalized.configuration.domain;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;


/**
 * 用户 Domain 类
 *
 * @author 小马哥
 * @since 2018-09-24
 */
@Validated
public class User {
    @Value("${user.name:linkaijun}")
    private String name;
    @Value("${user.age:36}")
    private Integer age;

    private Long id;

    private String wife;

    public String getWife() {
        return wife;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }



    private City city = new City();

    public static class City {

        private String postCode;
        @NotEmpty
        private String name;

        public String getPostCode() {
            return postCode;
        }

        public void setPostCode(String postCode) {
            this.postCode = postCode;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "City{" +
                    "postCode='" + postCode + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", wife=" + wife +
                ", city=" + city +
                '}';
    }
}
