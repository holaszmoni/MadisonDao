package com.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.tests.Test001ManageCartProducts;
import com.tests.Test002ManageWishlistProducts;

@RunWith(Suite.class)
@SuiteClasses({
    Test001ManageCartProducts.class,
    Test002ManageWishlistProducts.class,
})
public class TestsSuite {
}

