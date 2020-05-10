package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestExample {
    @GetMapping("/api/tdd/{data}")
    public Response getData(@PathVariable("data") String data) {

        return new Response(data);
    }
    //inner class
    class Response {
        private String data;
        public Response(String data) {
            this.data = data;
        }
        public String getData() {
            return data;
        }
    }
}
