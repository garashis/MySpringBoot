package com.example.demo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MyServiceTest {
    MyService myService = new MyService();

    @Mock
    InputStream in;

    @Test
    void servicing_with_mockConstructionWithAnswer() throws IOException {
        try (MockedStatic<PGPUtils> pgpUtilsMockedStatic = Mockito.mockStatic(PGPUtils.class);
             MockedConstruction<PGPService> pgpServiceMockedConstruction =
                     mockConstructionWithAnswer(PGPService.class, invocation -> 10)) {
            pgpUtilsMockedStatic.when(() -> PGPUtils.getStream(in)).thenReturn(in);
            Assertions.assertEquals(10, myService.servicing(in));
            Assertions.assertEquals(1, pgpServiceMockedConstruction.constructed().size());

            // Get the first mock
            PGPService pgpService = pgpServiceMockedConstruction.constructed().get(0);
        }
    }
    @Test
    void servicing() throws IOException {
        try (MockedStatic<PGPUtils> pgpUtilsMockedStatic = Mockito.mockStatic(PGPUtils.class);
             MockedConstruction<PGPService> pgpServiceMockedConstruction = mockConstruction(PGPService.class, (mock, context) -> {
                 when(mock.operation(any())).thenReturn(10);
             })) {
            pgpUtilsMockedStatic.when(() -> PGPUtils.getStream(in)).thenReturn(in);
            Assertions.assertEquals(10, myService.servicing(in));
            Assertions.assertEquals(1, pgpServiceMockedConstruction.constructed().size());

            // Get the first mock
            PGPService pgpService = pgpServiceMockedConstruction.constructed().get(0);


        }
    }
}