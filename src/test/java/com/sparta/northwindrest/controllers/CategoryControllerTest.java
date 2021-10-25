package com.sparta.northwindrest.controllers;

import com.sparta.northwindrest.entities.CategoryEntity;
import com.sparta.northwindrest.repositories.CategoryRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CategoryControllerTest {

    @Autowired
    private CategoryController controller;
    private CategoryRepository mockRepository;

    @BeforeAll
    static void initAll(TestInfo info) {
        System.out.println(info.getDisplayName() + " starting!\n-----------");
    }

    @BeforeEach
    void init(TestInfo testInfo) {
        mockRepository = mock(CategoryRepository.class);
        List<CategoryEntity> list = new ArrayList<>();
        CategoryEntity c1 = new CategoryEntity();
        CategoryEntity c2 = new CategoryEntity();
        CategoryEntity c3 = new CategoryEntity();
        c1.setId(1);
        c2.setId(2);
        c3.setId(3);
        c1.setCategoryName("Red Foods");
        c2.setCategoryName("Orange Foods");
        c3.setCategoryName("Green Vegetables");
        c1.setDescription("Cherries, tomatoes and other red food");
        c2.setDescription("Carrots, pumpkins, satsumas, etc.");
        c3.setDescription("Peas, beans and broccoli");
        list.add(c1);
        list.add(c2);
        list.add(c3);
        controller.getCategoryService().setCategoryRepository(mockRepository);
        when(mockRepository.findAll()).thenReturn(list);
        System.out.println("\"" + testInfo.getDisplayName() + "\" is running...");
    }

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    @DisplayName("Get all category names without specifying keywords")
    void getCategoryDescriptions_NoKeywords_ReturnCorrectNames() {
        List<String> expectedNames = Arrays.asList("Red Foods", "Orange Foods", "Green Vegetables");
        List<String> actualNames = new ArrayList<>();
        controller.getCategoryDescriptions(null).forEach(dto -> actualNames.add(dto.getName()));
        assertEquals(expectedNames, actualNames);
    }

    @Test
    @DisplayName("Get all category descriptions without specifying keywords")
    void getCategoryDescriptions_NoKeywords_ReturnCorrectDescriptions() {
        List<String> expectedDescriptions = Arrays.asList("Cherries, tomatoes and other red food",
                "Carrots, pumpkins, satsumas, etc.",
                "Peas, beans and broccoli");
        List<String> actualDescriptions = new ArrayList<>();
        controller.getCategoryDescriptions(null).forEach(dto -> actualDescriptions.add(dto.getDescription()));
        assertEquals(expectedDescriptions, actualDescriptions);
    }

    @Test
    @DisplayName("Get category descriptions while specifying a keyword")
    void getCategoryDescriptions_UsingSingleKeyword_ReturnCorrectCategoryDescriptions() {
        List<String> keywords = Arrays.asList("green");
        List<String> expectedNames = Arrays.asList("Green Vegetables");
        List<String> expectedDescriptions = Arrays.asList("Peas, beans and broccoli");
        List<String> actualNames = new ArrayList<>();
        controller.getCategoryDescriptions(keywords).forEach(dto -> actualNames.add(dto.getName()));
        assertEquals(expectedNames,actualNames);
        List<String> actualDescriptions = new ArrayList<>();
        controller.getCategoryDescriptions(keywords).forEach(dto -> actualDescriptions.add(dto.getDescription()));
        assertEquals(expectedDescriptions,actualDescriptions);
    }

    @Test
    @DisplayName("Get category descriptions while specifying multiple keywords")
    void getCategoryDescriptions_UsingMultipleKeywords_ReturnCorrectCategoryDescriptions() {
        List<String> keywords = Arrays.asList("cherries", "vegetables");
        List<String> expectedNames = Arrays.asList("Red Foods", "Green Vegetables");
        List<String> expectedDescriptions = Arrays.asList("Cherries, tomatoes and other red food",
                "Peas, beans and broccoli");
        List<String> actualNames = new ArrayList<>();
        controller.getCategoryDescriptions(keywords).forEach(dto -> actualNames.add(dto.getName()));
        assertEquals(expectedNames,actualNames);
        List<String> actualDescriptions = new ArrayList<>();
        controller.getCategoryDescriptions(keywords).forEach(dto -> actualDescriptions.add(dto.getDescription()));
        assertEquals(expectedDescriptions,actualDescriptions);
    }

    @Test
    @Disabled()
    @DisplayName("Get category descriptions by id")
    void getCategoryDescriptionsById_UsingId_ReturnCorrectCategoryDescriptions() {
        //List<String> actualNames = new ArrayList<>();
        //controller.getCategoryDescriptionsById(2).forEach(dto -> actualNames.add(dto.getName()));
        //assertEquals(Arrays.asList("Orange Foods"), actualNames);
        //List<String> actualDescriptions = new ArrayList<>();
        //controller.getCategoryDescriptionsById(2).forEach(dto -> actualNames.add(dto.getName()));
        //assertEquals(Arrays.asList("Carrots, pumpkins, satsumas, etc."), actualDescriptions);
    }

    @AfterEach
    void tearDown (TestInfo testInfo) {
        System.out.println("\"" + testInfo.getDisplayName() + "\" is finishing...");
    }

    @AfterAll
    static void tearDownAll(TestInfo testInfo) {
        System.out.println("-----------\n" + testInfo.getDisplayName() + " finished!");
    }

}
