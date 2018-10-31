package com.packt.abuzar.mvvm;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PresenterTest {

    @Mock
    private  MainContractor.MainView mainView;

    MainPresenter mainPresenter;

    @Before
    public void setupMainPresenter()
    {
        MockitoAnnotations.initMocks(this);
        mainPresenter=new MainPresenter(mainView);
    }

    @Test
    public void testOnClick()
    {
        mainPresenter.onButtonClick("Test String");
    }

}
