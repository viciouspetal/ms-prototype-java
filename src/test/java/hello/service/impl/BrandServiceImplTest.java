package hello.service.impl;

import hello.model.Brand;
import hello.repositories.BrandRepository;
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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BrandServiceImplTest {

    @Mock
    private BrandRepository brandRepositoryMock;

    @InjectMocks
    private BrandServiceImpl brandService = new BrandServiceImpl();

    @Test
    public void list_when_brandsExist_then_listOfBrandsIsReturned() {
        List<Brand> existingBrands = Arrays.asList(new Brand("brand 1", "owner 1"), new Brand("brand 2", "owner 2"));

        when(brandRepositoryMock.findAll()).thenReturn(existingBrands);

        List<Brand> brands = brandService.list();
        assertThat(brands, hasSize(2));
        assertThat(brands.get(0).getName(), is("brand 1"));
        assertThat(brands.get(0).getOwner(), is("owner 1"));
        assertThat(brands.get(1).getName(), is("brand 2"));
        assertThat(brands.get(1).getOwner(), is("owner 2"));

        verify(brandRepositoryMock).findAll();
    }

    @Test
    public void create_when_validBrandProvided_then_brandIsPersisted() {
        Brand toBeSaved = new Brand();
        toBeSaved.setName("Brand1");
        toBeSaved.setOwner("Owner1");
        when(brandRepositoryMock.save(toBeSaved)).thenReturn(new Brand());

        Brand result = brandService.create(toBeSaved);

        assertThat(result, notNullValue());
        ArgumentCaptor<Brand> brandCaptor = ArgumentCaptor.forClass(Brand.class);
        verify(brandRepositoryMock).save(brandCaptor.capture());
        Brand capturedBrand = brandCaptor.getValue();
        assertThat(capturedBrand.getName(), is(toBeSaved.getName()));
        assertThat(capturedBrand.getOwner(), is(toBeSaved.getOwner()));
    }

    @Test
    public void update_when_validBrandProvided_then_brandIsUpdated() {
        Brand toBeSaved = new Brand();
        toBeSaved.setName("Brand1");
        toBeSaved.setOwner("Owner1");
        when(brandRepositoryMock.save(toBeSaved)).thenReturn(new Brand());

        Brand result = brandService.update(toBeSaved);

        assertThat(result, notNullValue());
        ArgumentCaptor<Brand> brandCaptor = ArgumentCaptor.forClass(Brand.class);
        verify(brandRepositoryMock).save(brandCaptor.capture());
        Brand capturedBrand = brandCaptor.getValue();
        assertThat(capturedBrand.getName(), is(toBeSaved.getName()));
        assertThat(capturedBrand.getOwner(), is(toBeSaved.getOwner()));
    }

    @Test
    public void delete_when_brandToBeDeletedExists_then_brandIsDeleted() {
        Brand toBeDeleted = new Brand("name", "owner");
        brandService.delete(toBeDeleted);

        ArgumentCaptor<Brand> brandCaptor = ArgumentCaptor.forClass(Brand.class);
        verify(brandRepositoryMock).delete(brandCaptor.capture());
        Brand capturedBrand = brandCaptor.getValue();
        assertThat(capturedBrand.getName(), is(toBeDeleted.getName()));
        assertThat(capturedBrand.getOwner(), is(toBeDeleted.getOwner()));

        verify(brandRepositoryMock).delete(toBeDeleted);
    }

    @Test
    public void delete_when_idToBeDeletedDoesntExist_then_noBrandIsDeleted() {
        when(brandRepositoryMock.findById("id")).thenReturn(null);

        brandService.delete("id");

        verify(brandRepositoryMock, never()).delete(Mockito.any(Brand.class));
    }
    @Test
    public void delete_when_idToBeDeletedExists_then_brandforThatIdIsDeleted() {
        Optional<Brand> toBeDeleted = Optional.of(new Brand("name", "owner"));
        when(brandRepositoryMock.findById("id")).thenReturn(toBeDeleted);

        brandService.delete("id");

        verify(brandRepositoryMock).delete(toBeDeleted.get());
    }

}