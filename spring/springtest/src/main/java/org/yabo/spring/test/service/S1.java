package org.yabo.spring.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S1 {
    @Autowired
    private S2 s2;
}
