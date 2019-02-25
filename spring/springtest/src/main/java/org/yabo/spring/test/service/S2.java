package org.yabo.spring.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S2 {
    @Autowired
    private S1 s1;
}
