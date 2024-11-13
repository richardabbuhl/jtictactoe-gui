package com.jmentor.jtictactoegui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SwingWorkerTest {

    private SwingWorker swingWorker;

    @BeforeEach
    public void setUp() {
        swingWorker = new SwingWorker() {
            @Override
            public Object construct() {
                return "test";
            }
        };
    }

    @Test
    public void testConstruct() {
        assertEquals("test", swingWorker.construct());
    }

    @Test
    public void testFinished() {
        SwingWorker swingWorkerSpy = spy(swingWorker);
        doNothing().when(swingWorkerSpy).finished();
        swingWorkerSpy.finished();
        verify(swingWorkerSpy, times(1)).finished();
    }

    @Test
    public void testInterrupt() {
        Thread thread = mock(Thread.class);
        SwingWorker.ThreadVar threadVar = new SwingWorker.ThreadVar(thread);
        threadVar.clear();
        assertNull(threadVar.get());
    }
}
