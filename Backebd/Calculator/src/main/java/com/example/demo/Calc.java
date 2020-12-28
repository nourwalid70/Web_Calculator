package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Calc {
    @GetMapping("/add")
    public String Add(@RequestParam(value = "first") String a, @RequestParam(value = "second") String b) {
        Double x = Double.valueOf(a);
        Double y = Double.valueOf(b);
        return Double.toString(x + y);
    }

    @GetMapping("/sub")
    public String Sub(@RequestParam(value = "first") String a, @RequestParam(value = "second") String b) {
        Double x = Double.valueOf(a);
        Double y = Double.valueOf(b);
        return Double.toString(x - y);
    }

    @GetMapping("/mul")
    public String Mul(@RequestParam(value = "first") String a, @RequestParam(value = "second") String b) {
        Double x = Double.valueOf(a);
        Double y = Double.valueOf(b);
        return Double.toString(x * y);
    }

    @GetMapping("/div")
    public String Div(@RequestParam(value = "first") String a, @RequestParam(value = "second") String b) {
        Double x = Double.valueOf(a);
        Double y = Double.valueOf(b);
        if (y == 0) {
            return "E";
        } else {
            return Double.toString(x / y);
        }
    }

    @GetMapping("/square")
    public String Square(@RequestParam(value = "first") String a) {
        Double x = Double.valueOf(a);
        return Double.toString(Math.pow(x, 2));
    }

    @GetMapping("/squareR")
    public String SquareRoot(@RequestParam(value = "first") String a) {
        Double x = Double.valueOf(a);
        if (x < 0) {
            return "E";
        } else {
            return Double.toString(Math.sqrt(x));
        }
    }

    @GetMapping("/inverse")
    public String Inverse(@RequestParam(value = "first") String a) {
        Double x = Double.valueOf(a);
        if (x == 0) {
            return "E";
        } else {
            return Double.toString(1 / x);
        }
    }

    @GetMapping("/PM")
    public String Plus_Minus(@RequestParam(value = "first") String a) {
        Double x = Double.valueOf(a);
        if (x == 0) {
            return "0.0";
        } else {
            return Double.toString(x * (-1));
        }
    }

    @GetMapping("/percent")
    public String Percent(@RequestParam(value = "first") String a) {
        Double x = Double.valueOf(a);
        return Double.toString(x / 100);
    }
}
