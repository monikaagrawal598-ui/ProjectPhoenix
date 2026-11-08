package com.phoenix;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PhoenixHealthTest {

    @Test
    void applicationShouldBeRunning() {
        assertEquals("RUNNING", PhoenixApplication.getStatus());
    }
}