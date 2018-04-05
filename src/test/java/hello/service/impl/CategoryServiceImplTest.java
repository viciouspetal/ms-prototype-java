package hello.service.impl;

import hello.model.Brand;
import hello.model.Category;
import hello.repositories.CategoryRepository;
import hello.service.CategoryService;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepositoryMock;

    @InjectMocks
    private CategoryService categoryService = new CategoryServiceImpl();

    @Test
    public void list_when_categoriesExist_then_listOfCategoriesIsReturned() {
        List<Category> existingCategories = Arrays.asList(generateCategory(), generateCategory("123456789", "TVs", "Electronics"));

        when(categoryRepositoryMock.findAll()).thenReturn(existingCategories);

        List<Category> result = categoryService.list();

        assertThat(result, hasSize(2));
        assertThat(result.get(0).getName(), is("name"));
        assertThat(result.get(0).getDepartment(), is("dept"));
        assertThat(result.get(1).getName(), is("TVs"));
        assertThat(result.get(1).getDepartment(), is("Electronics"));
        verify(categoryRepositoryMock).findAll();
    }

    @Test
    public void create_when_validCategory_then_categoryIsCreated() {
        Category toBeSaved = generateCategory();
        when(categoryRepositoryMock.save(toBeSaved)).thenReturn(new Category());

        Category result = categoryService.create(toBeSaved);

        assertThat(result, notNullValue());
        ArgumentCaptor<Category> categoryCapture = ArgumentCaptor.forClass(Category.class);
        verify(categoryRepositoryMock).save(categoryCapture.capture());

        Category capturedCategory = categoryCapture.getValue();
        assertThat(capturedCategory.getName(), is(toBeSaved.getName()));
        assertThat(capturedCategory.getDepartment(), is(toBeSaved.getDepartment()));
    }

    @Test
    public void update_when_categoryExists_then_categoryIsUpdated() {
        Category existing = generateCategory();
        existing.setId(UUID.randomUUID().toString());

        Category toBeSaved = generateCategory(existing.getId(), "UpdatedCategory", "UpdatedDept");
        toBeSaved.setId(existing.getId());
        when(categoryRepositoryMock.getOne(existing.getId())).thenReturn(existing);

        categoryService.update(toBeSaved);

        ArgumentCaptor<Category> categoryArgumentCaptor = ArgumentCaptor.forClass(Category.class);
        verify(categoryRepositoryMock).save(categoryArgumentCaptor.capture());
        Category capturedBrand = categoryArgumentCaptor.getValue();
        assertThat(capturedBrand.getName(), is(toBeSaved.getName()));
        assertThat(capturedBrand.getDepartment(), is(toBeSaved.getDepartment()));
    }

    @Test
    public void delete_when_categoryToBeDeletedExists_then_categoryIsDeleted() {
        Category toBeDeleted = generateCategory();
        categoryService.delete(toBeDeleted);

        ArgumentCaptor<Category> categoryCaptor = ArgumentCaptor.forClass(Category.class);
        verify(categoryRepositoryMock).delete(categoryCaptor.capture());
        Category capturedBrand = categoryCaptor.getValue();
        assertThat(capturedBrand.getName(), CoreMatchers.is(toBeDeleted.getName()));
        assertThat(capturedBrand.getDepartment(), CoreMatchers.is(toBeDeleted.getDepartment()));

        verify(categoryRepositoryMock).delete(toBeDeleted);
    }

    @Test
    public void delete_when_idDoesNotExist_then_noCategoryIsDeleted(){
        when(categoryRepositoryMock.findById("id")).thenReturn(null);

        categoryService.delete("id");

        verify(categoryRepositoryMock).findById("id");
        verify(categoryRepositoryMock, never()).delete(Mockito.any(Category.class));
    }
    @Test
    public void delete_when_idToBeDeletedExists_then_categoryForThatIdIsDeleted() {
        Optional<Category> toBeDeleted = Optional.of(generateCategory());
        when(categoryRepositoryMock.findById("id")).thenReturn(toBeDeleted);

        categoryService.delete("id");

        verify(categoryRepositoryMock).delete(toBeDeleted.get());
    }


    private Category generateCategory() {
        Category cat = new Category();
        cat.setId("id");
        cat.setName("name");
        cat.setDepartment("dept");
        return cat;
    }

    private Category generateCategory(String id, String name, String dept) {
        Category cat = new Category();
        cat.setId(id);
        cat.setName(name);
        cat.setDepartment(dept);
        return cat;
    }
}