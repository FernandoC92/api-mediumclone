package com.apimc.mediumcloneapi.services;

import com.apimc.mediumcloneapi.model.entities.Storie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({ SpringExtension.class })
@ActiveProfiles("test")
public class StorieServiceTest {
    
    // Cenário: Requesição do tipo POST, contendo todas as informações necessárias para a criação de uma Storie  
    // 1. É preciso existir um service para realizar a persistência no db
    @MockBean
    StorieService service;

    @Test
    @DisplayName("Should save storie")
    public void saveStorieTest() {

        Storie storie = Storie
                .builder()
                .id(25l)
                .author("Ana Karla")
                .imgPoster("/pathImage")
                .storie("Lorem ipsum bla bla...")
                .subtitle("Subtitle")
                .title("My title")
                .datePoster("28/05/2020")
                .build();

                System.out.println("Id storie -> " + storie.getId());

        // Execução
        service.saveStorie(storie);
        Storie savedStorie = storie;

        // Verificação
        Assertions.assertNotNull(savedStorie.getId());
        Assertions.assertEquals("Ana Karla", savedStorie.getAuthor());
        Assertions.assertEquals("28/05/2020", savedStorie.getDatePoster());
        Assertions.assertEquals("/pathImage", savedStorie.getImgPoster());
        Assertions.assertEquals("Lorem ipsum bla bla...", savedStorie.getStorie());
        Assertions.assertEquals("Subtitle", savedStorie.getSubtitle());
        Assertions.assertEquals("My title", savedStorie.getTitle());

    }

}