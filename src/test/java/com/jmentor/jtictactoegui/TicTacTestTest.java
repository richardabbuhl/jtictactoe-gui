package com.jmentor.jtictactoegui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.JLabel;
import java.awt.event.MouseEvent;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TicTacTestTest {

    private TicTacTest ticTacTest;

    @BeforeEach
    public void setUp() {
        ticTacTest = new TicTacTest();
        ticTacTest.init();
    }

    @Test
    public void testInitGameBoard() {
        ticTacTest.initGameBoard();
        for (int i = 0; i < ticTacTest.jLabel.length; i++) {
            assertNull(ticTacTest.jLabel[i].getIcon());
            assertEquals(javax.swing.BorderFactory.createLineBorder(java.awt.Color.black, 1), ticTacTest.jLabel[i].getBorder());
        }
        assertEquals(ticTacTest.O_SQUARE, ticTacTest.player);
        assertEquals(ticTacTest.playerTypes[ticTacTest.jPlayer1Combo.getSelectedIndex()], ticTacTest.jPlayer1Info.getText().split(": ")[1]);
        assertEquals(ticTacTest.playerTypes[ticTacTest.jPlayer2Combo.getSelectedIndex()], ticTacTest.jPlayer2Info.getText().split(": ")[1]);
        assertEquals("Weights loaded = " + ticTacTest.weightsLoaded, ticTacTest.jInfo.getText());
    }

    @Test
    public void testLoadImage() {
        String filename = "deploy/cross.gif";
        InputStream inputStream = mock(InputStream.class);
        try {
            when(inputStream.available()).thenReturn(1);
            when(inputStream.read(any(byte[].class))).thenReturn(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            doReturn(inputStream).when(ticTacTest).getResourceAsStream(filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(ticTacTest.loadImage(filename));
    }

    @Test
    public void testLabelMousePressed() {
        JLabel label = new JLabel();
        MouseEvent mouseEvent = mock(MouseEvent.class);
        ticTacTest.label_mousePressed(mouseEvent, label, 0);
        assertEquals(ticTacTest.O_SQUARE, ticTacTest.board.Get(0));
        assertEquals(ticTacTest.X_SQUARE, ticTacTest.player);
    }
}
