package com.ballistic.token_test.vo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Nabeel on 12/1/2017.
 */
public class TestExtend<T, O, R> {

    private T t;
    private O o;
    private R r;


    public TestExtend(T t, O o, R r) {
        this.t = t;
        this.o = o;
        this.r = r;
    }

    public T getT() { return t; }

    public void setT(T t) { this.t = t; }

    public O getO() { return o; }

    public void setO(O o) { this.o = o; }

    public R getR() { return r; }

    public void setR(R r) { this.r = r; }


    public static class Nabeel<A> {
       private A a;

        public Nabeel(A a) {
            this.a = a;
        }

        public A getA() { return a; }

        public void setA(A a) { this.a = a; }

        @Override
        public String toString() {
            return "Nabeel{" + "a=" + a + '}';
        }

    }

    public static void main(String[] args){
        Set<User> users = getUsers();
        Map<String, Set<? extends User>> differentObject = new HashMap<>();
        differentObject.put("1", users);
        differentObject.put("2", users);
        differentObject.forEach((key, value) ->
                value.forEach(user ->
                        System.out.println(key+ "   " + user.toString())));
    }

    public static Set<User> getUsers() {
        Set<User> users = new HashSet<User>();
        User user1 = new User();
        user1.setEmail("Nabeel ahmed");
        user1.setId(1);
        user1.setName("xyz");
        User user2 = new User();
        user2.setEmail("Nabeel ahmed");
        user2.setId(2);
        user2.setName("xyz");
        User user3 = new User();
        user3.setEmail("Nabeel ahmed");
        user3.setId(3);
        user3.setName("xyz");
        User user4 = new User();
        user4.setEmail("Nabeel ahmed");
        user4.setId(4);
        user4.setName("xyz");
        User user5 = new User();
        user5.setEmail("Nabeel ahmed");
        user5.setId(5);
        user5.setName("xyz");
        User user6 = new User();
        user6.setEmail("Nabeel ahmed");
        user6.setId(6);
        user6.setName("xyz");
        users.add(user1); users.add(user2); users.add(user3);
        users.add(user4);users.add(user5);users.add(user6);
        return users;
    }

    public static class User{

        private Integer id;
        private String name;
        private String email;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "User{" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + '}';
        }
    }
}
