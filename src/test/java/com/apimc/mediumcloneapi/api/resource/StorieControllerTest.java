package com.apimc.mediumcloneapi.api.resource;

import java.util.ArrayList;
import java.util.List;

import com.apimc.mediumcloneapi.controllers.dto.StorieDto;
import com.apimc.mediumcloneapi.model.entities.Storie;
import com.apimc.mediumcloneapi.model.entities.Tag;
import com.apimc.mediumcloneapi.model.entities.Topic;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


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
    @DisplayName("Teste")
    public void name() throws Exception {
        Storie dto = Storie.builder().id(1L).build();
        BDDMockito.given(service.findById(Mockito.anyLong())).willReturn(dto);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/storie");
        
        mvc.perform(request).andExpect(status().isOk())
        .andExpect(jsonPath("id").value(1));
    }

    @Test
    @DisplayName("Should create storie with sucess")
    public void createStorieTest() throws Exception {

            String datePoster = "21/05/2020";
            Tag tag = new Tag(25L, "java");
            Topic topic = new Topic(20L, "programming");
            List<Tag> listTags = new ArrayList<>();
            listTags.add(tag);
            List<Topic> listTopics = new ArrayList<>();
            listTopics.add(topic);

            StorieDto dto = StorieDto.builder().id(1L).title("Marketing digital em tempos de crise")
                            .subtitle("A importância do marketing digital para sua empresa durante a pandemia")
                            .imgPoster("path/image/poster")
                            .storie("Lorem ipsum dolor sit amet consectetur adipiscing elit. In faucibus leo eget ante facilisis non ornare diam pellentesque. Donec consectetur consectetur ipsum sed feugiat.")
                            .author("Ana Karla").datePoster(datePoster).build();

            Storie savedStorie = Storie.builder().id(1L).title("Marketing digital em tempos de crise")
                            .subtitle("A importância do marketing digital para sua empresa durante a pandemia")
                            .imgPoster("path/image/poster")
                            .storie("Lorem ipsum dolor sit amet consectetur adipiscing elit. In faucibus leo eget ante facilisis non ornare diam pellentesque. Donec consectetur consectetur ipsum sed feugiat.")
                            .author("Ana Karla").datePoster(datePoster).build();

            String json = new ObjectMapper().writeValueAsString(dto);

            BDDMockito.given(service.saveStorie(Mockito.any(Storie.class))).willReturn(savedStorie);

            MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                            .post(ANYWRITER_API)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                            .content(json);

            System.out.println("Antes do peform");
            

            System.out.println(json);

            mvc.perform(request)
                            .andExpect(status().isCreated())
                            .andExpect(jsonPath("id").value(1))
                            .andExpect(jsonPath("title").value(dto.getTitle()))
                            .andExpect(jsonPath("subtitle").value(dto.getSubtitle()))
                            .andExpect(jsonPath("imgPoster").value(dto.getImgPoster()))
                            .andExpect(jsonPath("storie").value(dto.getStorie()))
                            .andExpect(jsonPath("author").value(dto.getAuthor()))
                            .andExpect(jsonPath("datePoster").value(dto.getDatePoster()));

            System.out.println("Depois do peform!");

    }
    
    

}