package com.apimc.mediumcloneapi.api.resource;

import java.util.Date;

import com.apimc.mediumcloneapi.controllers.dto.StorieDto;
import com.apimc.mediumcloneapi.model.entities.Storie;
import com.apimc.mediumcloneapi.services.StorieService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith({ SpringExtension.class })
@ActiveProfiles("test")
@WebMvcTest
@AutoConfigureMockMvc
public class StorieControllerTest {

    static String ANYWRITER_API = "/api/storie";

    @Autowired
    MockMvc mvc;

    @MockBean
    StorieService service;

    @Test
    @DisplayName("Should create storie with sucess")
    public void createStorieTest() throws Exception {

        StorieDto dto = StorieDto.builder().title("Marketing digital em tempos de crise")
                .subtitle("A importância do marketing digital para sua empresa durante a pandemia")
                .imgPoster("path/image/poster")
                .storie("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In faucibus leo eget ante facilisis, non ornare diam pellentesque. Donec consectetur consectetur ipsum sed feugiat. Suspendisse gravida leo egestas ipsum luctus, non mattis leo gravida. Cras gravida risus non enim lacinia aliquet. Etiam vulputate felis et nisl consectetur mollis.")
                .author("Ana Karla").datePoster(new Date()).build();

        Storie savedStorie = Storie.builder().id(1L).title("Marketing digital em tempos de crise")
                .subtitle("A importância do marketing digital para sua empresa durante a pandemia")
                .imgPoster("path/image/poster")
                .storie("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In faucibus leo eget ante facilisis, non ornare diam pellentesque. Donec consectetur consectetur ipsum sed feugiat. Suspendisse gravida leo egestas ipsum luctus, non mattis leo gravida. Cras gravida risus non enim lacinia aliquet. Etiam vulputate felis et nisl consectetur mollis.")
                .author("Ana Karla").datePoster(new Date()).build();

        String json = new ObjectMapper().writeValueAsString(dto);

        

        BDDMockito.given(service.save(Mockito.any(Storie.class))).willReturn(savedStorie);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(ANYWRITER_API)
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(json);

        mvc.perform(request).andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("title").value(dto.getTitle()))
                .andExpect(MockMvcResultMatchers.jsonPath("subtitle").value(dto.getSubtitle()))
                .andExpect(MockMvcResultMatchers.jsonPath("imgPoster").value(dto.getImgPoster()))
                .andExpect(MockMvcResultMatchers.jsonPath("storie").value(dto.getStorie()))
                .andExpect(MockMvcResultMatchers.jsonPath("datePoster").value(dto.getDatePoster()));
    }

}