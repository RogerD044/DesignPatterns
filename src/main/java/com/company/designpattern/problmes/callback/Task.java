package com.company.designpattern.problmes.callback;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class Task {
    private long timestamp;
    private Runnable callbackTask;
}
