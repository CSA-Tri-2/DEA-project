package com.nighthawk.spring_portfolio.mvc.fib;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class FibRequest {
    private int length;
}
