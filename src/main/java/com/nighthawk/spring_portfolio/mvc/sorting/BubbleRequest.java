package com.nighthawk.spring_portfolio.mvc.sorting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class BubbleRequest {
    private int length;
    private ArrayList<Integer> array;
}
