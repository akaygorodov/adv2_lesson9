package com.alevel;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class UserValidatorTest {

    @InjectMocks
    UserValidator unit;

    @Mock
    UserRepository userRepositoryMock;

    @Test
    public void validatePassword_nominal() {
        boolean result = unit.validatePassword("fvgbhnjyqgh1");
        Assert.assertTrue(result);
    }

    @Test
    public void validatePassword_fail_length() {
        boolean result = unit.validatePassword("qweqwe");
        Assert.assertFalse(result);
    }

    @Test
    public void validatePassword_fail_character() {
        boolean result = unit.validatePassword("2345677654");
        Assert.assertFalse(result);
    }

    @Test
    public void validateLogin_nominal() {
        Mockito.when(userRepositoryMock.existByLogin(any())).thenReturn(false);
        boolean result = unit.validateLogin("qweweq");
        Assert.assertTrue(result);
    }
}
