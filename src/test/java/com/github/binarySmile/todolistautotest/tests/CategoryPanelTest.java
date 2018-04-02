package com.github.binarySmile.todolistautotest.tests;

import com.github.binarySmile.todolistautotest.core.BaseTest;
import com.github.binarySmile.todolistautotest.panels.panelCategory.Category;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertTrue;

public class CategoryPanelTest extends BaseTest {

    @Test
    public void createCategory() {
        page(Category.class).create(DATA.getProperty("CATEGORY_NAME"));
        assertTrue(page(Category.class).getByName(DATA.getProperty("CATEGORY_NAME")).isDisplayed());
    }

    @Test
    public void deleteCategory() {
        page(Category.class).create(DATA.getProperty("CATEGORY_NAME"));
        assertTrue(page(Category.class).getByName(DATA.getProperty("CATEGORY_NAME")).isDisplayed());
        page(Category.class).deleteCategory(DATA.getProperty("CATEGORY_NAME"));
    }
}
