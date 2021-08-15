package com.steps;

import net.thucydides.core.steps.ScenarioSteps;

import com.pages.BasePage;
import com.tools.injector.AppInjector;

public class AbstractSteps extends ScenarioSteps {
    private static final long serialVersionUID = 1L;
    public BasePage basePage;

    public AbstractSteps() {
        AppInjector.getInjector().injectMembers(this);
    }
}
